package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.HomePageScooter;
import pageobject.OrderPage;

public class SecondButtonOrder {
    private static final String nameOne = "Андрей";
    private static final String lastNameOne = "Иванов";
    private static final String adressOne = "Москва, ул.Новослободская, д.15, кв.3";
    private static final String metroOne = "Черкизовская";
    private static final String phoneOne = "+79220227222";
    private static final String date = "05.11.2023";
    private static final String comment = "Позвонить за час";
    private static final String textOrderIsProcessed = "Заказ оформлен";

    private WebDriver driver;


    @Test
    public void registeAndOrderAScooter() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setSecondOrderButton();//Нажать вторую кнопку Заказать
        orderPage.fillInTheForm(nameOne, lastNameOne, adressOne, metroOne, phoneOne);//внести данные и нажать далее
        String result = orderPage.rentalForm(date, orderPage.threeDays, orderPage.grey, comment);//внести данные по аренде и подтвердить заказ
        Assert.assertTrue("Не получилось оформить заказ", result.startsWith(textOrderIsProcessed));
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\bin\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        //driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

}
