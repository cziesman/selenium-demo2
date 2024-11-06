package com.redhat.demo.selenium.page;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewWidgetListPage {

    private static final Logger LOG = LoggerFactory.getLogger(ViewWidgetListPage.class);

    @FindBy(id = "add-widget")
    public WebElement addWidgetButton;

    public WebElement updateButton;

    public WebElement deleteButton;

    @After
    public void tearDown() {

        WebDriverHelper.tearDown();
    }

    public String getTitle() {

        WebElement titleText = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='Widgets']"));

        return titleText.getText();
    }

    public String getUpdateButton() {

        WebElement updateButton = findUpdateButton();

        return updateButton.getText();
    }

    public void clickUpdateButton() {

        WebElement updateButton = findUpdateButton();

        updateButton.click();
    }

    public boolean updateButtonIsNotPresent() {

        WebElement updateButton = null;
        try {
            updateButton = findUpdateButton();
        } catch (NoSuchElementException t) {
            // we expect this exception if the update button is gone
        }

        return updateButton == null;
    }

    protected WebElement findUpdateButton() {

        return WebDriverHelper.getDriver().findElement(By.id("update-0"));
    }

    public String getDeleteButton() {

        WebElement deleteButton = findDeleteButton();

        return deleteButton.getText();
    }

    public void clickDeleteButton() {

        WebElement deleteButton = findDeleteButton();

        deleteButton.click();
    }

    public boolean deleteButtonIsNotPresent() {

        WebElement deleteButton = null;
        try {
            deleteButton = findDeleteButton();
        } catch (NoSuchElementException t) {
            // we expect this exception if the delete button is gone
        }

        return deleteButton == null;
    }

    protected WebElement findDeleteButton() {

        return WebDriverHelper.getDriver().findElement(By.id("delete-0"));
    }

    public void clickAddWidgetButton() {

        addWidgetButton.click();
    }

    public boolean isValid() {

        assert addWidgetButton != null;

        return true;
    }

}
