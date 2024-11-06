# A Selenium-Cucumber demo that should run on Java 8

## Overview

This project uses the dummy web app at https://qa-practice.netlify.app/auth_ecommerce.html to demonstrate the basic
structure of an integration test suite using Selenium and Cucumber.

Selenium provides capabilities to interact with controls on web pages and to simulate human interactions with web pages.

Cucumber provides the ability to specify Business Driven Development (BDD) test cases using Gherkin syntax.

The combination of the two provides a powerful and fairly easy to use tool for automated testing of web-base user interfaces.

## Implementation Details

### geckodriver

This project uses the `geckodriver` to control a Firefox executable.

You will need to download the appropriate driver for your environment from https://github.com/mozilla/geckodriver/releases/tag/v0.35.0. 

The application expects to find the executable in a directory that is relative to the project folder. 

1. You will need to update `webdriver.path` in `test.properties` with the relative path to the driver.
1. You will need to update `webdriver.binaary` in `test.properties` with the absolute path to your Firefox executable.

If you are running on a Mac, you may encounter the following error:

    "geckodriver” cannot be opened because the developer cannot be verified. macOS cannot verify that this app is free from malware.

If so, use the terminal to `cd` to the directory where the driver is installed, and enter the following command:

    xattr -d com.apple.quarantine geckodriver 

This will instruct macOS to trust the driver executable and allow testing to proceed.

### Test Execution

Cucumber tests can be labelled with tags. If you want to run all tests at once, use the command:

    mvn verify

If you want to run a test with a specific tag, use a command like the following:

    mvn verify -Dcucumber.filter.tags=@AddItemToShoppingCart

If you want to run Firefox in `headless` mode, set `webdriver.headless` in `test.properties` to `true`. Otherwise, set it to `false`.
