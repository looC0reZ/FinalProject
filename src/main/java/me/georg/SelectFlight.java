package me.georg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {

    public SelectFlight(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//title")
    WebElement title;

    @FindBy (xpath = "(//font[text() = 'DEPART']/following::tr//font)[1]")
    WebElement departInfo;

    @FindBy (xpath = "(//font[text() = 'DEPART']/following::tr//font)[2]")
    WebElement departDate;

    @FindBy (xpath = "(//td//b[contains(.,'Unified Airlines 363')]/preceding::td/input)[last()]")
    WebElement departFlight;

    @FindBy (xpath = "(//td//b[contains(.,'Unified Airlines 363')]/following::tr//b)[1]")
    WebElement departPrice;

    @FindBy (xpath = "(//font[text() = 'RETURN']/following::tr//font)[1]")
    WebElement returnInfo;

    @FindBy (xpath = "(//font[text() = 'RETURN']/following::tr//font)[2]")
    WebElement returnDate;

    @FindBy(xpath = "(//td//b[contains(.,'Blue Skies Airlines 631')]/preceding::td/input)[last()]")
    WebElement returnFlight;

    @FindBy (xpath = "(//td//b[contains(.,'Blue Skies Airlines 631')]/following::tr//b)[1]")
    WebElement returnPrice;

    @FindBy (xpath = "//input[@name='reserveFlights']")
    WebElement continueButton;

    public void setDepartFlight() {
        departFlight.click();
    }

    public void setReturnFlight() {
        returnFlight.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
