package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runnerTest.webPages.ElementUtil;
import utils.BasePage;
import utils.ConfigReader;

public class SharedSD {
            // Hook Class
    ElementUtil elementUtil = new ElementUtil(); // inheritance
    // to store all the log files in logs/application.txt
    private static Logger logger = Logger.getLogger(SharedSD.class); // org.apache.log4j

    @Before //cucumber.api.java
    public void setUp(){
        logger.info("***************************");
        logger.info("Test is initializing..!");
        ConfigReader.getProperty("browser");
        BasePage.get().get(ConfigReader.getProperty("url"));
        BasePage.get().manage().window().maximize();
    }

    @After //cucumber.api.java
    public void tearDown(Scenario scenario){ // cucumber.api -- provides lots of methods
        if (scenario.isFailed()){
            logger.error("Test Failed");
            byte[] screenshot = ((TakesScreenshot)BasePage.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            //type " after screenshot, mimeType will appear automatically
            //mimeType is important feature to declare the type of the file
            elementUtil.getScreenShot("pic");
        }else{
            logger.info("Cleaning up..!");
            logger.info("Test accomplished!");
        }
        logger.info("***************************");
        BasePage.closeBrowser();
    }
}
