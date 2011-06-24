/**
 * 
 */
package traceability.java;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.activation.FileDataSource;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceability.fortran.FortranSourceCodeParser;
import traceability.handler.Indexer;
import traceability.java.JavaParser.JClass;
import traceability.java.JavaParser.JMethod;

/**
 * @author liya
 *
 */
public class JavaSourceCodeIndexer extends Indexer{
	public JavaSourceCodeIndexer() {
		super();
		
		
	}

	private static final String IMPLEMENTS = "implements";
	private static final String IMPORT = "import";
	private static final String CLASS = "class";
	private static final String METHOD = "method";
	private static final String CODE = "code";
	private static final String COMMENT = "comment";
	private static final String RETURN = "return";
	private static final String PARAMETER = "parameter";
	private static final String EXTENDS = "extends";
	private static int id = 0;

	

	public static void main(String [] args) {

		try {
			File indexDir = new File(
					"lucene-index");
			File dataDir = new File(
					"code");
			Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
			d.setPath("code");
			IndexWriter writer = new IndexWriter(indexDir,
					new JavaSourceCodeAnalyzer(), true);
			indexDirectory(writer, d);
//			indexDirectory(writer, dataDir);
			int numFiles = writer.docCount();
			writer.close();
			System.out.println("Indexing "+ numFiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  void indexDirectory(IndexWriter writer, Directory directory)
			throws IOException {
		File dir = new File(directory.getPath());
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
				d.setPath(f.getAbsolutePath());
			if (f.isDirectory())
				indexDirectory(writer, d);
			else if (f.getName().endsWith(".java"))
				indexFileJava(writer, f);
//			else if(f.getName().endsWith(".f") || f.getName().endsWith("for") || f.getName().endsWith("f90") || f.getName().endsWith("f95")){
//				indexFileFortran(writer,f);
//			}
		}
	}

	public static  void indexFileJava(IndexWriter writer, File f) {
		if (f.isHidden() || !f.exists() || !f.canRead())
			return;
		Document doc = new Document();
		JavaParser parser = new JavaParser();
		parser.setSource(f);
		addImportDeclarations(doc, parser);
		addComments(doc, parser);
		JClass cls = parser.getDeclaredClass();
		addClass(doc, cls);
		
		Field name = new Field("filename",f.getName(),Field.Store.YES,Field.Index.NO);
		Field path = new Field("path",f.getAbsolutePath(),Field.Store.YES,Field.Index.NO);
		doc.add(name);
		doc.add(path);
		
		try {
			writer.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addImportDeclarations(Document doc, JavaParser parser) {
		ArrayList <String> imports = parser.getImportDeclarations();
		if (imports == null)
			return;
		for (int i = 0; i < imports.size(); i++) {
			String importName = imports.get(i);
			Field impor = new Field(IMPORT, importName, Field.Store.YES, Field.Index.UN_TOKENIZED);
			doc.add(impor);
		}
	}

	private static void addComments(Document doc, JavaParser parser) {
		ArrayList comments = parser.getComments();
		if (comments == null)
			return;
		for (int i = 0; i < comments.size(); i++) {
			String docComment = (String) comments.get(i);
			Field comment = new Field(COMMENT, docComment, Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(comment);
		}
	}

	private static void addClass(Document doc, JClass cls) {
		Field cl = new Field(CLASS, cls.className, Field.Store.YES, Field.Index.TOKENIZED);
		doc.add(cl);
		String superCls = cls.superClass;
		if (superCls != null){
			Field supercl = new Field(EXTENDS, superCls, Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(supercl);
		}
		ArrayList interfaces = cls.interfaces;
		for (int i = 0; i < interfaces.size(); i++) {
			String interfaceName = (String) interfaces.get(i);
			Field interfaceNam = new Field(IMPLEMENTS, interfaceName, Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(interfaceNam);
		}

		addMethods(cls, doc);
		ArrayList innerCls = cls.innerClasses;
		for (int i = 0; i < innerCls.size(); i++) {
			addClass(doc, (JClass) innerCls.get(i));
		}

	}

	private static void addMethods(JClass cls, Document doc) {
		ArrayList methods = cls.methodDeclarations;
		for (int i = 0; i < methods.size(); i++) {
			JMethod method = (JMethod) methods.get(i);
			Field meth = new Field(METHOD, method.methodName, Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(meth);
			Field ret = new Field(METHOD, method.returnType, Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(ret);
			ArrayList params = method.parameters;
			for (int k = 0; k < params.size(); k++) {
				String paramType = (String) params.get(k);
				Field param = new Field(PARAMETER, paramType, Field.Store.YES, Field.Index.TOKENIZED);
				doc.add(param);
			}
			String code = method.codeBlock;
			if (code != null){	
				Field cod = new Field(CODE, code, Field.Store.YES, Field.Index.TOKENIZED, Field.TermVector.WITH_POSITIONS);
				doc.add(cod);
			}
		}
	}

}
