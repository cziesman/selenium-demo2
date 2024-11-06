package com.redhat.demo.selenium;

import java.io.IOException;

import com.redhat.demo.selenium.helper.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before() throws IOException, InterruptedException {

        Utils.clearTheDatabase();
    }

    @After
    public void after() throws IOException, InterruptedException {

        Utils.clearTheDatabase();
    }

}
