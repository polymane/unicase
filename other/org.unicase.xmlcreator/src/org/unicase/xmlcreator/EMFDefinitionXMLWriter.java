package org.unicase.xmlcreator;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

/**
 * This class provides the possibility to print the ecore definition of {@link EPackage EPackages}, {@link EClass
 * EClasses}, {@link EEnum EEnums}, {@link EDataType EDataTypes} and {@link EAnnotation EAnnotations} to XML.<br>
 * Printing an EPackage includes printing its attributes, all its contents and all its EAnnotations.<br>
 * Printing an EClass includes printing its attributes, its {@link EAttribute EAttributes} and {@link EReference
 * EReferences} as well as all its EAnnotations.<br>
 * Printing an EEnum includes printing its attributes, all its {@link EEnumLiteral EEnumLiterals} and all its
 * EAnnotations.<br>
 * Printing an EDataType includes printing all its attributes and all its {@link ETypeParameter ETypeParameters}.
 * 
 * @author mharut
 */
public class EMFDefinitionXMLWriter extends EMFXMLWriter {

	/**
	 * Constructor to assign the print writer and the root's name. The writer will be automatically initialized when
	 * calling this constructor.
	 * 
	 * @param out the {@link PrintWriter} that does the printing
	 * @param rootName the name of the XML's root element
	 * @see EMFXMLWriter#init()
	 */
	public EMFDefinitionXMLWriter(PrintWriter out, String rootName) {
		super(out, rootName);
		init();
	}
	
	@Override
	protected void printRootAttributes() {
		// nothing to print
	}

	/**
	 * Prints an {@link EObject} to XML. Delegates to one of the following methods, depending on <code>eObject</code>'s
	 * type:<br>
	 * <ul>
	 * <li>{@link #printEPackage(EPackage)}</li>
	 * <li>{@link #printEClass(EClass)}</li>
	 * <li>{@link #printEEnum(EEnum)}</li>
	 * <li>{@link #printEDataType(EDataType)}</li>
	 * <li>{@link #printEAnnotation(EAnnotation)}</li>
	 * </ul>
	 * This method can be called multiple times to print multiple elements.
	 * 
	 * @param eObject the EObject to print
	 */
	@Override
	public void print(EObject eObject) {
		if (eObject instanceof EPackage) {
			printEPackage((EPackage) eObject);
		} else if (eObject instanceof EClass) {
			printEClass((EClass) eObject);
		} else if (eObject instanceof EEnum) {
			printEEnum((EEnum) eObject);
		} else if (eObject instanceof EDataType) {
			printEDataType((EDataType) eObject);
		} else if (eObject instanceof EAnnotation) {
			printEAnnotation((EAnnotation) eObject);
		}
	}

	/**
	 * Prints an {@link EPackage} to XML. This will print its name and URI, all its contents and all its
	 * {@link EAnnotation EAnnotations}.
	 * 
	 * @param ePackage the EPackage to print
	 */
	private void printEPackage(EPackage ePackage) {
		// begin of package: print name and URI
		addWhitespace();
		out.print("<package name=\"" + escape(ePackage.getName()));
		out.println("\" uri=\"" + escape(ePackage.getNsURI()) + "\">");
		whitespaceCounter += 2;

		// print contents
		for (EObject eObject : ePackage.eContents()) {
			print(eObject);
		}

		// print annotations
		for (EAnnotation eAnnotation : ePackage.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// end of package
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</package>");
	}

	/**
	 * Prints an EClass to XML. This will print the class's name , all its attributes and references as well as all of
	 * its {@link EAnnotation EAnnotations}.
	 * 
	 * @param eClass the EClass to print
	 */
	private void printEClass(EClass eClass) {
		// begin of class: print name
		addWhitespace();
		out.println("<class name=\"" + escape(eClass.getName()) + "\">");
		whitespaceCounter += 2;

		// print attributes
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			printEAttribute(eAttribute);
		}

		// print references
		printAllReferences(eClass);

		// print annotations
		for (EAnnotation eAnnotation : eClass.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// end of class
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</class>");
	}

	/**
	 * Prints all references of an {@link EClass} by separating them into container-references, containment-references
	 * and cross-references and making use of {@link #printReferences(List, String)}.
	 * 
	 * @param eClass the EClass to print the references for
	 */
	private void printAllReferences(EClass eClass) {
		// initialize the reference-lists
		List<EReference> containerReferences = new LinkedList<EReference>();
		List<EReference> containmentReferences = new LinkedList<EReference>();
		List<EReference> crossReferences = new LinkedList<EReference>();

		// separate the references
		for (EReference eReference : eClass.getEAllReferences()) {
			if (eReference.isContainer()) {
				containerReferences.add(eReference);
			} else if (eReference.isContainment()) {
				containmentReferences.add(eReference);
			} else {
				crossReferences.add(eReference);
			}
		}

		// print each type of references
		printReferences(containerReferences, "container-reference");
		printReferences(containmentReferences, "containment-reference");
		printReferences(crossReferences, "cross-reference");
	}

	/**
	 * Prints an {@link EAttribute} by printing its name, type, lower and upper bound and all its {@link EAnnotation
	 * EAnnotations}.
	 * 
	 * @param eAttribute the EAttribute to print
	 */
	private void printEAttribute(EAttribute eAttribute) {
		// begin of attribute: print name, type, lower and upper bound
		addWhitespace();
		out.print("<attribute name=\"" + escape(eAttribute.getName()));
		out.print("\" type=\"" + escape(eAttribute.getEType().getInstanceClassName()));
		out.print("\" lowerBound=\"" + eAttribute.getLowerBound());
		out.print("\" upperBound=\"" + eAttribute.getUpperBound());
		out.println("\">");
		whitespaceCounter += 2;

		// print annotations
		for (EAnnotation eAnnotation : eAttribute.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// end of attribute
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</attribute>");
	}

	/**
	 * Prints all references contained in <code>references</code>. The XML element name of each of these references is
	 * <code>referenceType</code>.
	 * 
	 * @param references a list of all references to print
	 * @param referenceType the XML element name of each of the references
	 */
	private void printReferences(List<EReference> references, String referenceType) {
		for (EReference reference : references) {
			// begin of reference
			addWhitespace();
			out.print("<" + referenceType);

			// print reference definition
			printEReference(reference);

			// end of reference
			addWhitespace();
			out.println("</" + referenceType + ">");
		}
	}

	/**
	 * Prints the ecore definition of an {@link EReference}. This includes its name, type, lower and upper bound as well
	 * as all its {@link EAnnotation EAnnotations}.
	 * 
	 * @param eReference the EReference to print
	 */
	private void printEReference(EReference eReference) {
		// print reference attributes: name, type, lower and upper bound
		out.print(" name=\"" + eReference.getName());
		out.print("\" type=\"" + escape(eReference.getEReferenceType().getName()));
		out.print("\" lowerBound=\"" + eReference.getLowerBound());
		out.print("\" upperBound=\"" + eReference.getUpperBound());
		out.println("\">");

		// add indent
		whitespaceCounter += 2;

		// print annotations
		for (EAnnotation eAnnotation : eReference.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// remove indent
		whitespaceCounter -= 2;
	}

	/**
	 * Prints an {@link EEnum} to XML. This includes printing its name, all its {@link EEnumLiteral EEnumLiterals} with
	 * their names and literals and all its {@link EAnnotation EAnnotations}.
	 * 
	 * @param eEnum the EEnum to print
	 */
	private void printEEnum(EEnum eEnum) {
		// begin of enum: print name
		addWhitespace();
		out.println("<enum name=\"" + escape(eEnum.getName()) + "\">");
		whitespaceCounter += 2;

		// print literals
		for (EEnumLiteral literal : eEnum.getELiterals()) {
			addWhitespace();
			out.print("<literal name=\"" + escape(literal.getName()));
			out.println("\" literal=\"" + escape(literal.getLiteral()) + "\"/>");
		}

		// print annotations
		for (EAnnotation eAnnotation : eEnum.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// end of enum
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</enum>");
	}

	/**
	 * Prints an {@link EDataType} to XML. This includes its name, its instance class name, all its parameters and all
	 * its {@link EAnnotation EAnnotations}.
	 * 
	 * @param eDataType the EDataType to print
	 */
	private void printEDataType(EDataType eDataType) {
		// begin of data type: print name and instance class name
		addWhitespace();
		out.print("<data-type name=\"" + escape(eDataType.getName()) + "\" ");
		out.print("instance-class-name=\"" + escape(eDataType.getInstanceClassName() + "\" "));
		whitespaceCounter += 2;

		// print parameters
		for (ETypeParameter parameter : eDataType.getETypeParameters()) {
			addWhitespace();
			out.println("<parameter name=\"" + escape(parameter.getName()) + "\"/>");
		}

		// print annotations
		for (EAnnotation eAnnotation : eDataType.getEAnnotations()) {
			printEAnnotation(eAnnotation);
		}

		// end of data type
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</data-type>");
	}

	/**
	 * Prints an {@link EAnnotation} to XML. This includes its source and all its details.
	 * 
	 * @param eAnnotation the EAnnotation to print
	 */
	private void printEAnnotation(EAnnotation eAnnotation) {
		// begin of annotation: print source
		addWhitespace();
		out.println("<annotation source=\"" + escape(eAnnotation.getSource()) + "\">");
		whitespaceCounter += 2;

		// print details
		for (Entry<String, String> detail : eAnnotation.getDetails()) {
			addWhitespace();
			out.print("<detail key=\"" + escape(detail.getKey()));
			out.print("\" value=\"" + escape(detail.getValue()));
			out.println("\"/>");
		}

		// end of annotation
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</annotation>");
	}

}
