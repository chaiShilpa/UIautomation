package com.quinbay.Steps;

import com.quinbay.cucumber.CucumberHooks;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.omg.PortableInterceptor.ACTIVE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;
import java.util.List;

import static com.quinbay.Utils.Propertypage.prop;

public class StepsPage {
    CucumberHooks actions = new CucumberHooks();
    LinkedHashMap map=new LinkedHashMap();
    @Given("User is on  Travel page")
    public void userIsOnTravelPage() {
        actions.driver.get("https://www.blibli.com/travel");
    }

    @Then("change the date")
    public void changeTheDate() throws InterruptedException {
        Thread.sleep(2000);
        actions.driver.findElement(By.xpath("//button[@class='date__text--btn']")).click();
        actions.driver.findElement(By.xpath("//button[@data-pika-month='3'][@data-pika-day='30']")).click();
    }

    @And("I click on Find tickets")
    public void iClickOnFindTickets() {
        actions.driver.findElement(By.xpath("//button[@class='button button--orange button--big button--full form__button']")).click();
    }

    @And("click on detail on flight list page and do the assert")
    public void clickOnDetailOnFlightListPageAndDoTheAssert() throws InterruptedException {
        Thread.sleep(5000);
        actions.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[4]/div/div/div[1]/div[2]/div/ul/li[1]/a")).click();

        map.put("source",actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Jakarta (CGK)')]")).getText());
        map.put("destination",actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Surabaya (SUB)')]")).getText());
        map.put("destination2",actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());
        map.put("sourcetime1",actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'05:35')]")).getText());
        map.put("destinationtime1",actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'07:05')]")).getText());
        map.put("sourcetime2",actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'13:50')]")).getText());
        map.put("destinationtime2",actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'15:45')]")).getText());
        map.put("Flight1",actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-7688')]")).getText());
        map.put("Flight2",actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-629')]")).getText());
//        Thread.sleep(1000);
//        actions.driver.findElement(By.xpath(prop.getProperty("closeicon"))).click();
    }

    @And("click on Select_go")
    public void clickOnSelect_go() {
        actions.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[4]/div/div/div[2]/button")).click();
    }

    @And("click on detials in filling page and assert values")
    public void clickOnDetialsInFillingPageAndAssertValues() throws InterruptedException {
        Thread.sleep(5000);
        actions.driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(map.get("source"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Jakarta (CGK)')]")).getText());
        Assert.assertEquals(map.get("destination"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Surabaya (SUB)')]")).getText());
        Assert.assertEquals(map.get("destination2"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());
        Assert.assertEquals(map.get("sourcetime1"),actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'05:35')]")).getText());
        Assert.assertEquals(map.get("destinationtime1"),actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'07:05')]")).getText());
        Assert.assertEquals(map.get("sourcetime2"),actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'13:50')]")).getText());
        Assert.assertEquals(map.get("destinationtime2"),actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'15:45')]")).getText());
        Assert.assertEquals(map.get("Flight1"),actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-7688')]")).getText());
        Assert.assertEquals(map.get("Flight2"),actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-629')]")).getText());
        actions.driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
        Thread.sleep(3000);
        System.out.println("details on filling page");
    }

    @And("after filling the details do confirm order")
    public void afterFillingTheDetailsDoConfirmOrder() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element=actions.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/select"));
        Select sel=new Select(element);
        sel.selectByVisibleText("Nyonya");
        Thread.sleep(1000);
        actions.driver.findElement(By.xpath("//input[@name='fullName']")).sendKeys("chai");
        actions.driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
        actions.driver.findElement(By.xpath("//input[@name='email']")).sendKeys("chai@gmail.com");
        actions.driver.findElement(By.xpath("//label[@for='copy_contact']")).click();
        //action.driver.findElement(By.xpath("Details")).click();
        Select s1=new Select(actions.driver.findElement(By.xpath("Date=//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[1]/select")));s1.selectByVisibleText("21");
        Select s2=new Select(actions.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[2]/select")));s2.selectByVisibleText("Mei");
        Select s3=new Select(actions.driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[3]/select")));s3.selectByVisibleText("1999");
        actions.driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
        actions.driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
        Thread.sleep(10000);
    }

    @And("Assert details in payment page for transit")
    public void assertDetailsInPaymentPageForTransit() {
        actions.driver.findElement(By.xpath("//a[contains(text(),'Detail')]")).click();
        Assert.assertEquals(map.get("source"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Jakarta (CGK)')]")).getText());System.out.println("getting source place");
        Assert.assertEquals(map.get("destination"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__departure']/div[contains(text(),'Surabaya (SUB)')]")).getText());System.out.println("getting destination1 place");
        Assert.assertEquals(map.get("destination2"),actions.driver.findElement(By.xpath("//div[@class='hub__flight-detail-right__arrival']/div[contains(text(),'Denpasar (DPS)')]")).getText());System.out.println("getting destination2 place");
        Assert.assertEquals(map.get("sourcetime1"),actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'05:35')]")).getText());System.out.println("getting sourcetime2");
        Assert.assertEquals(map.get("destinationtime1"),actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'07:05')]")).getText());System.out.println("getiing source time");
        Assert.assertEquals(map.get("sourcetime2"),actions.driver.findElement(By.xpath("//div[@class='route__departure-time']/span[contains(text(),'13:50')]")).getText());System.out.println("getiing destination1 time");
        Assert.assertEquals(map.get("destinationtime2"),actions.driver.findElement(By.xpath("//div[@class='route__arrival-time']/span[contains(text(),'15:45')]")).getText());System.out.println("getiing destination2 time");
        Assert.assertEquals(map.get("Flight1"),actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-7688')]")).getText());System.out.println("flight1");System.out.println("");
        Assert.assertEquals(map.get("Flight2"),actions.driver.findElement(By.xpath("//div[@class='route__departure-airline-logo']/following::div[contains(text(),'QZ-629')]")).getText());

        System.out.println("fight is present");

        actions.driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
    }
}
