# Selenium Automation Framework

A robust and scalable Selenium Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven** following industry-standard automation practices.

This framework is designed using the **Page Object Model (POM)** design pattern to ensure code reusability, maintainability, and scalability. It includes reusable components, reporting, retry mechanisms, configuration management, and external test data support, making it suitable for real-world UI automation projects.

---

## 🚀 Features

- ✅ Selenium WebDriver with Java
- ✅ TestNG Framework
- ✅ Maven Build Management
- ✅ Page Object Model (POM)
- ✅ Extent Reports Integration
- ✅ TestNG Listeners
- ✅ Retry Failed Test Execution
- ✅ JSON Test Data Management
- ✅ Global Configuration Management
- ✅ Screenshot Capture on Test Failure
- ✅ Reusable Utility Components
- ✅ Explicit Wait Implementation
- ✅ Modular Project Architecture
- ✅ Easily Extendable Framework

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Framework |
| Maven | Build & Dependency Management |
| WebDriverManager | Browser Driver Management |
| Extent Reports | Test Reporting |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```text
SeleniumAutomationFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── LandingPage.java
│   │   │   │   └── HomePage.java
│   │   │   │
│   │   │   └── utilities
│   │   │       ├── AbstractComponents.java
│   │   │       └── ExtentReporterNG.java
│   │   │
│   │   └── resources
│   │       └── GlobalData.properties
│   │
│   └── test
│       ├── java
│       │   ├── testCases
│       │   │   └── LoginTest.java
│       │   │
│       │   └── testComponents
│       │       ├── BaseClass.java
│       │       ├── ListenerClass.java
│       │       └── RetryClass.java
│       │
│       └── resources
│           └── LoginData.json
│
├── testResult
│   └── screenshots
│
├── testSuites
│   └── testng.xml
│
├── pom.xml
└── README.md
```

---

## 🏗 Framework Architecture

```text
TestNG Test
      │
      ▼
BaseClass
      │
      ▼
Page Objects
      │
      ▼
Abstract Components
      │
      ▼
Selenium WebDriver
      │
      ▼
Browser
```

---

## 📁 Folder Description

| Folder | Description |
|---------|-------------|
| **pages** | Contains all Page Object classes that represent web pages. |
| **utilities** | Reusable helper methods and Extent Report configuration. |
| **testCases** | Contains all test scripts. |
| **testComponents** | Base class, listeners, retry analyzer, and common test utilities. |
| **resources** | Stores configuration files and JSON test data. |
| **testResult** | Stores screenshots captured during failed test execution. |
| **testSuites** | Contains TestNG suite XML files. |

---

## ⚙️ Prerequisites

Before running the project, ensure you have the following installed:

- Java JDK 17 or later
- Apache Maven
- Git
- Google Chrome
- IntelliJ IDEA / Eclipse

---

## 📥 Clone the Repository

```bash
git clone https://github.com/hariharan-16/SeleniumAutomationFramework.git
```

Navigate to the project directory:

```bash
cd SeleniumAutomationFramework
```

---

## 📦 Install Dependencies

```bash
mvn clean install
```

---

## ▶️ Running the Tests

### Run all tests

```bash
mvn test
```

### Run TestNG Suite

```bash
mvn test -DsuiteXmlFile=testSuites/testng.xml
```

You can also execute the `testng.xml` suite directly from your IDE.

---

## 📊 Reporting

The framework uses **Extent Reports** to generate detailed execution reports.

The report includes:

- Test Execution Status
- Pass / Fail Summary
- Execution Time
- Exception Details
- Screenshot Attachments (on failure)

---

## 📸 Screenshot Capture

Whenever a test fails, screenshots are automatically captured and stored in:

```text
testResult/screenshots
```

The captured screenshots are attached to the Extent Report for easier debugging.

---

## ⚙️ Configuration

Application configurations are maintained in:

```text
src/main/resources/GlobalData.properties
```

Examples include:

- Browser
- Application URL
- Timeout Values

---

## 🧪 Test Data Management

Test data is stored externally using JSON files.

```text
src/test/resources/LoginData.json
```

This approach separates test data from test logic, making the framework easier to maintain.

---

## 🔄 Retry Mechanism

The framework includes a custom **Retry Analyzer** using TestNG.

If a test fails due to temporary issues such as browser instability or network delays, it is automatically retried based on the configured retry count.

---

## 🎯 Design Principles

- Page Object Model (POM)
- Separation of Concerns
- Reusable Components
- Maintainable Code
- Scalable Framework Design
- DRY (Don't Repeat Yourself)

---

## 🚀 Future Enhancements

- Cross Browser Execution
- Parallel Test Execution
- Selenium Grid Integration
- Docker Support
- Jenkins CI/CD Pipeline
- GitHub Actions Integration
- Allure Reports
- Log4j Logging

---

## 🤝 Contributing

Contributions are welcome!

If you have ideas for improvements or new features:

1. Fork the repository
2. Create a new branch
3. Commit your changes
4. Submit a Pull Request

---

## 👨‍💻 Author

**Hariharan R**

- GitHub: [Github URL](https://github.com/hariharan-16)
- LinkedIn: [LinkedIn URL](https://www.linkedin.com/in/hariharan016)

---

## ⭐ Support

If you found this project useful, please consider giving it a **Star ⭐** on GitHub.

It helps others discover the project and motivates further improvements.
