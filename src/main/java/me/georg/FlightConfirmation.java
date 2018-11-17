package me.georg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmation {

    public FlightConfirmation(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//tr//font[contains(.,'Departing')]/following::tr//font)[1]")
    WebElement departInfo;

    @FindBy (xpath = "(//tr//font[contains(.,'Returning')]/following::tr//font)[1]")
    WebElement returnInfo;

    @FindBy (xpath = "(//tr//font[contains(.,'Passengers')]/following::tr//font)[1]")
    WebElement passengersInfo;

    @FindBy (xpath = "(//tr//font[contains(.,'Billed')]/following::tr//font)[1]")
    WebElement billedInfo;

    @FindBy (xpath = "(//tr//font[contains(.,'Delivery')]/following::tr//font)[1]")
    WebElement deliveryInfo;

    @FindBy (xpath = "(//td//font/b[contains(.,'Total')]/following::td//font)[1]")
    WebElement totalPrice;

        @FindBy (xpath = "//a[@href='mercurywelcome.php']/img")
    WebElement homeButton;

    public void clickHomeButton() {
        homeButton.click();
    }


}
