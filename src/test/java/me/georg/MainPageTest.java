package me.georg;

import com.sun.javafx.PlatformUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static java.lang.Integer.parseInt;

public class MainPageTest {

    private static WebDriver webDriver;
    private static EventFiringWebDriver driver;

    private String LOGIN = "test1";
    private String PASSWORD = "test1";
    private int PASSENGERS = 2;
    private String DEPART = "Paris";
    private int DEPART_MONTH_NUMBER = 11;
    private int DEPART_DAY = 20;
    private String ARRIVAL = "Seattle";
    private int ARRIVAL_MONTH_NUMBER = 12;
    private int ARRIVAL_DAY = 19;
    private String CLASS = "Business";
    private String AIRLINES = "Pangea Airlines";
    private String DEPART_FLIGHT_INFO = "Unified Airlines 363";
    private String ARRIVAL_FLIGHT_INFO = "Blue Skies Airlines 631";
    private int TAXES = 91;
    private String FIRST_PASS_FIRST_NAME = "Ivanov";
    private String FIRST_PASS_LAST_NAME = "Ivan";
    private String FIRST_PASS_MEAL = "Hindu";
    private String SECOND_PASS_FIRST_NAME = "Ivanova";
    private String SECOND_PASS_LAST_NAME = "Irina";
    private String SECOND_PASS_MEAL = "Bland";
    private String CARD_TYPE = "Visa";
    private String CARD_NUMBER = "5479540454132487";
    private String CARD_EXPIRATION_MONTH = "05";
    private String CARD_EXPIRATION_YEAR = "2009";
    private String CARD_OWNER_FIRST_NAME = "Ivan";
    private String CARD_OWNER_MIDLE_NAME = "Ivanovich";
    private String CARD_OWNER_LAST_NAME = "Ivanow";
    private String BILLING_ADDRESS = "1085 Borregas Ave.";
    private String BILLING_CITY = "Albuquerque";
    private String BILLING_STATE = "New Mexico";
    private String BILLING_ZIP = "94089";
    private String BILLING_COUNTRY = "UNITED STATES";
    private String DELIVERY_ADDRESS = "1225 Borregas Ave.";
    private String DELIVERY_CITY = "Boston";
    private String DELIVERY_STATE = "Massachusetts";
    private String DELIVERY_ZIP = "94089";
    private String DELIVERY_COUNTRY = "UNITED STATES";
    private String TITLE1 = "Find a Flight";
    private String TITLE2 = "Select a Flight";
    private String TITLE3 = "Book a Flight";
    private String TITLE4 = "Flight Confirmation";

    private String departDate;
    private String arrivalDate;
    private String routeTo;
    private String routeFrom;
    private int departPrice;
    private int departPriceCheck;
    private int returnPrice;
    private int returnPriceCheck;
    private int totalPrice;
    private int totalPriceCheck;
    private String billedFullName;

    private String monthToString(int intMonth) {
        String monthString = new String();
        switch (intMonth) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
        }
        return monthString;
    }


    @BeforeClass
    public static void init(){
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        } else  if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        }
        webDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(webDriver);
        driver.register(new EventHandler());
        driver.get("http://newtours.demoaut.com/");
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login(LOGIN, PASSWORD);

        FlightFinder flightFinder = new FlightFinder(driver);
        Assert.assertTrue(driver.getTitle().contains(TITLE1));
        flightFinder.setOneWay();
        flightFinder.setPassengers(Integer.toString(PASSENGERS));
        flightFinder.setDepartningFrom(DEPART);
        flightFinder.setOnDate(monthToString(DEPART_MONTH_NUMBER), Integer.toString(DEPART_DAY));
        flightFinder.setArrivingIn(ARRIVAL);
        flightFinder.setReturningDate(monthToString(ARRIVAL_MONTH_NUMBER), Integer.toString(ARRIVAL_DAY));
        flightFinder.setBusinessClass();
        flightFinder.setAirline(AIRLINES);
        flightFinder.clickContinueButton();

        SelectFlight selectFlight = new SelectFlight(driver);
        Assert.assertTrue(driver.getTitle().contains(TITLE2));
        routeTo = DEPART + " to " + ARRIVAL;
        Assert.assertEquals(routeTo, selectFlight.departInfo.getText());
        departDate = DEPART_MONTH_NUMBER + "/" + DEPART_DAY + "/2018";
        Assert.assertEquals(departDate, selectFlight.departDate.getText());
        selectFlight.setDepartFlight();
        departPrice = parseInt(selectFlight.departPrice.getText().replaceAll("[^0-9]", ""));
        routeFrom = ARRIVAL + " to " + DEPART;
        Assert.assertEquals(routeFrom, selectFlight.returnInfo.getText());
        arrivalDate = ARRIVAL_MONTH_NUMBER + "/" + ARRIVAL_DAY + "/2018";
        Assert.assertEquals(arrivalDate, selectFlight.returnDate.getText());
        selectFlight.setReturnFlight();
        returnPrice = parseInt(selectFlight.returnPrice.getText().replaceAll("[^0-9]", ""));
        selectFlight.clickContinueButton();

        BookFlight bookFlight = new BookFlight(driver);
        Assert.assertTrue(driver.getTitle().contains(TITLE3));
        Assert.assertEquals(routeTo, bookFlight.departFlightRoute.getText());
        Assert.assertEquals(departDate, bookFlight.departDate.getText());
        Assert.assertEquals(DEPART_FLIGHT_INFO, bookFlight.departFlightInfo.getText());
        Assert.assertEquals(CLASS, bookFlight.departFlightClass.getText());
        departPriceCheck = parseInt(bookFlight.departFlightPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(departPrice, departPriceCheck);
        Assert.assertEquals(routeFrom, bookFlight.arrivalFlightRoute.getText());
        Assert.assertEquals(arrivalDate, bookFlight.arrivalDate.getText());
        Assert.assertEquals(ARRIVAL_FLIGHT_INFO, bookFlight.arrivalFlightInfo.getText());
        Assert.assertEquals(CLASS, bookFlight.arrivalFlightClass.getText());
        returnPriceCheck = parseInt(bookFlight.arrivalFlightPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(returnPrice, returnPriceCheck);
        Assert.assertEquals(Integer.toString(PASSENGERS), bookFlight.passengers.getText());
        Assert.assertTrue(bookFlight.taxes.getText().contains(Integer.toString(TAXES)));
        totalPrice = (departPrice + returnPrice) * PASSENGERS + TAXES;
        totalPriceCheck = parseInt(bookFlight.totalPrice.getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(totalPrice, totalPriceCheck);
        bookFlight.setFirstPassFirstName(FIRST_PASS_FIRST_NAME);
        bookFlight.setFirstPassLastName(FIRST_PASS_LAST_NAME);
        bookFlight.setFirstPassMeal(FIRST_PASS_MEAL);
        bookFlight.setSecondPassFirstName(SECOND_PASS_FIRST_NAME);
        bookFlight.setSecondPassLastName(SECOND_PASS_LAST_NAME);
        bookFlight.setSecondPassMeal(SECOND_PASS_MEAL);
        bookFlight.setCardType(CARD_TYPE);
        bookFlight.setCardNumber(CARD_NUMBER);
        bookFlight.setExpirationMonth(CARD_EXPIRATION_MONTH);
        bookFlight.setExpirationYear(CARD_EXPIRATION_YEAR);
        bookFlight.setCardOwner(CARD_OWNER_FIRST_NAME, CARD_OWNER_MIDLE_NAME, CARD_OWNER_LAST_NAME);
        bookFlight.setBillingAddress(BILLING_ADDRESS, BILLING_CITY, BILLING_STATE, BILLING_ZIP, BILLING_COUNTRY);
        bookFlight.setAsBillingAddress();
        bookFlight.setDeliveryAddress(DELIVERY_ADDRESS, DELIVERY_CITY, DELIVERY_STATE, DELIVERY_ZIP, DELIVERY_COUNTRY);
        bookFlight.clickSecurePurchaseButton();

        FlightConfirmation flightConfirmation = new FlightConfirmation(driver);
        Assert.assertTrue(driver.getTitle().contains(TITLE4));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(routeTo));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(departDate));
        Assert.assertTrue(flightConfirmation.departInfo.getText().contains(DEPART_FLIGHT_INFO));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(routeFrom));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(arrivalDate));
        Assert.assertTrue(flightConfirmation.returnInfo.getText().contains(ARRIVAL_FLIGHT_INFO));
        Assert.assertTrue(flightConfirmation.passengersInfo.getText().contains(Integer.toString(PASSENGERS)));
        billedFullName = CARD_OWNER_FIRST_NAME + " " + CARD_OWNER_MIDLE_NAME + " " + CARD_OWNER_LAST_NAME;
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(billedFullName));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_ADDRESS));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_CITY));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_STATE));
        Assert.assertTrue(flightConfirmation.billedInfo.getText().contains(BILLING_ZIP));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_ADDRESS));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_CITY));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_STATE));
        Assert.assertTrue(flightConfirmation.deliveryInfo.getText().contains(DELIVERY_ZIP));
        Assert.assertTrue(flightConfirmation.totalPrice.getText().contains(Integer.toString(totalPriceCheck)));
        flightConfirmation.clickHomeButton();

    }
}