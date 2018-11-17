package me.georg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;

public class BookFlight {

    public BookFlight(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private Select select;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[1]")
    WebElement departFlightRoute;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[2]")
    WebElement departDate;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[3]")
    WebElement departFlightInfo;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[7]")
    WebElement departFlightClass;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[8]")
    WebElement departFlightPrice;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[9]")
    WebElement arrivalFlightRoute;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[10]")
    WebElement arrivalDate;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//b)[6]")
    WebElement arrivalFlightInfo;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[19]")
    WebElement arrivalFlightClass;

    @FindBy (xpath = "(//td//font[contains(.,'Summary')]/following::tr//font)[20]")
    WebElement arrivalFlightPrice;

    @FindBy (xpath = "(//td/font[text()='Passengers:']/following::td/font)[1]")
    WebElement passengers;

    @FindBy (xpath = "(//td/font[contains(.,'Taxes:')]/following::td/font)[1]")
    WebElement taxes;

    @FindBy (xpath = "(//td/font[contains(.,'Total Price')]/following::td//b)[1]")
    WebElement totalPrice;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[1]")
    WebElement firstPassFirstName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[2]")
    WebElement firstPassLastName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//select)[1]")
    WebElement firstPassMeal;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[3]")
    WebElement secondPassFirstName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//input)[4]")
    WebElement secondPassLastName;

    @FindBy (xpath = "(//tr//b/font/font[contains(.,'Passengers')]/following::tr//select)[2]")
    WebElement secondPassMeal;

    @FindBy (xpath = "//select[@name='creditCard']")
    WebElement cardType;

    @FindBy (xpath = "//input[@name='creditnumber']")
    WebElement cardNumber;

    @FindBy (xpath = "//select[@name='cc_exp_dt_mn']")
    WebElement expirationMonth;

    @FindBy (xpath = "//select[@name='cc_exp_dt_yr']")
    WebElement expirationYear;

    @FindBy (xpath = "//input[@name='cc_frst_name']")
    WebElement cardFirtName;

    @FindBy (xpath = "//input[@name='cc_mid_name']")
    WebElement cardMidlName;

    @FindBy (xpath = "//input[@name='cc_last_name']")
    WebElement cardLastName;

    @FindBy (xpath = "//input[@name='billAddress1']")
    WebElement billingAddress;

    @FindBy (xpath = "//input[@name='billCity']")
    WebElement billingCity;

    @FindBy (xpath = "//input[@name='billState']")
    WebElement billingState;

    @FindBy (xpath = "//input[@name='billZip']")
    WebElement billingPostalCode;

    @FindBy (xpath = "//select[@name='billCountry']")
    WebElement billingCountry;

    @FindBy (xpath = "//input[@name='ticketLess']")
    WebElement asBillingAddress;

    @FindBy (xpath = "//input[@name='delAddress1']")
    WebElement deliveryAddress;

    @FindBy (xpath = "//input[@name='delCity']")
    WebElement deliveryCity;

    @FindBy (xpath = "//input[@name='delState']")
    WebElement deliveryState;

    @FindBy (xpath = "//input[@name='delZip']")
    WebElement deliveryPostalCode;

    @FindBy (xpath = "//select[@name='delCountry']")
    WebElement deliveryCountry;

    @FindBy (xpath = "//input[@name='buyFlights']")
    WebElement securePurchaseButton;


    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    public void setFirstPassFirstName(String name) {
        firstPassFirstName.clear();
        firstPassFirstName.sendKeys(name);
    }

    public void setFirstPassLastName(String name) {
        firstPassLastName.clear();
        firstPassLastName.sendKeys(name);
    }

    public void setFirstPassMeal(String meal) {
        getSelect(firstPassMeal);
        select.selectByVisibleText(meal);
    }

    public void setSecondPassFirstName(String name) {
        secondPassFirstName.clear();
        secondPassFirstName.sendKeys(name);
    }

    public void setSecondPassLastName(String name) {
        secondPassLastName.clear();
        secondPassLastName.sendKeys(name);
    }

    public void setSecondPassMeal(String meal) {
        getSelect(secondPassMeal);
        select.selectByVisibleText(meal);
    }

    public void setCardType(String type) {
        getSelect(cardType);
        select.selectByVisibleText(type);
    }

    public void setCardNumber(String number) {
        cardNumber.clear();
        cardNumber.sendKeys(number);
    }

    public void setExpirationMonth(String month) {
        getSelect(expirationMonth);
        select.selectByVisibleText(month);
    }

    public void setExpirationYear(String year) {
        getSelect(expirationYear);
        select.selectByVisibleText(year);
    }

    public void setCardOwner(String first, String midle, String last) {
        cardFirtName.clear();
        cardFirtName.sendKeys(first);
        cardMidlName.clear();
        cardMidlName.sendKeys(midle);
        cardLastName.clear();
        cardLastName.sendKeys(last);
    }

    public void setBillingAddress(String address, String city, String state, String zip, String country) {
        billingAddress.clear();
        billingAddress.sendKeys(address);
        billingCity.clear();
        billingCity.sendKeys(city);
        billingState.clear();
        billingState.sendKeys(state);
        billingPostalCode.clear();
        billingPostalCode.sendKeys(zip);
        getSelect(billingCountry);
        select.selectByVisibleText(country);
    }

    public void setAsBillingAddress() {
        asBillingAddress.click();
    }

    public void setDeliveryAddress(String address, String city, String state, String zip, String country) {
        deliveryAddress.clear();
        deliveryAddress.sendKeys(address);
        deliveryCity.clear();
        deliveryCity.sendKeys(city);
        deliveryState.clear();
        deliveryState.sendKeys(state);
        deliveryPostalCode.clear();
        deliveryPostalCode.sendKeys(zip);
        getSelect(deliveryCountry);
        select.selectByVisibleText(country);
    }

    public void clickSecurePurchaseButton() {
        securePurchaseButton.click();
    }









}
