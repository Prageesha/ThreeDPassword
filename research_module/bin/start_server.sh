#!/bin/sh
export APPLICATION_HOME=/home/prageesha/MSC/Code/ThreeDPassword/research_module
export JAVA_HOME=/usr/lib/jvm/java-8-oracle

$JAVA_HOME/bin/java -Djava.util.logging.config.file=$APPLICATION_HOME/conf/logging.properties -jar $APPLICATION_HOME/target/research_module-0.0.1-SNAPSHOT.jar

