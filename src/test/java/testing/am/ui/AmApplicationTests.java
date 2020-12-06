package testing.am.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testing.am.ui.pages.HotelPage;

import java.util.concurrent.TimeUnit;

public class AmApplicationTests {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://travel.yandex.ru/hotels/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        this.driver.close();
    }


    @Test
    public void chooseHotelAndCheckPrice() {
        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.setHotelName("Космос 3 Москва");
        //date from 12/14 to 12/23
        hotelPage.selectDate();
        Assert.assertTrue(hotelPage.checkNumberPeople().toLowerCase().contains("2 взрослых"));
        hotelPage.clickFindButton();
        // price 26080
        Assert.assertTrue(hotelPage.checkPrice().contains("26 080 ₽"));

    }

}
