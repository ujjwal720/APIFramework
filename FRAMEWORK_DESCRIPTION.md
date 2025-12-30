# API Automation Framework Documentation

## Overview
This project is a REST API automation framework built using **Java**, **RestAssured**, and **TestNG**. It follows a modular structure to separate test logic, endpoints, payloads, and utilities, ensuring maintainability and scalability.

## Tech Stack
- **Language**: Java 17+ (implied)
- **Library**: [RestAssured](https://rest-assured.io/) (v5.5.6) for API interaction.
- **Testing Framework**: [TestNG](https://testng.org/) (v7.11.0) for test execution and assertions.
- **JSON Processing**: `org.json`, `Gson`, and RestAssured's `json-path`.
- **Build Tool**: Maven (managed via `pom.xml`).

## Framework Architecture
The framework is organized into the following components within `src/test/java`:

### 1. **Base Framework (`tests/Basetest.java`)**
The core setup class that all test classes extend.
- **Role**: Initializes `RequestSpecification`, sets up the Base URI, and provides wrapper methods for HTTP actions (GET, POST, PUT).
- **Key Features**:
  - `@BeforeClass` setup to initialize the `specification`.
  - Reusable execution methods: `getRequest()`, `post()`, `put()`.
  - Helper methods: `addtoken()` (OAuth2), `addqueryparam()`, `getStatusCode()`.

### 2. **Endpoints Layer (`endpoints/apipoints.java`)**
A centralized location for API Routes.
- **Role**: specific constant strings for end-points.
- **Content**:
  - `BASE_URL`: The root URL for the API (e.g., `https://petstore.swagger.io/v2`).
  - Routes: `POST_req`, `GET_req`, etc.

### 3. **Payload Management (`Payload/Request/Payloads.java`)**
Handles the generation of request bodies.
- **Role**: Creates dynamic payloads for requests.
- **Implementation**: Uses static methods (e.g., `createPetPayload`) to return JSON strings or objects, accepting parameters to customize the data for each test.

### 4. **Utilities (`Utility/ResponseUtil.java`)**
Helper class for processing API responses.
- **Role**: Simplifies extraction of data from `Response` objects.
- **Features**:
  - `getJsonPath()`: Returns a JsonPath view of the response.
  - `getString()`, `getInt()`, `getBoolean()`: Type-safe extractors for specific fields.
  - `getList()`: Extracts arrays/lists from the response.

### 5. **Assertions (`Assertions/verify.java`)**
Custom verification layer.
- **Role**: Wraps TestNG assertions to provide readable verification steps.
- **Features**:
  - `verifystatuscode()`: Validates HTTP status codes.
  - `verifyPetCreated()`: Domain-specific assertion to check if a Pet was created correctly (checks ID, Name, Status).

### 6. **Test Classes (`tests/`)**
Contains the actual test cases.
- **Example**: `CreatePetTest.java`
  - Extends `Basetest`.
  - Uses `apipoints` for URLs.
  - Uses `Payloads` for request data.
  - Uses `verify` for assertions.
  - `@Test` annotated methods execute the workflow.

## Folder Structure
```
src/test/java
├── Assertions      # Custom assertion wrappers
├── Config          # Configuration files (currently empty)
├── Payload         # Request body builders
├── Utility         # common utilities (Response parsing)
├── endpoints       # API Routes and Base URLs
└── tests           # TestNG Test classes
```

## How to Run
The project uses Maven. You can run tests using the command line:

```bash
mvn test
```

Or run individual tests via your IDE's TestNG plugin.
