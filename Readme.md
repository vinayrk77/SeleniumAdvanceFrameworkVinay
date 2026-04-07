# Selenium Advanced Automation Framework

A production-grade UI test automation framework built with Java and Selenium WebDriver, designed for scalability, parallel execution, and clean reporting.

---

## Tech Stack

| Layer | Tools |

| Language | Java 8+ |
| Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Assertions | AssertJ |
| Design Pattern | Page Object Model (POM) |
| Thread Safety | ThreadLocal WebDriver |
| Test Data | Apache POI (Excel), Properties files |
| Reporting | Allure Reports |
| Cloud Grid | Selenoid (Docker) |
| Code Quality | SonarLint |

---

## Framework Architecture


src/
├── main/java/
│   ├── pages/          # Page Object classes (one per page)
│   ├── utils/          # DriverManager (ThreadLocal), ConfigReader, ExcelUtils
│   └── base/           # BaseTest — setup & teardown
└── test/java/
    └── tests/          # TestNG test classes


---

## Key Features

- **ThreadLocal WebDriver** — fully thread-safe parallel execution, no cross-thread interference
- **Page Object Model** — clean separation between test logic and UI interactions
- **Data-driven testing** — test inputs loaded from Excel sheets via Apache POI
- **Config-driven** — base URL, credentials, and environment settings in `config.properties`
- **Selenoid integration** — runs tests on a Dockerized browser grid for CI/CD environments
- **Allure Reports** — rich HTML reports with test steps, pass/fail history, and screenshots on failure
- **Retry logic** — flaky test retry mechanism via TestNG `IRetryAnalyzer`
- **SonarLint** — enforced code quality checks throughout

---

## Getting Started

### Prerequisites

- Java 8+
- Maven
- Docker (for Selenoid execution)
- Allure CLI (`brew install allure` or see [Allure docs](https://docs.qameta.io/allure/))

### Clone & Install

bash
git clone https://github.com/vinayrk77/SeleniumAdvanceFrameworkVinay.git
cd SeleniumAdvanceFrameworkVinay
mvn clean install -DskipTests


### Run Tests Locally

bash
# Login test suite
mvn clean test -DsuiteXmlFile=testng_login.xml

# VWO suite with retry logic
mvn clean test -DsuiteXmlFile=testng_vwo_retry.xml


### Run on Selenoid (Docker Grid)

bash
# Start Selenoid first
docker-compose up -d

# Run against grid
mvn clean test -Denv=selenoid -DsuiteXmlFile=testng_login.xml


### Generate Allure Report

bash
allure serve allure-results/


---

## Parallel Execution

Parallel test execution is configured via TestNG XML. Update the parallel attribute to run across threads:

xml
<suite name="Suite" parallel="methods" thread-count="4">

ThreadLocal ensures each thread gets its own isolated WebDriver instance — no race conditions.

---

## Test Data

Test credentials and inputs are managed in two ways:

- Properties file — environment config (base URL, timeouts)
- Excel via Apache POI — data-driven test cases using @DataProvider

java
@DataProvider(name = "loginData")
public Object[][] getLoginData() {
    return ExcelUtils.readData("testdata/LoginData.xlsx", "Sheet1");
}

---

## Reporting

Allure Reports are generated after each test run:

bash
allure serve allure-results/

Reports include test step breakdown, pass/fail trends, environment info, and screenshots attached on failure.

---

## Author

**Vinay Karanjavkar** — QA Analyst | Automation Engineer
- [LinkedIn](https://www.linkedin.com/in/vinaykaranjavkar/)
- [GitHub](https://github.com/vinayrk77)
- vinayrk26@gmail.com