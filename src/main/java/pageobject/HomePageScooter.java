package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс главной страницы
public class HomePageScooter {
    public final String acceptCookies = "rcc-confirm-button";//принять куки
    public final String pageTitle = "Header_LogoScooter__3lsAR";//заголовок страницы
    public final String importantQuestions = ".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']";//раздел Вопросы о важном
    public final String questionPriceAndHowToPay = ".//div[text()='Сколько это стоит? И как оплатить?']";//Вопрос Сколько это стоит? И как оплатить?
    public final String answerPriceAndHowToPay = ".//p[contains(text(),'наличными или картой')]";//Ответ Сколько это стоит? И как оплатить?
    public final String questionSeveraScooters = ".//div[contains(text(),'Хочу сразу несколько')]";//Вопрос Хочу сразу несколько самокатов! Так можно?
    public final String answerSeveraScooters = ".//p[contains(text(),'один заказ — один самокат')]";//ответ Хочу сразу несколько самокатов! Так можно?
    public final String questionRentalTimeCalculation = ".//div[text()='Как рассчитывается время аренды?']";//Вопрос Как рассчитывается время аренды?
    public final String answerRentalTimeCalculation = ".//p[contains(text(),'Отсчёт времени аренды начинается с момента')]";//Ответ Как рассчитывается время аренды?
    public final String questionOrderToday = ".//div[text()='Можно ли заказать самокат прямо на сегодня?']";//Вопрос Можно ли заказать самокат прямо на сегодня?
    public final String answerOrderToday = ".//p[contains(text(),'Только начиная с завтрашнего дня.')]";//Ответ Можно ли заказать самокат прямо на сегодня?
    public final String questionExtendOrReturnEarlier = ".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']";//Вопрос Можно ли продлить заказ или вернуть самокат раньше?
    public final String answerExtendOrReturnEarlier = ".//p[contains(text(),'Пока что нет! Но если что-то срочное')]";//Ответ Можно ли продлить заказ или вернуть самокат раньше?
    public final String questionScooterCharger = ".//div[text()='Вы привозите зарядку вместе с самокатом?']";//Вопрос Вы привозите зарядку вместе с самокатом?
    public final String answerScooterCharger = ".//p[contains(text(),'Самокат приезжает к вам с полной зарядкой.')]";//Ответ Вы привозите зарядку вместе с самокатом?
    public final String questionCancelTheOrder = ".//div[text()='Можно ли отменить заказ?']";//Вопрос Можно ли отменить заказ?
    public final String answerCancelTheOrder = ".//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет,')]";//Ответ Можно ли отменить заказ?
    public final String questionBringForMKAD = ".//div[text()='Я жизу за МКАДом, привезёте?']";//Вопрос Я жизу за МКАДом, привезёте?
    public final String answerBringForMKAD = ".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']";//Ответ Я жизу за МКАДом, привезёте?

    private final WebDriver driver;
    private WebElement element;
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }



    //Ожидание загрузки гл.страницы, принятие куки, скрол до вопросов
    public void loadPageOnQuestions() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(pageTitle)));
        driver.findElement(By.id(acceptCookies)).click();//Принять куки
        element = driver.findElement(By.xpath(importantQuestions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//проскролить до вопросов
    }

    //ожидание прогрузки ответа
    public void waitAnswer(String answerLokal) {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerLokal)));
    }

    //Метод нажать на вопрос и получить ответ
    public String clickOnQuestion(String questionLokator, String answerLokator) {
        driver.findElement(By.xpath(questionLokator)).click();
        waitAnswer(answerLokator);
        return driver.findElement(By.xpath(answerLokator)).getText();
    }
}
