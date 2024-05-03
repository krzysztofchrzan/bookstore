package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CommonConfig {
    public static WebDriver webDriver;
    public static String basePath;

    @Before(value = "@GUI")
    public void setupConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        basePath = properties.getProperty("GUI_PATH");
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver123.exe");
        webDriver = new ChromeDriver();
    }

    @After(value = "@GUI")
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
