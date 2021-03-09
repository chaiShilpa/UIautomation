package com.quinbay.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
    }
    @Before
    public void Browser(){
        driver.manage().window().maximize();
    }
//    @After
//    public void Qiut() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
}
