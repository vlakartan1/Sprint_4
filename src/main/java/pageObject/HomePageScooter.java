package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс главной страницы
public class HomePageScooter {
    private final WebDriver driver;
    private WebElement element;
    private final Constants constant = new Constants();
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Метод Принять куки на главной странице
    public void acceptCookies() {
        By acceptCookies = By.id(constant.acceptCookies);
        driver.findElement(acceptCookies).click();
    }

    //Метод Найти и прокрутить до раздела «Вопросы о важном»
    public void importantQuestions() {
        element = driver.findElement(By.xpath(constant.importantQuestions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Ожидание загрузки гл.страницы
    public void waitingForLoadinPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(constant.pageTitle)));
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
