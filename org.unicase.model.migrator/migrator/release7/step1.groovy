import org.eclipse.emf.ecore.*

/**
 * Converts the rich text string as generated by the MERichTextContol to HTML.
 * 
 * @param richText the input string
 * @return the converted HTML text
 */
public static String replaceModelwithClassID(String layoutString) {
	if (layoutString == null) {
		return "";
	}

	 try{
		println layoutString;
		return layoutString.replaceAll("type=\"Model\"" , "type=\"Class\"");
						
		} catch (RuntimeException e) {
			e.printStackTrace();
			return layoutString;
		}
	
}

//change migration
getElementById = { id ->
	def element = model.UnicaseModelElement.allInstances.find{e -> id.equals(e.identifier)} 
	if(element == null) {
		println "id " + id + " not found"
	}
	return element
}

isFeatureChange = { operation, EStructuralFeature feature ->
	if(feature.name.equals(operation.featureName)) {
		def id = operation.modelElementId.id
		def element = getElementById(id)
		if(element == null || element.instanceOf(feature.eContainingClass)) {
			return true
		}
	}
	return false
}

for(operation in esmodel.versioning.operations.AttributeOperation.allInstances) {
	if(isFeatureChange(operation, model.diagram.MEDiagram.diagramLayout)) {
		if(operation.oldValue != null) {
			operation.oldValue = replaceModelwithClassID(operation.oldValue)
		}
		if(operation.newValue != null) {
			operation.newValue = replaceModelwithClassID(operation.newValue)
		}
	}
}

// model migration
for(m in model.diagram.MEDiagram.allInstances) {
	if(m.diagramLayout != null) {
		m.diagramLayout = replaceModelwithClassID(m.diagramLayout)
	}
}