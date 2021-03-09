package com.quinbay.Steps;

import com.quinbay.Pages.XpathPage;
import com.quinbay.Utils.Actionpage;
import com.quinbay.cucumber.CucumberHooks;
import com.quinbay.cucumber.CucumberRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.tools.tree.AssignShiftLeftExpression;

import javax.swing.*;

import static com.quinbay.Utils.Propertypage.prop;

import java.util.LinkedHashMap;
import java.util.List;

public class MyStepdefs {
    CucumberHooks action = new CucumberHooks();
    LinkedHashMap map=new LinkedHashMap();
    @Given("^I am on  Travel page$")
    public void getUrl() {
        action.driver.get("https://www.blibli.com/travel");
    }
    @Then("change the place name")
    public void changeThePlaceName() throws InterruptedException {
        Thread.sleep(3000);
        WebElement place=action.driver.findElement(By.xpath("//input[@placeholder='Pilih kota asal']"));
        place.click();
        place.sendKeys("Makassar");
        place.sendKeys(Keys.RETURN);
       // Assert.assertEquals("Makassar",place.getText());
        action.driver.findElement(By.xpath("//button[@class='date__text--btn']")).click();
       // Thread.sleep(3000);
        action.driver.findElement(By.xpath("//button[@data-pika-month='3'][@data-pika-day='30']")).click();
    }

    @And("I click on Find ticket")
    public void iClickOnFindTicket() {
        action.driver.findElement(By.xpath("//button[@class='button button--orange button--big button--full form__button']")).click();
    }
    @And("click on detail and do the assert")
    public void clickOnDetailAndDoTheAssert() throws InterruptedException {
        Thread.sleep(10000);
        action.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[7]/div/div/div[1]/div[2]/div/ul/li[1]")).click();
        Thread.sleep(3000);
        map.put("source",action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Makassar (UPG)')]")).getText());
        map.put("destination",action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());
        map.put("sourcetime",action.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'09:10')]")).getText());
        map.put("destinationtime",action.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'10:30')]")).getText());
        map.put("Flight",action.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'JT-741')]")).getText());
    }

    @And("click on Select go")
    public void clickOnSelectGo() throws InterruptedException {
        Thread.sleep(1000);
        action.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[7]/div/div/div[2]/button")).click();

    }
    @And("click on detials on filling page and assert values")
    public void clickOnDetialsOnFillingPageAndAssertValues() throws InterruptedException {
        Thread.sleep(5000);
        action.driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(map.get("source"),action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Makassar (UPG)')]")).getText());System.out.println("getting source place");
        Assert.assertEquals(map.get("destination"),action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());System.out.println("getting destination place");
        Assert.assertEquals(map.get("sourcetime"),action.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'09:10')]")).getText());System.out.println("getting arriving time");
        Assert.assertEquals(map.get("destinationtime"),action.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'10:30')]")).getText());System.out.println("getitng destination time");
        Assert.assertEquals(map.get("Flight"),action.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'JT-741')]")).getText());System.out.println("getting flight number");
        action.driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
    }



    @And("user fills the details and confirm order")
    public void userFillsTheDetailsAndConfirmOrder() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element=action.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/select"));
        Select sel=new Select(element);
        sel.selectByVisibleText("Nyonya");
        Thread.sleep(1000);
        action.driver.findElement(By.xpath("//input[@name='fullName']")).sendKeys("chai");
        action.driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345678650");
        action.driver.findElement(By.xpath("//input[@name='email']")).sendKeys("chait@gmail.com");
        action.driver.findElement(By.xpath("//label[@for='copy_contact']")).click();

        action.driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
        action.driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
        Thread.sleep(10000);
        //action.driver.findElement(By.xpath(prop.getProperty("paydetils"))).click();

    }

    @And("Assert details in payment page")
    public void assertDetailsInPaymentPage() throws InterruptedException {
        action.driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(map.get("source"),action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Makassar (UPG)')]")).getText());System.out.println("getiing source place");
        Assert.assertEquals(map.get("destination"),action.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());System.out.println("getiing destination place");
        Assert.assertEquals(map.get("sourcetime"),action.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'09:10')]")).getText());System.out.println("getting source time");
        Assert.assertEquals(map.get("destinationtime"),action.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'10:30')]")).getText());System.out.println("getting destination time");
        Assert.assertEquals(map.get("Flight"),action.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'JT-741')]")).getText()); System.out.println("getting fight number");
        action.driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
    }


}
