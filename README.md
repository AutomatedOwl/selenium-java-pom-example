# selenium-java-pom-example

This example currently supports Linux and Windows, both with Java 8+, Maven and Chrome browser of version 69-71 installed.

To run on Windows, simply clone the repository and from root project diectory run:
```
mvn test
```

To run on Linux, make the chromedriver file executable by running the following command from root project dir:
```
chmod +x src/main/java/com/github/automatedowl/examples/drivers/executable/chromedriver
```

Then in order to run the test:
```
mvn test
```
