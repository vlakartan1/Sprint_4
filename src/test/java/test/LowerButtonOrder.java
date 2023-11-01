package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.OrderPage;

public class LowerButtonOrder {
    private static final String TEXT_NAME_FORM = "Для кого самокат";

    private WebDriver driver;


    @Test
    public void registeAndOrderAScooter() {
        OrderPage orderPage = new OrderPage(driver);
        String result = orderPage.setLowerOrderButton();//Нажать вторую кнопку Заказать
        System.out.println(result);
        Assert.assertTrue("Не открылась форма заказа", result.startsWith(TEXT_NAME_FORM));
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
