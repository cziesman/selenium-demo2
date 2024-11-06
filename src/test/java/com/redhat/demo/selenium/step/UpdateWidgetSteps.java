package com.redhat.demo.selenium.step;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import com.redhat.demo.selenium.helper.Utils;
import com.redhat.demo.selenium.helper.WebDriverHelper;
import com.redhat.demo.selenium.helper.Widget;
import com.redhat.demo.selenium.page.UpdateWidgetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateWidgetSteps {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateWidgetSteps.class);

    private static Widget widget;

    private static String newName;

    private UpdateWidgetPage updateWidgetPage;

    @Given("User is viewing the Update Widget page at {string}")
    public void user_is_viewing_the_update_widget_page_at(String url) throws IOException, InterruptedException {

        String name = UUID.randomUUID().toString();
        String description = UUID.randomUUID().toString();

        widget = Utils.create(name, description);

        updateWidgetPage = new UpdateWidgetPage();
        String updateUrl = url + widget.getId();
        LOG.info("{}", updateUrl);

        WebDriverHelper.openPage(updateUrl, updateWidgetPage);

        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Update Widget"));

        Assertions.assertTrue(updateWidgetPage.isValid());
    }

    @When("User updates a widget")
    public void user_updates_a_widget() throws IOException, InterruptedException {

        widget = Utils.findByName(widget.getName());

        newName = UUID.randomUUID().toString();
        LOG.info("{} {}", widget.getName(), newName);

        updateWidgetPage.setName(newName);
        updateWidgetPage.clickUpdateButton();

        WebDriverWait wait = new WebDriverWait(WebDriverHelper.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Widgets"));
    }

    @Then("The widget is updated")
    public void the_widget_is_updated() throws IOException, InterruptedException {

        widget = Utils.findByName(newName);
        LOG.info("{}", widget);
        Assertions.assertNotNull(widget);
    }

}
