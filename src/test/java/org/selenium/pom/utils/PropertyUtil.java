package org.selenium.pom.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {


    public static Properties propertyLoader(String path)   {
        Properties properties=new Properties();

        try{
            BufferedReader bf=new BufferedReader(new FileReader("src\\test\\resources\\" +path));
            properties.load(bf);

        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
return properties;

    }

}
