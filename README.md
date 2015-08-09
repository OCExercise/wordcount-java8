# Overview

Given a file, returns the maximum consecutive occurrence of words of the same length on each line.  Input file structures must adhere to the following contract:

1. All input files must begin with a line consisting solely of an integer specifying the number of constituent datasets.  
2. Datasets are separated by system new lines, the total number of which must equal the the count reported above.

# Prerequisites

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/)

# Installation and execution

```
$ git clone https://github.com/OCExercise/wordcount-java8.git

...

# If you want to test right away

$ mvn exec:java -Dexec.args="-f <path to input file>" 

... 

# generates relocatable script under target/appassembler/bin
# that manages classpath and execution of Maven artifacts

$ mvn clean package appassembler:assemble       

```
