
# Selenium Test Automation Framework

This is a Selenium-based test automation framework for testing the SauceDemo web application. It uses Java, TestNG, and Extent Reports to execute tests and capture results. Below are instructions to set up the project, run tests, and organize the codebase.

## Prerequisites

To run this project, you need to have the following software installed on your local machine:

1. [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
2. [Apache Maven](https://maven.apache.org/download.cgi)

## Getting Started

Follow these steps to set up the project and run the tests:

1. **Clone the Project:**

   ```bash
   git clone https://github.com/AbdelouahedManaa1/TakeHome_Stellar.git
   cd TakeHome_Stellar
   ```

2. **Build the Project:**

   Open a terminal in the project root directory and execute the following Maven command:

   ```bash
   mvn clean install
   ```

   This will download project dependencies, compile the code, and build the project.

## Project Structure

The project is organized as follows:

- **Test Classes:** All test classes are located under `src/test/java`. Positive tests are in `positiveTests.java`, and negative tests are in `negativeTests.java`.

- **Page Layers:** Page objects and related classes are organized under `src/main/java/pageLayers`.

- **Helper Methods:** Utility methods and classes are stored under `src/main/java/utils`.


## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

Tests are executed using TestNG, and test results are reported using Extent Reports.


## Known Limitations

Due to time restrictions, the functionality for capturing screenshots and attaching them to the report is not fully implemented.

Happy testing!
