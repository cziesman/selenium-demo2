package com.redhat.demo.selenium.helper;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.redhat.demo.selenium.config.JacksonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    private static final ObjectMapper objectMapper = JacksonConfig.objectMapper();

    public static void clearTheDatabase() throws IOException, InterruptedException {

        String command = "curl -X 'DELETE' " +
                "  'http://127.0.0.1:8080/widgety/api/widget/deleteAll' " +
                "  -H 'accept: */*'";
        Shell.execute(command);
    }

    public static Widget create(String name, String description) throws IOException, InterruptedException {

        String encName = URLEncoder.encode(name, StandardCharsets.UTF_8.name());
        String encDescription = URLEncoder.encode(description, StandardCharsets.UTF_8.name());

        String command = "curl -X 'PUT' " +
                "  'http://127.0.0.1:8080/widgety/api/widget' " +
                "  -H 'accept: */*' " +
                "  -H 'Content-Type: application/json' " +
                "  -d '{ " +
                "  \"id\": null, " +
                "  \"name\": \"" +
                encName +
                "\", " +
                "  \"description\": \"" +
                encDescription +
                "\" " +
                "}'";
        List<String> result = Shell.execute(command);

        Widget retval = null;
        if (!result.isEmpty()) {
            try {
                retval = objectMapper.readValue(result.get(0), Widget.class);
                LOG.info("{}", retval);
            } catch (UnrecognizedPropertyException ex) {
                try {
                    ErrorResponse errorResponse = objectMapper.readValue(result.get(0), ErrorResponse.class);
                    LOG.info("{}", errorResponse);
                } catch (Throwable t) {
                    LOG.error(t.getMessage(), t);
                }
            }
        } else {
            LOG.info("Could not create widget with name {}", name);
        }

        return retval;
    }

    public static Widget findByName(String name) throws IOException, InterruptedException {

        String encName = URLEncoder.encode(name, StandardCharsets.UTF_8.name());

        String command = "curl -X 'GET' " +
                "  'http://127.0.0.1:8080/widgety/api/widget/name/" +
                encName +
                "' " +
                "  -H 'accept: application/json'";
        List<String> result = Shell.execute(command);

        Widget retval = null;
        if (!result.isEmpty()) {
            try {
                retval = objectMapper.readValue(result.get(0), Widget.class);
                LOG.info("{}", retval);
            } catch (UnrecognizedPropertyException ex) {
                try {
                    ErrorResponse errorResponse = objectMapper.readValue(result.get(0), ErrorResponse.class);
                    LOG.info("{}", errorResponse);
                } catch (Throwable t) {
                    LOG.error(t.getMessage(), t);
                }
            }
        } else {
            LOG.info("No widget found with name {}", name);
        }

        return retval;
    }

    public static List<Widget> findAllWidgets() throws IOException, InterruptedException {

        String command = "curl -X 'GET' " +
                "  'http://127.0.0.1:8080/widgety/api/widgets' " +
                "  -H 'accept: application/json'";
        List<String> result = Shell.execute(command);

        return objectMapper.readValue(result.get(0), new TypeReference<List<Widget>>() {

        });
    }

}
