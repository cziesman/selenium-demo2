package com.redhat.demo.selenium.helper;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

public class WebDriverHelper {

    private final static int TIMEOUT = 5;

    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";

    private static final String WEBDRIVER_PATH = "webdriver.path";

    private static final String WEBDRIVER_BINARY = "webdriver.binary";

    private static final String WEBDRIVER_HEADLESS = "webdriver.headless";

    private static WebDriver driver;

    public static void openPage(String url, Object page) {

        getDriver().get(url);

        PageFactory.initElements(WebDriverHelper.getDriver(), page);
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            System.setProperty(WEBDRIVER_GECKO_DRIVER, PropertiesHelper.get(WEBDRIVER_PATH));
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(new FirefoxBinary(new File(PropertiesHelper.get(WEBDRIVER_BINARY))));
            options.setImplicitWaitTimeout(Duration.ofSeconds(TIMEOUT));

            // default is not headless
            if (Boolean.parseBoolean(PropertiesHelper.get(WEBDRIVER_HEADLESS))) {
                options.addArguments("--headless");
            }

            driver = new FirefoxDriver(options);
        }
        return driver;
    }

    public static void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
