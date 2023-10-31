package Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObject.Constants;
import pageObject.HomePageScooter;
import pageObject.OrderPage;

public class OrderFormTwo {

    private WebDriver driver;

    @Test
    public void registeAndOrderAScooter() {
        Constants constant = new Constants();
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitingForLoadinPage();//загрузка страницы
        homePageScooter.acceptCookies();//принятие куки
        OrderPage orderPage = new OrderPage(driver);
        orderPage.scrolSecondOrderButton();//проскролить
        orderPage.setSecondOrderButton();//Нажать вторую кнопку Заказать
        orderPage.fillInTheForm(constant.name1, constant.lastName1, constant.adress1, constant.metro1, constant.phone1);//внести данные и нажать далее
        orderPage.rentalForm(constant.date, constant.threeDays, constant.grey, constant.comment);//внести данные по аренде и подтвердить заказ
        String result = orderPage.orderIsProcessed();
        Assert.assertTrue("Не получилось оформить заказ", result.startsWith(constant.textOrderIsProcessed));
        //Второй заказ
        orderPage.secondSet();//Нажать Проверить статус, перейти на гловную страницу
        orderPage.scrolSecondOrderButton();//проскролить
        orderPage.setSecondOrderButton();//Нажать вторую кнопку Заказать
        orderPage.fillInTheForm(constant.name2, constant.lastName2, constant.adress2, constant.metro2, constant.phone2);//внести данные и нажать далее
        orderPage.rentalForm(constant.date, constant.fourDays, constant.blackPearl, constant.comment);//внести данные по аренде и подтвердить заказ
        result = orderPage.orderIsProcessed();
        Assert.assertTrue("Не получилось оформить заказ", result.startsWith(constant.textOrderIsProcessed));
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
