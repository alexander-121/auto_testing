package com.testing;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PageTest {

    private ChromeDriver driver;
    private WebElement element;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Alexander/Downloads/chromedriver2.exe");
        driver = new ChromeDriver();
        System.out.println("Testing started!");
    }


    public void openPage() {


        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        element = driver.findElement(By.xpath("//input[@name =\"q\"]"));

        if (element.isDisplayed()){
            System.out.println("Element is visible!");
        }
        else {
            System.out.println("Element is not visible!");
        }

        element.sendKeys("Netcracker");

        element = driver.findElement(By.xpath("//input[@name =\"btnK\"]"));

        element.click();

        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        //List <WebElement> my_list = driver.findElements(By.xpath("//div[@class=\"r\"]/a"));
        //element = my_list.get(0);
        element = driver.findElement(By.xpath("//div[@class=\"r\"]/a"));
        element.click();

        String path = "c:/BinaryConverter/screenshot-" + new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss", Locale.getDefault()).format(new Date()) + ".png";
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void closeUp() {
        driver.quit();
        System.out.println("Testing ended successfully!");
    }
}
