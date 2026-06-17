package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    @Test
    public void testWebsite() throws InterruptedException {

        WebDriver driver;

        String browser = System.getProperty("browser", "chrome");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);

        } else {

            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.get("https://www.google.com");

        System.out.println("Running Test On: " + browser);

        Thread.sleep(3000);

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Google"));

        driver.quit();
    }
}