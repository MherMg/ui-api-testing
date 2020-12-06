package testing.am.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by
 * Mher Petrosyan
 * Email mher13.02.94@gmail.ru
 */

public class HotelPage {

    private final WebDriver driver;

    private final By hotelNameBy = By.className("_3bl6g");

    private final By clickInDate = By.cssSelector("#app > div > div._2yUha > div > div > div._2gYHD > div.indexHotels > div._3acKR > form > div.irJir._2IbCW._1v7Tx > label._3XbwG.CaSUL.datePickerTrigger_viewType_union.datePickerTrigger_type_startDate._2jw4r._3mPdO.datePickerTrigger_viewType_union.datePickerTrigger_type_startDate > div._33iSI");

    private final By startDateBy = By.cssSelector("body > div.Popup2.Popup2_visible.Popup2_direction_bottom-left.Popup2_target_anchor.Popup2_theme_normal.root._3MKnz > div > div > div._3st8e > div > div.oOXaP > div:nth-child(1) > div > div:nth-child(4) > div:nth-child(1)");

    private final By endDateBy = By.cssSelector("body > div.Popup2.Popup2_visible.Popup2_direction_bottom-left.Popup2_target_anchor.Popup2_theme_normal.root._3MKnz > div > div > div._3st8e > div > div.oOXaP > div:nth-child(1) > div > div:nth-child(5) > div:nth-child(3)");

    private final By numberPeople = By.className("_3fhIA");

    private final By findButton = By.cssSelector("#app > div > div._2yUha > div > div > div._2gYHD > div.indexHotels > div._3acKR > form > button");

    private final By hotelLink = By.cssSelector("#app > div > div.noXhp > div > div > div.CKkSA > div._2PyEM > div._2MZqU > div > div._2jKkZ._3_hqO > section > div._2D2qV > a");

    private final By price = By.cssSelector("#app > div > div.noXhp > div > div > div.CKkSA > div._2PyEM > div._2MZqU > div > div._2jKkZ._3_hqO > section:nth-child(1) > div._2D2qV > div > section._2wpun._3ylr_ > div.EFj6a > div > span");


    public HotelPage(WebDriver driver) {

        this.driver = driver;

    }

    public void setHotelName(String hotelName) {

        WebElement element = driver.findElement(hotelNameBy);
        element.sendKeys(hotelName);
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public void selectDate() {
        driver.findElement(clickInDate).click();
        driver.findElement(startDateBy).click();
        driver.findElement(endDateBy).click();

    }

    public String checkNumberPeople() {

        return driver.findElement(numberPeople).getText();
    }


    public void clickFindButton() {

        driver.findElement(findButton).click();

    }


    public String checkPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(price));
        return driver.findElement(price).getText();
    }
}
