package org.selenium.pom.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static Long fakeNumbers(){
        Faker faker=new Faker();
        return faker.number().randomNumber();
    }

}
