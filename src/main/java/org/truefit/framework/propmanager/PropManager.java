package org.truefit.framework.propmanager;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * this class deal with properties files, get, set, list, scan
 *
 * @author eyadm@amazo.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class PropManager {

    private static PropManager instance = null;
    Map<String, Properties> propertiesValues = new HashMap<>();
    private String targetClassesPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator;
    private String targetTestClassesPath = System.getProperty("user.dir") + File.separator+ "target" + File.separator + "test-classes" + File.separator;

    /**
     * this to create an  instance of the proper manager class
     *
     * @return PropManger object
     */
    public synchronized static PropManager getInstance() {
        if (instance == null) {
            instance = new PropManager();
        }
        return instance;
    }

    /**
     * this method scan all the properties files in the target folder and list them in a hashMap,
     * with file name as the key and the file as value
     */
    private void loadPropertiesFromResource() {
        Properties appProps;
        File directory = new File(targetTestClassesPath);
        File[] fList = directory.listFiles();

        if (fList != null) {
            for (File file : fList) {
                if (file.isFile() && FilenameUtils.getExtension(file.getPath()).equals("properties")) {
                    appProps = loadProperties(file.getPath());
                    propertiesValues.put(file.getName(), appProps);
                }
            }
        }
        directory = new File(targetClassesPath);
        fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile() && FilenameUtils.getExtension(file.getPath()).equals("properties")) {
                    propertiesValues.put(file.getName(), loadProperties(file.getPath()));
                }
            }
        }
    }

    /**
     * this method to get the property value of the provided key value as argument
     *
     * @param name the property name to get value for
     * @return property value
     */
    public String getProperty(String name) {
        if (propertiesValues.size() == 0) {
            loadPropertiesFromResource();
        }
        String propertyValue = propertiesValues.entrySet().stream().filter(p -> p.getValue().getProperty(name) != null).map(d -> d.getValue().getProperty(name)).findAny().orElse("");
        return propertyValue;
    }


    /**
     * this method load properties from a specific file, that is provided as argument to this method
     *
     * @param filePath the file targetClassesPath to load properties from
     * @return properties object for the specified file
     */
    public Properties loadProperties(String filePath) {
        Properties localProperties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (IOException exception) {
            log.info("Error at loadProperties in PropManger class" + exception);
        }

        log.info("Reading property file : " + filePath);
        log.info("***** loading property file: " + filePath);
        try {
            if (inputStream != null) {
                localProperties.load(inputStream);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (inputStream == null) {
            String message = "property file '" + filePath
                    + "' not found in the classpath";
            log.info(message);
        }
        return localProperties;
    }
}