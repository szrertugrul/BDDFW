package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties configFile;

    // to connect to config.properties directory
    static {
        try{
            FileInputStream fIS = new FileInputStream(  "config.properties");
            configFile = new Properties();
            configFile.load(fIS);
            fIS.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return  configFile.getProperty(key);
    }

}
