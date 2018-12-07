package org.truefit.framework.runner;

import com.github.mkolisnyk.cucumber.runner.AfterSubSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * this is the cucumber running initiator, which generate reports for each feature
 * @author  eyadm@amazon.com
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        jsonReports = "target/cucumber-usage.json",
        toPDF = true,
        outputFolder = "target")
@CucumberOptions(plugin = {  "html:target/cucumber-html-report2",
        "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml" },
        features = "src/test/resources/feature/web/TrueFit_GoogleVerification.feature",
        monochrome = true,
        tags = "@TestType-Smoke",
        glue = {"org.truefit.stepdefs.web" })
@AllArgsConstructor
public class TestRunner2 {


    @AfterSubSuite
    public static void tearDown() {


    }
    @Test
    public void runRunner() {

    }

}
