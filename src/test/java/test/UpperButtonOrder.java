package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.OrderPage;

@RunWith(Parameterized.class)
public class UpperButtonOrder {
    private static final String NAME_ONE = "Андрей";
    private static final String LAST_NAME_ONE = "Иванов";
    private static final String ADRESS_ONE = "Москва, ул.Новослободская, д.15, кв.3";
    private static final String METRO_ONE = "Черкизовская";
    private static final String PHONE_ONE = "+79220227222";
    private static final String NAME_TWO = "Иван";
    private static final String LAST_NAME_TWO = "Сидоров";
    private static final String ADRESS_TWO = "Балашиха, ул.Флерова, д.77, кв.53";
    private static final String METRO_TWO = "Новогиреево";
    private static final String PHONE_TWO = "+79183227183";
    private static final String DATE = "05.11.2023";
    private static final String COMMENT = "Позвонить за час";
    private static final String TEXT_ORDER_IS_PROCESSED = "Заказ оформлен";

    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;

    public UpperButtonOrder(String name, String lastName, String address, String metro, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getSecondDataSet() {
        return new Object[][]{
                {NAME_TWO, LAST_NAME_TWO, ADRESS_TWO, METRO_TWO, PHONE_TWO},
                {NAME_ONE, LAST_NAME_ONE, ADRESS_ONE, METRO_ONE, PHONE_ONE}
        };
    }

    @Test
    public void registerAndOrderAScooter() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setUpperOrderButton();
        orderPage.fillInTheForm(name, lastName, address, metro, phone);
        String result = orderPage.rentalForm(DATE, orderPage.fourDays, orderPage.blackPearl, COMMENT);
        Assert.assertTrue("Не получилось оформить заказ", result.startsWith(TEXT_ORDER_IS_PROCESSED));
    }

    @Before
    public void setup() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

}
