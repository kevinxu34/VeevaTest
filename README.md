## Introduction
This utility can parse the JSON string and flatten it to the conjunctional condition string.

### How to use
Please refer to the /src/test/java/com/veeva/test/conditionJoiner/JoinerTest.java

```
Joiner joiner = new Joiner();
String conjunctionalString = joiner.join(jsonString);
```

### How to build
To build this program using Gradle, run the following commands at the project root:

```
./gradlew clean build
```
