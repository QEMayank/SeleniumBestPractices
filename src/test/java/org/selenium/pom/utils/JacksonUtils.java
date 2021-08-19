package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.Objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String filePath, Class<T> T) throws IOException {
        InputStream is=JacksonUtils.class.getClassLoader().getResourceAsStream(filePath);
        ObjectMapper objectMapper=new ObjectMapper();
//        System.out.println(billingaddress.getClass());
        return objectMapper.readValue(is,T);


    }
}
