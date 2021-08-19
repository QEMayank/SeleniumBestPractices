package org.selenium.pom.utils;

import java.util.Properties;

public class ConfigLoader {

   private Properties properties;
   private static  ConfigLoader configLoader;
    private ConfigLoader() {
        String env=System.getProperty("env","stage");
            switch(env){
                case "stage":
                    properties=PropertyUtil.propertyLoader("stage_config.properties");
                    break;
                case "prod":
                    properties=PropertyUtil.propertyLoader("prod_config.properties");
                    break;
            }
        }

    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getbaseURL(){
        return properties.getProperty("baseURL");

    }


    public String getUsername(){
        return properties.getProperty("username");

    }


    public String getPassword(){
        return properties.getProperty("password");

    }

    
    
    
    
    
    


}
