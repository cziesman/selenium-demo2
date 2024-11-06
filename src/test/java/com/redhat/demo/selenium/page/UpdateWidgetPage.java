package com.redhat.demo.selenium.page;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateWidgetPage {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateWidgetPage.class);

    @FindBy(id = "update-widget")
    public WebElement updateButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "description")
    private WebElement description;

    @After
    public void tearDown() {

        WebDriverHelper.tearDown();
    }

    public String getTitle() {

        WebElement titleText = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='Update Widget']"));

        return titleText.getText();
    }

    public void setName(String name) {

        this.name.clear();
        this.name.sendKeys(name);
    }

    public void setDescription(String description) {

        this.description.clear();
        this.description.sendKeys(description);
    }

    public void clickUpdateButton() {

        updateButton.click();
    }

    public boolean isValid() {

        assert getTitle() != null;
        assert name != null;
        assert description != null;

        return true;
    }

}
