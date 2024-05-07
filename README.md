# Asurion Coding Challenge
This project uses Java and Selenium WebDriver to automate testing of the login functionality on [SauceDemo](https://www.saucedemo.com/). The primary goal is to validate user authentication processes, ensuring they work as expected under different scenarios.

## Prerequisites

To run these tests, you need the following installed on your system:
- Java Development Kit (JDK) - Version 8 or later
- Maven - Dependency management
- WebDriver for Chrome or Firefox, depending on your browser choice

## Test Scenarios

### Scenario 1: Standard User Login

1. **Log In:** Uses a standard user's credentials to log in.
2. **Verify Navigation:** Checks if the user is navigated to the homepage after login.
3. **Log Out:** Performs the logout operation.
4. **Verify Logout:** Ensures that the user is redirected to the login page post-logout.

### Scenario 2: Locked Out User Login

1. **Log In:** Attempts to log in using a locked out user's credentials.
2. **Verify Error Message:** Verifies that the correct error message is displayed when login fails.

## Results
