package com.redhat.demo.selenium.config;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonConfig {

    public static ObjectMapper objectMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
        mapper.registerModule(module);

        return mapper;
    }

}
