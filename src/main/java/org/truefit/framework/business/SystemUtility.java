package org.truefit.framework.business;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.truefit.framework.propmanager.PropManager;

/**
 * this utility class for setting the path in windows style or mac style, based on the related property in the props file
 * @author  eyadm@amazon.com
 */
public class SystemUtility {

    /**
     * this method to change teh path to mac path style or not based on the system property value
     * @param path the path to change to mac style o rnot
     * @return the modified path string
     */
    public static String getSystemPath(String path) {
        if (PropManager.getInstance().getProperty("truefit.system").equals("win")) {
            return path;
        } else {
            return path.replace("\\", "/");
        }
    }

    /**
     * this method to get the driver for chrome for windows or mac based on the system property value
     * @param options chrome options to be filled with driver path
     * @param driverName the driver name
     * @return chrome options filled with correct related value
     */
    public static ChromeOptions getChromeDriverPath(ChromeOptions options, String driverName) {
        if (PropManager.getInstance().getProperty("truefit.system").equals("win")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chrome\\" + PropManager.getInstance().getProperty("truefit.system") + "\\" + driverName + ".exe");
            options.setCapability("chrome.binary", System.getProperty("user.dir") + "\\drivers\\chrome\\" + PropManager.getInstance().getProperty("truefit.system") + "\\" + driverName + ".exe");
            return options;
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/" + PropManager.getInstance().getProperty("truefit.system") + "/" + driverName);
            options.setCapability("chrome.binary", System.getProperty("user.dir") + "/drivers/chrome/" + PropManager.getInstance().getProperty("truefit.system") + "/" + driverName);
            return options;
        }
    }

    /**
     * this method to get the driver for firefox for windows or mac based on the system property value
     * @param options firefox options to be filled with driver path
     * @param driverName the driver name
     * @return firefox options filled with correct related value
     */
    public static FirefoxOptions getFirefoxDriverPath(FirefoxOptions options, String driverName) {
        if (PropManager.getInstance().getProperty("truefit.system").equals("win")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\firefox\\" + PropManager.getInstance().getProperty("truefit.system") + "\\" + driverName + ".exe");
            options.setCapability("firefox.binary", System.getProperty("user.dir") + "\\drivers\\firefox\\" + PropManager.getInstance().getProperty("truefit.system") + "\\" + driverName + ".exe");
            return options;
        } else {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/firefox/" + PropManager.getInstance().getProperty("truefit.system") + "/" + driverName);
            options.setCapability("firefox.binary", System.getProperty("user.dir") + "/drivers/firefox/" + PropManager.getInstance().getProperty("truefit.system") + "/" + driverName);
            return options;
        }
    }
}
