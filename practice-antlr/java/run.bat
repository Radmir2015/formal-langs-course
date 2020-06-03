java -jar antlr-4.7.2-complete.jar syntax.g4 -visitor
javac -cp "*" syntax*.java
java -cp .;antlr-4.7.2-complete.jar org.antlr.v4.gui.TestRig syntax program -tree -gui prog.pr