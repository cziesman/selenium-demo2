package com.redhat.demo.selenium.step;

import java.io.IOException;
import java.time.Duration;

import com.redhat.demo.selenium.helper.Utils;
import com.redhat.demo.selenium.helper.WebDriverHelper;
import com.redhat.demo.selenium.helper.Widget;
import com.redhat.demo.selenium.page.AddWidgetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddWidgetSteps {

    private static final Logger LOG = LoggerFactory.getLogger(AddWidgetSteps.class);

    private AddWidgetPage addWidgetPage;

    @Given("User is viewing the Add Widget page at {string}")
    public void user_is_viewing_the_add_widget_at(String url) throws IOException {

        addWidgetPage = new AddWidgetPage();
        WebDriverHelper.openPage(url, addWidgetPage);

        Assertions.assertTrue(addWidgetPage.isValid());
    }

    @When("User adds a new widget with name {string} and description {string}")
    public void user_adds_a_new_widget_with_name_and_description(String name, String description) {

        LOG.info("{} {}", name, description);

        addWidgetPage.setName(name);
        addWidgetPage.setDescription(description);
        addWidgetPage.clickAddButton();

        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Widgets"));
    }

    @Then("The widget named {string} is added")
    public void the_widget_named_xxx_is_added(String name) throws IOException, InterruptedException {

        Widget widget = Utils.findByName(name);
        LOG.info("{}", widget);
        Assertions.assertNotNull(widget);
    }

}
