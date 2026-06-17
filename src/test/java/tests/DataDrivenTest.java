package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataDrivenTest {

    @Test
    public void readCSVAndRunTest() throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new FileReader("src/test/resources/testdata.csv"));

        String line;

        br.readLine();

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            String name = data[0];
            String email = data[1];
            String phone = data[2];

            WebDriver driver = new ChromeDriver();

            driver.get(
                    "file:///C:/Users/Aditya%20kumar/IdeaProjects/untitled2/form.html"
            );

            Thread.sleep(1000);

            driver.findElement(By.id("name"))
                    .sendKeys(name);

            driver.findElement(By.id("email"))
                    .sendKeys(email);

            driver.findElement(By.id("phone"))
                    .sendKeys(phone);

            driver.findElement(By.id("submitBtn"))
                    .click();

            Thread.sleep(2000);

            System.out.println(
                    "Executed for: "
                            + name
            );

            driver.quit();
        }

        br.close();
    }
}