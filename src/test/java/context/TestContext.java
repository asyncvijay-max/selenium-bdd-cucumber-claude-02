package context;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pagemanager.PageManager;
import pages.*;

public class TestContext {

    private WebDriver driver;
    private PageManager pageManager;

    public TestContext() {

        System.out.println("....Test Context Constructor called....");
    }

    public void initialDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        ConfigReader config = ConfigReader.getConfigReader();
        String browser = config.getBrowser();
        boolean headless = Boolean.parseBoolean(config.getHeadless());

        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1920,1080");
                }
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("-headless", "-width=1920", "-height=1080");
                }
                driver = new FirefoxDriver(options);
                break;
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1920,1080");
                }
                driver = new EdgeDriver(options);
                break;
            }
            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: '" + browser + "'. Use chrome, firefox or edge.");
        }

        if (!headless) {
            driver.manage().window().maximize();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }


    public PageManager getPageManager() {

        if (pageManager == null) {
            pageManager =  new PageManager(driver);
        }

        return pageManager;

    }


}
