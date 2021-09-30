package com.company.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

        private static Properties propFileContent;

        public static void loadConfigurations() throws IOException {
            InputStream inputStream = null;
            Properties prop = new Properties();

            try {
                File initialFile = new File("C:\\Users\\Kris\\IdeaProjects\\AutomationProject_1\\resources\\config.properties");

                inputStream = new FileInputStream(initialFile);
                prop.load(inputStream);
            } catch (Exception e){
                System.out.println("Exception: " + e);
            } finally {
                inputStream.close();
                propFileContent = prop;
            }
        }

    public static String readDBUsername(){
        return propFileContent.get("DB_USER").toString();
    }

    public static String readDBPass(){
        return propFileContent.get("PASS").toString();
    }
    public static String readDBUrl (){
        return propFileContent.get("DB_URL").toString();
    }
}
