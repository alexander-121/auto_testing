package com.app;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PageTst {

    private ChromeDriver driver;
    private WebElement element;


    public PageTst() {
        System.setProperty("webdriver.chrome.driver", "/Users/Alexander/Downloads/chromedriver2.exe");
        driver = new ChromeDriver();
        System.out.println("Testing started!");
    }


    public void openPage(String url) {

        driver.get(url);
        driver.manage().window().maximize();
    }

    public void checkVis(String xpath) {

        element = driver.findElement(By.xpath(xpath));

        if (element.isDisplayed()) {
            System.out.println("Element is visible!");
        } else {
            System.out.println("Element is not visible!");
        }
    }

    public void setTxtVal(String xpath, String text) {

        element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    public void clickElem(String xpath) {

        element = driver.findElement(By.xpath(xpath));
        element.click();
    }

       // element = driver.findElement(By.xpath("//div[@class=\"r\"]/a"));
       // element.click();
    public void prtScr() {

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

