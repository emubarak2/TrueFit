package org.truefit.framework.runner;

import com.github.mkolisnyk.cucumber.runner.AfterSubSuite;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

/**
 * this is the cucumber running initiator, which generate reports for each feature
 * @author  eyadm@amazon.com
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
       "pretty", "html:target/cucumber-reports"},
        features = "src/test/resources/feature/web/TrueFit_GoogleVerification.feature",
        monochrome = false,
        tags = "@TestType-Smoke",
        glue = {"org.truefit.stepdefs.web","org.truefit.framework.runner.TestRunner" })
@AllArgsConstructor
public class TestRunner {


    @AfterSubSuite
    public static void tearDown() {

    }
    @Test
    public void runRunner() {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(TestRunner.class);

    }

}
