package org.truefit.framework.reporting;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.truefit.framework.business.SystemUtility;
import org.truefit.framework.factory.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * this class for taking screen shots during test execution
 *
 * @author eyadm@amazon.com
 */
public class ScreenShotHelper {

    String dest;

    /**
     * this method take a screen shot of the current page when called by another calss
     *
     * @return return bytes array represent the image data
     * @throws IOException incas writing the image data on disk gave failure
     */
    public byte[] TakeScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) new DriverFactory().getDriver()).getScreenshotAs(OutputType.FILE);
        String fileName = "AUT-" + DateTime.now().toString("yyyyMMddHHmmssSSS") + ".png";
        dest = SystemUtility.getSystemPath(System.getProperty("user.dir") + "\\target\\screenshots\\" + fileName);
        FileUtils.copyFile(scrFile, new File(SystemUtility.getSystemPath(System.getProperty("user.dir") + "\\target\\screenshots\\" + fileName)), true);
        InputStream is = new FileInputStream(scrFile);
        return IOUtils.toByteArray(is);

    }

    public String getScreenShotDestination() {
        return dest;
    }

}
