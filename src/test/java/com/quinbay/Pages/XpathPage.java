package com.quinbay.Pages;

import com.quinbay.cucumber.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class XpathPage  {
    WebDriver driver;


    public XpathPage(WebDriver webDriver) {
        driver = webDriver;
    }
    @FindBy(xpath = "//input[@placeholder='Pilih kota asal']")
    WebElement Place_name;
    @FindBy(xpath = "//button[@class='date__text--btn']")
    WebElement Calender;
    @FindBy(xpath = "//button[@data-pika-month='3'][@data-pika-day='30']")
    WebElement click_date;
    @FindBy(xpath = "//button[@class='button button--orange button--big button--full form__button']")
    WebElement Search_go;

    public void name(){
        Place_name.click();
        Place_name.sendKeys("Makassar");
        Place_name.sendKeys(Keys.RETURN);
}







}
