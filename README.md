# GroceryApplication — Automated Test Suite

Automated test project for a grocery web application implemented with Java, Maven and TestNG. The project contains TestNG suite configurations for parallel execution, grouping, cross-browser testing and reporting integration (ExtentReports).

## Table of Contents
- Project overview
- Features
- Prerequisites
- Build & run tests
- Test suites (provided)
- Reporting
- Project structure
- Troubleshooting
- License

## Project overview
This repository contains an automated test framework for a grocery application. The test framework uses:
- Java (JDK)
- Maven (build & dependency management)
- TestNG (test framework and suite configuration)
- ExtentReports (test reporting)
- TestNG XML files for parallel execution, grouping and cross-browser testing

The repository is organized to allow running predefined TestNG suites (parallel by methods/classes, grouping, cross-browser) and to generate structured test reports.

## Features
- TestNG suites for parallel execution (by methods and by classes)
- Test grouping (run tests by groups)
- Cross-browser test configuration (XML-based)
- ExtentReports integration for HTML test reports
- Maven pom.xml to manage dependencies and plugins

## Prerequisites
- Java JDK 8 or later installed and JAVA_HOME set
- Apache Maven installed and available in PATH
- Browser(s) required by the tests (Chrome/Firefox) installed
- Browser driver(s) available (e.g., chromedriver, geckodriver on PATH) or configured via your driver-management approach

## Build & run tests

1. Clone the repository (if you haven't already):
   git clone https://github.com/AleenaSMariam/GroceryApplication.git
   cd GroceryApplication

2. Build the project and run the default test phase:
   mvn clean test

3. Run a specific TestNG suite file (examples):
   - Run parallel tests by methods:
     mvn -Dtestng.suiteXmlFiles=GroceryApplication/ParallelTestingForMethods.xml test
   - Run parallel tests by classes:
     mvn -Dtestng.suiteXmlFiles=GroceryApplication/ParallelTestingForClasses.xml test
   - Run grouped tests:
     mvn -Dtestng.suiteXmlFiles=GroceryApplication/Grouping.xml test
   - Run cross-browser suite:
     mvn -Dtestng.suiteXmlFiles=GroceryApplication/CrossBrowser.xml test

Notes:
- How to pass or override suite file depends on your Maven Surefire/Failsafe configuration in pom.xml. If the pom.xml is configured to pick up suite files differently, use the project's configured approach (IDE run configuration / Maven plugin configuration).
- You can also run suites directly from your IDE (right-click on TestNG xml and run).

## Test reports
- The project includes an ExtentReports configuration (ExtentReport.xml). After test execution, look for generated HTML reports (usually under target/, test-output/ or a configured reports directory).
- The exact report output path depends on how the reporting is initialized in the test code. Check the test utilities in src/ for the exact path if you need to customize the report location.

## Provided TestNG / config files
- GroceryApplication/ParallelTestingForMethods.xml — TestNG suite configured to run tests in parallel by methods.
- GroceryApplication/ParallelTestingForClasses.xml — TestNG suite configured to run tests in parallel by classes.
- GroceryApplication/Grouping.xml — TestNG suite for grouped test execution.
- GroceryApplication/CrossBrowser.xml — TestNG suite configured for cross-browser runs.
- GroceryApplication/ExtentReport.xml — ExtentReports configuration.
- GroceryApplication/testfile.xml — (auxiliary/test) example or placeholder suite file.

## Project structure (high level)
- GroceryApplication/
  - pom.xml
  - CrossBrowser.xml
  - ExtentReport.xml
  - Grouping.xml
  - ParallelTestingForClasses.xml
  - ParallelTestingForMethods.xml
  - testfile.xml
  - src/   — main and test code (tests, page objects, utilities). Inspect src/ to see tests and support code and adjust drivers/config accordingly.

## Troubleshooting
- If tests fail to start due to driver errors, ensure browser driver executables (chromedriver/geckodriver) are accessible or configured by the framework.
- If Maven cannot find TestNG or other dependencies, run mvn clean install to re-download dependencies.
- For parallel test instability, lower the parallelism or review shared state in tests (use thread-safe drivers, avoid static state).

## License
- Add license information here (e.g., MIT, Apache-2.0) if you want to publish this repository publicly with an open-source license.

If you'd like, I can commit this README.md into the repository or generate a more detailed README after reading the test code under src/ to include exact Java version, the precise report path, and sample test commands.
