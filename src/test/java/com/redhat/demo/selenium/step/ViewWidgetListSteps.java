package com.redhat.demo.selenium.step;

import java.time.Duration;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import com.redhat.demo.selenium.page.ViewWidgetListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewWidgetListSteps {

    private static final Logger LOG = LoggerFactory.getLogger(ViewWidgetListSteps.class);

    private ViewWidgetListPage viewWidgetListPage;

    @Given("User is viewing the List Widgets page at {string}")
    public void user_is_viewing_the_list_widgets_page_at(String url) {

        viewWidgetListPage = new ViewWidgetListPage();

        LOG.info("{}", url);
        WebDriverHelper.openPage(url, viewWidgetListPage);
    }

    @When("User can see the Add Widget button")
    public void user_can_see_the_add_widget_button() {

        Assertions.assertTrue(viewWidgetListPage.isValid());
    }

    @Then("User can click on the Add Widget button")
    public void user_can_click_on_the_add_widget_button() {

        viewWidgetListPage.clickAddWidgetButton();

        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Add Widget"));
    }

}
