/**
 * 
 */
package traceability.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.stream.util.StreamReaderDelegate;

import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.index.TermPositionVector;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.spans.SpanNearQuery;
import org.apache.lucene.search.spans.SpanOrQuery;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.search.spans.Spans;
import org.apache.lucene.store.FSDirectory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.internal.keys.model.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TraceFactory;
//import org.eclipse.emf.common.util.EList;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.impl.TraceRecoveryFactoryImpl;
import traceability.fortran.FortranCodeIndexer;
import traceability.fortran.FortranSourceCodeAnalyzer;
import traceability.java.JavaParser;
import traceability.java.JavaParser.JMethod;
import traceability.java.JavaSourceCodeAnalyzer;
import traceability.java.JavaSourceCodeIndexer;
import traceability.java.KeywordAnalyzer;

/**
 * the controller that will start to control all the search capabilities of
 * everything.
 * 
 * @author taher
 * 
 */
public class Search {
	private Indexer index;
	private PerFieldAnalyzerWrapper analyzer;
	private Directory dir;

	/**
	 * will run to try to link between the objects.
	 * 
	 * @param query
	 *            the query(s) that the user is searching for
	 * @param dir
	 *            the directory that the file is found in
	 * @return returns all the links created
	 * @throws IOException
	 *             could throw an IOException
	 */
	public ArrayList<Link> runRecoveryMEToCode(Query query, Directory dir)
			throws IOException {
		try {
			File indexDir = new File(dir.getPath());

			analyzer.addAnalyzer("import", new KeywordAnalyzer());

			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			IndexSearcher is = new IndexSearcher(fsDir);

			QueryParser parser = new QueryParser("code", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			ArrayList<Link> links = new ArrayList<Link>();

			IndexReader reader = IndexReader.open(fsDir);

			ArrayList<QueryScorer> scorer = new ArrayList<QueryScorer>();

			for (int i = 0; i < query.getModelElements().size(); i++) {
				org.apache.lucene.search.Query q = parser.parse(query
						.getModelElements().get(i).getDescription());

				scorer.add(new QueryScorer(q, reader, "code"));
				Highlighter h = new Highlighter(scorer.get(i));

				hits.add(is.search(q));

				for (int j = 0; j < hits.get(i).length(); j++) {

					String tex = h.getBestFragment(analyzer, "code", hits
							.get(i).doc(j).get("code"));
					if (tex != null) {

						StringTokenizer tok = new StringTokenizer(tex, "\n");

						while (tok.hasMoreElements()) {
							String line = tok.nextToken();
							if (containsHighlightedText(line)) {
								// line = line.replace("<B>", "");
								// line = line.replace("</B>", "");
								CodeLocation location = TraceFactory.eINSTANCE
										.createCodeLocation();
								System.out.println(line);
								location.setLineContent(line);
								location.setName(hits.get(i).doc(j)
										.get("filename"));
								location.setDescription(hits.get(i).doc(j)
										.get("path"));

								Link link = TraceRecoveryFactory.eINSTANCE
										.createLink();
								link.setConfidence(hits.get(i).score(j));
								link.setDescription("linking from ME to code");
								link.setSource(query.getModelElements().get(i));
								link.setTarget(location);
								link.setType("linking from ME to code");
								links.add(link);

							}
						}
					}

				}

			}

			// System.out.println(hits.get(0).doc(0).get("code")
			// + " this is the code that was retrived");

			return links;

		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}

	}

	Query createQeuryCode(File file, String type) {
		try {
			Query q = TraceRecoveryFactory.eINSTANCE.createQuery();
			if (type.toLowerCase() == "java") {
				JavaParser parser = new JavaParser();
				parser.setSource(file);
				parser.getDeclaredClass();
				JavaSourceCodeAnalyzer analyzer = new JavaSourceCodeAnalyzer();

				// System.out.println("this is the value of the analyzer "
				// + parser.getDeclaredClass().className);

				String className = parser.getDeclaredClass().className;
				
				StringReader str = new StringReader(
						className);

				TokenStream token = analyzer.tokenStream("className", str);

				Token tok = token.next();
				

				CodeLocation loc = TraceFactory.eINSTANCE.createCodeLocation();
				loc.setDescription(tok.termText());

				q.getModelElements().add(loc);

				ArrayList<String> comments = parser.getComments();
				String comm = "";
				for (int i = 0; i < comments.size(); i++) {
					str = new StringReader(comments.get(i));
					token = analyzer.tokenStream("comment", str);
					
					if(token == null){
						break;
					}
					tok = token.next();
					if (tok != null) {
						comm = "";
						while(tok != null){
						comm +=" " + tok.termText();
								
						tok = token.next();
						}
						
						
						loc = TraceFactory.eINSTANCE.createCodeLocation();
						loc.setDescription(comm);
						loc.setName(className);
						q.getModelElements().add(loc);
					}
					
				}
				
				
//				ArrayList<JMethod> methods = parser.getDeclaredClass().methodDeclarations;
//				 comm = "";
//				for (int i = 0; i < methods.size(); i++) {
//					str = new StringReader(methods.get(i).methodName);
//					token = analyzer.tokenStream("methodName", str);
//					
//					if(token == null){
//						break;
//					}
//					tok = token.next();
//					if (tok != null) {
//						while(tok != null){
//						comm +=" "+ tok.termText();
//							
//						tok = token.next();
//						}
//						
//						System.out.println(comm + " this is the string at the end");	
//					}
//					loc = TraceFactory.eINSTANCE.createCodeLocation();
//					loc.setDescription(comm);
//					loc.setName(className);
//					q.getModelElements().add(loc);
//				}
				
			}
			
			return q;
		} catch (IOException e) {
			e.printStackTrace();
			return null;

			// analyzer.tokenStream("class", reader)

		} 

		
	}

//	public static void main(String[] args) {
//		Search search = new Search();
//		search.createQeuryCode(
//				new File(
//						"/home/taher/workspace/org.unicase.traceRecovery/src/traceability/handler/Search.java"),
//				"java");
//	}

	public ArrayList<Link> runRecoveryCodeToME(Query query, Directory dir) {
		try {
			File indexDir = new File(dir.getPath());
			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, true);

			analyzer.addAnalyzer("text", new StandardAnalyzer());

			IndexSearcher is = new IndexSearcher(fsDir);

			ArrayList<Link> links = new ArrayList<Link>();

			ArrayList<Hits> hits = new ArrayList<Hits>();

			IndexReader reader = IndexReader.open(fsDir);

			for (int i = 0; i < query.getModelElements().size(); i++) {

				org.apache.lucene.search.Query quer = QueryParser.parse(query
						.getModelElements().get(i).getDescription(), "text",
						new StandardAnalyzer());
				hits.add(is.search(quer));

			}

			for (int i = 0; i < hits.size(); i++) {
				for (int j = 0; j < hits.get(i).length(); i++) {
					Link link = TraceRecoveryFactory.eINSTANCE.createLink();
					link.setConfidence(hits.get(i).score(j));
					link.setDescription("linking from code to model element");
					link.setSource(query.getModelElements().get(i));

					links.add(link);

				}
			}

			return links;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean containsHighlightedText(String text) {
		if (text.contains("<B>")) {
			return true;
		}
		return false;
	}

	public ArrayList<File> searchForWordInCode(Query query, Directory dir) {
		try {
			File indexDir = new File(dir.getPath());
			analyzer.addAnalyzer("import", new KeywordAnalyzer());
			org.apache.lucene.store.Directory fsDir = FSDirectory.getDirectory(
					indexDir, false);

			IndexSearcher is = new IndexSearcher(fsDir);

			QueryParser parser = new QueryParser("code", analyzer);

			ArrayList<Hits> hits = new ArrayList<Hits>();

			for (int i = 0; i < query.getModelElements().size(); i++) {
				hits.add(is.search(parser.parse(query.getModelElements().get(i)
						.getDescription())));
			}

			ArrayList<File> result = new ArrayList<File>();

			for (int i = 0; i < hits.size(); i++) {
				for (int j = 0; j < hits.get(i).length(); j++) {
					File f = new File(hits.get(i).doc(j).get("filename"));
					result.add(f);
				}
			}

			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * will create the link between the code and model elements.
	 * 
	 * @param hit
	 *            this is the result of the search
	 * @param query
	 *            this is the query which will contain the model elements of the
	 *            source
	 * @param type
	 *            this is the type if it is from ME to code or vice versa.
	 * @return returns all the links between the model elements and the code
	 * @throws IOException
	 *             will throw and exception if while trying to use any input
	 *             output fails
	 */
	public ArrayList<Link> createLinks(ArrayList<Hits> hit, Query query,
			String type) throws IOException {

		ArrayList<Link> links = new ArrayList<Link>();

		for (int i = 0; i < hit.size(); i++) {
			Link link = TraceRecoveryFactory.eINSTANCE.createLink();
			for (int j = 0; j < hit.get(i).length(); j++) {
				Document doc = hit.get(i).doc(j);
				link.setConfidence(hit.get(i).score(j));
				link.setCreationDate(Calendar.getInstance().getTime());
				link.setDescription("linking between code and data");
				link.setSource(query.getModelElements().get(i));
				link.setName(doc.get("filename"));
				links.add(link);

			}
		}

		return links;
	}

	/**
	 * will set the used analyzer.
	 * 
	 * @param analyzer
	 *            the string and type of the analyzer
	 * @return returns tha new created analyzer
	 */
	public void setAnalyzer(String analyzer) {
		if (analyzer.toLowerCase() == "java") {
			this.analyzer = new PerFieldAnalyzerWrapper(
					new JavaSourceCodeAnalyzer());
		} else {
			this.analyzer = new PerFieldAnalyzerWrapper(
					new FortranSourceCodeAnalyzer());
		}
	}

	/**
	 * set the index that will be used to index.
	 */
	public void setIndexer(String indexer, Directory codeDir,
			Directory sourceDir) {
		try {
			this.dir = sourceDir;
			File file = new File(dir.getPath());
			if (indexer.toLowerCase() == "java") {
				IndexWriter writer = new IndexWriter(file,
						new JavaSourceCodeAnalyzer(), true);
				this.index = new Indexer(writer, codeDir, sourceDir);
			} else if (indexer.toLowerCase() == "fortran") {
				IndexWriter writer = new IndexWriter(file,
						new FortranSourceCodeAnalyzer(), true);
				this.index = new Indexer(writer, codeDir, sourceDir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set the parser that is going to be used.
	 */
	public void setParser() {

	}

	public void index() {
		try {
			index.indexDir(this.index.getWriter(), this.index.getCodeDir(),
					this.index.getIndexDir());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void index(ArrayList<String> dir) {
		try {
			JavaSourceCodeIndexer javaIndexer = new JavaSourceCodeIndexer();
			FortranCodeIndexer fortranIndexer = new FortranCodeIndexer();

			for (int i = 0; i < dir.size(); i++) {
				Directory codeDir = TraceRecoveryFactory.eINSTANCE
						.createDirectory();
				codeDir.setPath(dir.get(i));

				index.indexDir(this.index.getWriter(), codeDir,
						this.index.getIndexDir(), javaIndexer, fortranIndexer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the index
	 */
	public Indexer getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(Indexer index) {
		this.index = index;
	}

	/**
	 * @return the analyzer
	 */
	public PerFieldAnalyzerWrapper getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer
	 *            the analyzer to set
	 */
	public void setAnalyzer(PerFieldAnalyzerWrapper analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * @return the dir
	 */
	public Directory getDir() {
		return dir;
	}

	/**
	 * @param dir
	 *            the dir to set
	 */
	public void setDir(Directory dir) {
		this.dir = dir;
	}

}
