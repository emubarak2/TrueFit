package org.truefit.framework.reporting;


import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.truefit.framework.propmanager.PropManager;

import java.io.File;
import java.io.IOException;

/**
 * this class to generate a report for each scenario
 *
 * @author eyadm@amazon.com
 */

public class ExtentReportHelper {

    /**
     * this method initialize the extent report object
     * @param scenario the scenario to create report for
     * @return initialized ExtentReports object
     */
    public ExtentReports initializeExtentReport(Scenario scenario) {
        ExtentReports extentReports = new ExtentReports(System.getProperty("user.dir") + "\\target\\html-reports\\" + scenario.getName() + ".html");
        extentReports.addSystemInfo("Application Host", PropManager.getInstance().getProperty("web.application.url"));
        extentReports.addSystemInfo("Language", PropManager.getInstance().getProperty("web.language"));
        extentReports.addSystemInfo("Time Test Execution Start:", new DateTime().toString());
        extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
        return extentReports;
    }

    /**
     * the method that generate the reports after execution
     *
     * @param scenario
     * @throws IOException
     */
    public void generateReport(Scenario scenario) throws IOException {
        ScreenShotHelper screenShotHelper = new ScreenShotHelper();
        ExtentReports extentReports = initializeExtentReport(scenario);
        ExtentTest extentTest = extentReports.startTest(scenario.getName());
        screenShotHelper.TakeScreenShot();
        if (scenario.getStatus().equals("failed")) {
            extentTest.log(LogStatus.FAIL, "Scenario with the following name has been failed : " + scenario.getName());
            extentTest.log(LogStatus.FAIL, scenario.getStatus());
            extentTest.log(LogStatus.FAIL, "Please find the attached screen shot for the failure: " + extentTest.addScreenCapture(screenShotHelper.getScreenShotDestination()));
        } else {
            extentTest.log(LogStatus.PASS, "Scenario with name has been passed : " + scenario.getName());
            extentTest.log(LogStatus.PASS, scenario.getStatus());
        }

        endExtentReport(extentReports,extentTest);
    }

    /**
     * this method end the extent report and close it
     * @param extentReports the object of extend report to be closed
     * @param extentTest the extent test object
     */
    public void endExtentReport( ExtentReports extentReports, ExtentTest extentTest) {
        extentReports.endTest(extentTest);
        extentReports.flush();
        extentReports.close();
    }

    /**
     * this method generate running reports of type mkolisnk
     */
    public void generateMkolisnkReport() {
//        CucumberResultsOverview results = new CucumberResultsOverview();
//        results.setOutputDirectory("target");
//        results.setOutputName("cucumber-results");
//        results.setSourceFile("./src/test/resources/cucumber.json");
//
//        try {
//            results.execute();
//        } catch(Exception exception) {
//        }
    }
}
