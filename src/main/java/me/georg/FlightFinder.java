package me.georg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder {

    public FlightFinder(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private Select select;

    @FindBy (xpath = "//title)")
    String title;

    @FindBy (xpath = "//input[@value='roundtrip']")
    WebElement roundTrip;

    @FindBy (xpath = "//input[@value='oneway']")
    WebElement oneWay;

    @FindBy (xpath = "//select[@name='passCount']")
    WebElement passengers;

    @FindBy (xpath = "//select[@name='fromPort']")
    WebElement departningFrom;

    @FindBy (xpath = "//select[@name='fromMonth']")
    WebElement fromMonth;

    @FindBy (xpath = "//select[@name='fromDay']")
    WebElement fromDay;

    @FindBy (xpath = "//select[@name='toPort']")
    WebElement arrivingIn;

    @FindBy (xpath = "//select[@name='toMonth']")
    WebElement toMonth;

    @FindBy (xpath = "//select[@name='toDay']")
    WebElement toDay;

    @FindBy (xpath = "//input[@value='Coach']")
    WebElement economyClass;

    @FindBy (xpath = "//input[@value='Business']")
    WebElement businessClass;

    @FindBy (xpath = "//input[@value='First']")
    WebElement firstClass;

    @FindBy (xpath = "//select[@name='airline']")
    WebElement airline;

    @FindBy (xpath = "//input[@name='findFlights']")
    WebElement continueButton;

    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    public void setRoundTrip() {
        roundTrip.click();
    }

    public void setOneWay() {
        oneWay.click();
    }

    public void setPassengers(String numberOfPassengers) {
        getSelect(passengers);
        select.selectByVisibleText(numberOfPassengers);
    }

    public void setDepartningFrom(String fromPort) {
        getSelect(departningFrom);
        select.selectByVisibleText(fromPort);
    }

    public void setOnMonth(String onMonth) {
        getSelect(fromMonth);
        select.selectByVisibleText(onMonth);
    }

    public void setOnDay(String onDay) {
        getSelect(fromDay);
        select.selectByVisibleText(onDay);
    }

    public void setOnDate(String month, String day) {
        setOnMonth(month);
        setOnDay(day);
    }

    public void setArrivingIn(String toPort) {
        getSelect(arrivingIn);
        select.selectByVisibleText(toPort);
    }

    public void setReturningMonth(String returningMonth) {
        getSelect(toMonth);
        select.selectByVisibleText(returningMonth);
    }

    public void setReturningDay(String returningDay) {
        getSelect(toDay);
        select.selectByVisibleText(returningDay);
    }

    public void setReturningDate(String month, String day) {
        setReturningMonth(month);
        setReturningDay(day);
    }

    public void setEconomyClass() {
        economyClass.click();
    }

    public void setBusinessClass() {
        businessClass.click();
    }

    public void setFirstClass() {
        firstClass.click();
    }

    public void setAirline(String airlineName) {
        getSelect(airline);
        select.selectByVisibleText(airlineName);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
