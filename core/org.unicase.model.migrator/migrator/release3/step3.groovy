systemFunctionClass = model.requirement.SystemFunction
nonDomainElementClass = model.NonDomainElement
systemFunctionClass.eSuperTypes.remove(nonDomainElementClass)
userTaskClass = model.requirement.UserTask
userTaskClass.eSuperTypes.remove(nonDomainElementClass)
initiatedUserTaskReference = model.requirement.Actor.initiatedUserTask
eAnnotation = initiatedUserTaskReference.newEAnnotation()
eAnnotation.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry = eAnnotation.newEStringToStringMapEntry()
eStringToStringMapEntry.key = "priority"
eStringToStringMapEntry.value = "15.0"
eStringToStringMapEntry2 = eAnnotation.newEStringToStringMapEntry()
eStringToStringMapEntry2.key = "position"
eStringToStringMapEntry2.value = "left"
participatedUserTasksReference = model.requirement.Actor.participatedUserTasks
eAnnotation2 = participatedUserTasksReference.newEAnnotation()
eAnnotation2.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry3 = eAnnotation2.newEStringToStringMapEntry()
eStringToStringMapEntry3.key = "priority"
eStringToStringMapEntry3.value = "15.0"
eStringToStringMapEntry4 = eAnnotation2.newEStringToStringMapEntry()
eStringToStringMapEntry4.key = "position"
eStringToStringMapEntry4.value = "right"
nonFunctionalRequirementReference = systemFunctionClass.newEReference()
nonFunctionalRequirementReference.name = "nonFunctionalRequirement"
nonFunctionalRequirementClass = model.requirement.NonFunctionalRequirement
nonFunctionalRequirementReference.eType = nonFunctionalRequirementClass
identifierAttribute = metamodel.IdentifiableElement.identifier
nonFunctionalRequirementReference.eKeys.add(identifierAttribute)
systemFunctionsReference = nonFunctionalRequirementClass.newEReference()
systemFunctionsReference.name = "systemFunctions"
systemFunctionsReference.upperBound = -1
systemFunctionsReference.eType = systemFunctionClass
systemFunctionsReference.eOpposite = nonFunctionalRequirementReference
nonFunctionalRequirementReference.eOpposite = systemFunctionsReference
systemFunctionsReference.eKeys.add(identifierAttribute)
eAnnotation3 = systemFunctionsReference.newEAnnotation()
eAnnotation3.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry5 = eAnnotation3.newEStringToStringMapEntry()
eStringToStringMapEntry5.key = "priority"
eStringToStringMapEntry5.value = "13.0"
eStringToStringMapEntry6 = eAnnotation3.newEStringToStringMapEntry()
eStringToStringMapEntry6.key = "position"
eStringToStringMapEntry6.value = "right"
nonFunctionalRequirementsReference = userTaskClass.newEReference()
nonFunctionalRequirementsReference.name = "nonFunctionalRequirements"
nonFunctionalRequirementsReference.upperBound = -1
nonFunctionalRequirementsReference.eType = nonFunctionalRequirementClass
nonFunctionalRequirementsReference.eKeys.add(identifierAttribute)
eAnnotation4 = nonFunctionalRequirementsReference.newEAnnotation()
eAnnotation4.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry7 = eAnnotation4.newEStringToStringMapEntry()
eStringToStringMapEntry7.key = "priority"
eStringToStringMapEntry7.value = "12.0"
eStringToStringMapEntry8 = eAnnotation4.newEStringToStringMapEntry()
eStringToStringMapEntry8.key = "position"
eStringToStringMapEntry8.value = "right"
userTasksReference = nonFunctionalRequirementClass.newEReference()
userTasksReference.name = "userTasks"
userTasksReference.upperBound = -1
userTasksReference.eOpposite = nonFunctionalRequirementsReference
nonFunctionalRequirementsReference.eOpposite = userTasksReference
userTasksReference.eType = userTaskClass
userTasksReference.eKeys.add(identifierAttribute)
eAnnotation5 = userTasksReference.newEAnnotation()
eAnnotation5.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry9 = eAnnotation5.newEStringToStringMapEntry()
eStringToStringMapEntry9.key = "priority"
eStringToStringMapEntry9.value = "14.0"
eStringToStringMapEntry10 = eAnnotation5.newEStringToStringMapEntry()
eStringToStringMapEntry10.key = "position"
eStringToStringMapEntry10.value = "right"
useCaseClass = model.requirement.UseCase
systemFunctionsReference2 = useCaseClass.newEReference()
systemFunctionsReference2.name = "systemFunctions"
systemFunctionsReference2.upperBound = -1
systemFunctionsReference2.eType = systemFunctionClass
systemFunctionsReference2.eKeys.add(identifierAttribute)
eAnnotation6 = systemFunctionsReference2.newEAnnotation()
eAnnotation6.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry11 = eAnnotation6.newEStringToStringMapEntry()
eStringToStringMapEntry11.key = "priority"
eStringToStringMapEntry11.value = "15.0"
eStringToStringMapEntry12 = eAnnotation6.newEStringToStringMapEntry()
eStringToStringMapEntry12.key = "position"
eStringToStringMapEntry12.value = "right"
usecasesReference = systemFunctionClass.newEReference()
usecasesReference.name = "usecases"
usecasesReference.upperBound = -1
usecasesReference.eOpposite = systemFunctionsReference2
systemFunctionsReference2.eOpposite = usecasesReference
usecasesReference.eType = useCaseClass
usecasesReference.eKeys.add(identifierAttribute)
eAnnotation7 = usecasesReference.newEAnnotation()
eAnnotation7.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry13 = eAnnotation7.newEStringToStringMapEntry()
eStringToStringMapEntry13.key = "priority"
eStringToStringMapEntry13.value = "12.0"
eStringToStringMapEntry14 = eAnnotation7.newEStringToStringMapEntry()
eStringToStringMapEntry14.key = "position"
eStringToStringMapEntry14.value = "right"
requirementPackage = model.requirement
workspaceClass = requirementPackage.newEClass()
workspaceClass.name = "Workspace"
unicaseModelElementClass = model.UnicaseModelElement
workspaceClass.eSuperTypes.add(unicaseModelElementClass)
workspaceReference = systemFunctionClass.newEReference()
workspaceReference.name = "workspace"
workspaceReference.eType = workspaceClass
workspaceReference.eKeys.add(identifierAttribute)
systemFunctionsReference3 = workspaceClass.newEReference()
systemFunctionsReference3.name = "systemFunctions"
systemFunctionsReference3.upperBound = -1
systemFunctionsReference3.eOpposite = workspaceReference
workspaceReference.eOpposite = systemFunctionsReference3
systemFunctionsReference3.eType = systemFunctionClass
systemFunctionsReference3.eKeys.add(identifierAttribute)
eAnnotation8 = systemFunctionsReference3.newEAnnotation()
eAnnotation8.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry15 = eAnnotation8.newEStringToStringMapEntry()
eStringToStringMapEntry15.key = "priority"
eStringToStringMapEntry15.value = "12.0"
eStringToStringMapEntry16 = eAnnotation8.newEStringToStringMapEntry()
eStringToStringMapEntry16.key = "position"
eStringToStringMapEntry16.value = "right"
realizedUserTaskReference = model.requirement.UseCase.realizedUserTask
eAnnotation9 = realizedUserTaskReference.newEAnnotation()
eAnnotation9.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry17 = eAnnotation9.newEStringToStringMapEntry()
eStringToStringMapEntry17.key = "priority"
eStringToStringMapEntry17.value = "10.1"
eStringToStringMapEntry18 = eAnnotation9.newEStringToStringMapEntry()
eStringToStringMapEntry18.key = "position"
eStringToStringMapEntry18.value = "left"
realizingUseCasesReference = model.requirement.UserTask.realizingUseCases
eAnnotation10 = realizingUseCasesReference.newEAnnotation()
eAnnotation10.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry19 = eAnnotation10.newEStringToStringMapEntry()
eStringToStringMapEntry19.key = "priority"
eStringToStringMapEntry19.value = "12.0"
eStringToStringMapEntry20 = eAnnotation10.newEStringToStringMapEntry()
eStringToStringMapEntry20.key = "position"
eStringToStringMapEntry20.value = "right"
participatingActorReference = model.requirement.UserTask.participatingActor
eAnnotation11 = participatingActorReference.newEAnnotation()
eAnnotation11.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry21 = eAnnotation11.newEStringToStringMapEntry()
eStringToStringMapEntry21.key = "priority"
eStringToStringMapEntry21.value = "12.0"
eStringToStringMapEntry22 = eAnnotation11.newEStringToStringMapEntry()
eStringToStringMapEntry22.key = "position"
eStringToStringMapEntry22.value = "right"
