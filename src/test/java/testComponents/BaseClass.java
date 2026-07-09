package testComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LandingPage landingPage;
    public Properties prop;

    public WebDriver initializeBrowser() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/GlobalData.properties"));

        // used when we give browser name via maven command
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

        // browser initialization
        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            if (browserName.contains("Headless")){
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.contains("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            if (browserName.contains("firefoxHeadless")){
                options.addArguments("headless");
            }
            driver = new FirefoxDriver(options);
        } else if (browserName.contains("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--incognito");
            if (browserName.contains("edgeHeadless")){
                options.addArguments("headless");
            }
        }

        if (!browserName.equalsIgnoreCase("chromeHeadless")
                && !browserName.equalsIgnoreCase("firefoxHeadless") && !browserName.equalsIgnoreCase("edgeHeadless")) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    @BeforeMethod
    public HomePage launchApplication() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/GlobalData.properties"));

        driver = initializeBrowser();
        landingPage = new LandingPage(driver);
        landingPage.goTo(prop.getProperty("url"));
        HomePage homePage = landingPage.login();
        return homePage;
    }

    @AfterMethod
    public void closeApplication(){
        driver.quit();
    }

    // JSON data to string convertor
    public static List<HashMap<String, String>> getDataToMap(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filepath), new TypeReference<List<HashMap<String, String>>>() {
        });
    }

    // Screenshot utility
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("testResult/screenshots/"+testCaseName+".png");
        FileHandler.copy(src, dest);

        return "screenshots/"+testCaseName+".png";
    }
}
