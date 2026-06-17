package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void testWebsite(String browser) throws Exception {

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if(browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        }

        driver.get("https://www.google.com");

        System.out.println("Running on: " + browser);

        Assert.assertTrue(driver.getTitle().contains("Google"));

        Thread.sleep(3000);

        driver.quit();
    }
}