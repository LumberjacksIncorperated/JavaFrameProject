#!/bin/sh

#----------------------------------------------------------------------------------------------------------------------
#
# PROJECT
# -------
# Java Frame Project
#
# AUTHOR
# ------
# Lumberjacks Incorperated (2018)
#
#----------------------------------------------------------------------------------------------------------------------

#----------------------------------------------------------------------------------------------------------------------
# MAIN
#----------------------------------------------------------------------------------------------------------------------
main()
{
    echo "<START>"
    
    echo "Enter compilation starting directory"
    enterCompilationStartingDirectory
    
    echo "Compile java files"
    compileJavaFiles
    
    echo "Cleanup Project"
    putClassFilesInClassFileDirectory
    
    echo "<DONE>"
}

#----------------------------------------------------------------------------------------------------------------------
# INTERNAL FUNCTIONS
#----------------------------------------------------------------------------------------------------------------------
function enterCompilationStartingDirectory()
{
    cd ../java_files/
}

function compileJavaFiles()
{
	compileWrappedClassesSubDirectory
	compileChainTestingSubDirectory
	javac DrawingApplication.java
}

function compileWrappedClassesSubDirectory()
{
	javac wrapped_classes/Grafix.java
	javac wrapped_classes/JFrameWrapper.java
	javac wrapped_classes/JPanelWrapper.java
}

function compileChainTestingSubDirectory() {
	javac chain_testing/BaseObject.java
	javac chain_testing/Monitor.java
	javac chain_testing/MonitorAssistant.java
	javac chain_testing/MonitorAssistantDelegate.java
	javac chain_testing/ObjectDescription.java
}

function putClassFilesInClassFileDirectory()
{
    mv ./*.class ../class_files
    makeSubDirectoriesForClassFiles
    moveFilesIntoSubDirectories
}

function makeSubDirectoriesForClassFiles() {
	mkdir ../class_files/wrapped_classes
	mkdir ../class_files/chain_testing

}

function moveFilesIntoSubDirectories() {
	mv ./wrapped_classes/*.class ../class_files/wrapped_classes/
	mv ./chain_testing/*.class ../class_files/chain_testing/
}

#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main