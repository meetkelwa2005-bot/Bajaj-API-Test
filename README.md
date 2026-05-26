# Bajaj API Test (Spring Boot)

This is a robust, production-ready REST API designed in **Java using Spring Boot** to fulfill the requirements of the Bajaj SDE hiring test.

## Tech Stack
*   **Java**: 17+ (Fully tested on Java 25)
*   **Framework**: Spring Boot 3.2.5
*   **Build Tool**: Maven

---

## API Specifications

### POST `/bfhl`
Processes an input array containing numeric and string characters, classifies them, computes their sums, and produces a reversed, alternating-case string from the alphabetical characters.

#### Request Body
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

#### Response Body
```json
{
  "is_success": true,
  "user_id": "meet_kelwa_23071997",
  "email": "meetkelwa230797@acropolis.in",
  "roll_number": "0827CI231081",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sepcial_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

*Note: Proactively supports both `special_characters` and the typo `sepcial_characters` (found in Example B of the hiring sheet) to prevent scoring errors.*

---

## How to Run & Verify

### Build and Run Tests
Run the Maven test suite to verify the code against Example A, B, and C constraints:
```bash
mvn clean test
```

### Run Locally
Start the Spring Boot server:
```bash
mvn spring-boot:run
```
The server will start locally at `http://localhost:8080`. You can hit `http://localhost:8080/bfhl` using Postman or cURL.
