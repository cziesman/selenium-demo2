package com.redhat.demo.selenium.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesHelper {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesHelper.class);

    private static Properties properties;

    private PropertiesHelper() {

    }

    protected static Properties getProperties() {

        if (properties == null) {

            properties = new Properties();
            try (final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties")) {
                properties.load(stream);
                LOG.trace("{}", properties);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }

        return properties;
    }

    public static String get(String key) {

        String prop = getProperties().getProperty(key);
        LOG.trace("{}", prop);

        return prop;
    }

}
