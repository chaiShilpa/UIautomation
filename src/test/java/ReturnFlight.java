import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class ReturnFlight {
    static WebDriver driver;
    JavascriptExecutor js;
    LinkedHashMap map = new LinkedHashMap();

    @Given("User should go to the home page of the blibli travel website")
    public void userShouldGoToTheHomePageOfTheBlibliTravelWebsite() {
        System.out.println("Navigate to the blibli travel website");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","path/to/driver/exe");
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
        System.out.println("Navigated to the blibli travel website");

    }

    @Then("Enter the details to book")
    public void enterTheDetailsToBook() throws InterruptedException {
        System.out.println("User enters the details");
        Thread.sleep(2000);
        WebElement place=driver.findElement(By.xpath("//input[@placeholder='Pilih kota tujuan']"));
        place.sendKeys("Surabaya");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class=\"date__text--btn\"]")).click();
        driver.findElement(By.xpath("//button[@data-pika-month='3'][@data-pika-day='30']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//small[contains(text(),'Pulang Pergi')]")).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");
    }

    @And("Click book a flight to book")
    public void clickBookAFlightToBook() throws InterruptedException {
        System.out.println("User clicks book flight button");
        driver.findElement(By.xpath("//button[@class=\"button button--orange button--big button--full form__button\"]")).click();
        Thread.sleep(3000);
        System.out.println("Book button was clicked by user");
    }

    @And("Scroll the page until the required flight is seen")
    public void scrollThePageUntilTheRequiredFlightIsSeen() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
    }

    @And("Click on the detail section and store details in map")
    public void clickOnTheDetailSectionAndStoreDetailsInMap() throws InterruptedException {
        System.out.println("Click on the detail section and store details in a map");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[1]/div[2]/div/ul/li[1]/a")).click();
        map.put("source1",driver.findElement(By.xpath("//div[contains(text(),'Jakarta (CGK)')]")).getText());
        map.put("destination1",driver.findElement(By.xpath("//div[@class=\"hub__flight-detail-right__arrival\"]/div[contains(text(),'Surabaya (SUB)')]")).getText());
        map.put("Airline-code1",driver.findElement(By.xpath("//div[@class=\"route__departure-airline-code\"]")).getText());
        map.put("start-time1",driver.findElement(By.xpath("//div[@class=\"route__departure-time\"]")).getText());
        map.put("end-time1",driver.findElement(By.xpath("//div[@class=\"route__arrival-time\"]")).getText());
        System.out.println("The details are stored in a map");

    }

    @And("Click on select go button")
    public void clickOnSelectGoButton() {
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[2]/button")).click();
    }

    @And("Click on the detail section and verify details")
    public void clickOnTheDetailSectionAndVerifyDetails() throws InterruptedException {

            System.out.println("Click on detail section and verify details");
            Thread.sleep(5000);
            //detail= prop.getProperty("detail1");
            driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a")).click();
            //driver.findElement(By.xpath(detail)).click();
            Thread.sleep(3000);
            assertEquals(map.get("source1"), driver.findElement(By.xpath("//div[@class=\"route__departure-city\"]")).getText());
            assertEquals(map.get("destination1"), driver.findElement(By.xpath("//div[@class=\"route__arrival-city padding-top-10\"]")).getText());
            assertEquals(map.get("Airline-code1"), driver.findElement(By.xpath("//div[@class=\"route__departure-airline-code\"]")).getText());
            assertEquals(map.get("start-time1"), driver.findElement(By.xpath("//div[@class=\"route__departure-time\"]")).getText());
            assertEquals(map.get("end-time1"), driver.findElement(By.xpath("//div[@class=\"route__arrival-time\"]")).getText());
            Thread.sleep(3000);
            driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
            System.out.println("The details are verified");

        }


    @And("Enter the details to proceed to order")
    public void enterTheDetailsToProceedToOrder() throws InterruptedException {
      System.out.println("User enters the details");
        Thread.sleep(3000);
        Select surname = new Select(driver.findElement(By.name("title")));
        surname.selectByVisibleText("Nona");
        driver.findElement(By.name("fullName")).sendKeys("Samyuktha");
        driver.findElement(By.name("phoneNumber")).sendKeys("08594389534");
        driver.findElement(By.name("email")).sendKeys("samyuktha@gmail.com");
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/label")).click();
        System.out.println("The details are entered");
    }

    @And("Click on continue ordering to book")
    public void clickOnContinueOrderingToBook() throws InterruptedException {
        {
            System.out.println("Click on continue to continue booking");
            driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
            Thread.sleep(5000);
            js.executeScript("window.scrollBy(0,600)");
        }
    }
    @And("Click on the detail section and verify the details")
    public void clickOnTheDetailSectionAndVerifyTheDetails() throws InterruptedException {
            System.out.println("Click on continue to continue booking");
            driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
            Thread.sleep(5000);
            js.executeScript("window.scrollBy(0,600)");
        }
    }
