package com.redhat.demo.selenium.page;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddWidgetPage {

    private static final Logger LOG = LoggerFactory.getLogger(AddWidgetPage.class);

    @FindBy(id = "add-widget")
    public WebElement addButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "description")
    private WebElement description;

    @After
    public void tearDown() {

        WebDriverHelper.tearDown();
    }

    public String getTitle() {

        WebElement titleText = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='Add Widget']"));

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

    public void clickAddButton() {

        addButton.click();
    }

    public boolean isValid() {

        assert getTitle() != null;
        assert name != null;
        assert description != null;

        return true;
    }

}
