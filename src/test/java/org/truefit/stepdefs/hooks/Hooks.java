package org.truefit.stepdefs.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.truefit.framework.reporting.ExtentReportHelper;

import java.io.IOException;
import java.util.logging.Logger;


public class Hooks {
    private static Logger Log = Logger.getLogger(Hooks.class.getName());

    @Before
    public void beforeScenario(Scenario scenario) {
        Log.info("STARTING SCENARIO" + scenario.getName() );
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        Log.info("Finishing SCENARIO"+ scenario.getName() );
        ExtentReportHelper extentReportHelper = new ExtentReportHelper();
        extentReportHelper.generateReport(scenario);
        extentReportHelper.generateMkolisnkReport();
    }

}
