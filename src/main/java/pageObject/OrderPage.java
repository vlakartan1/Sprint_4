package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OrderPage {
    private final WebDriver driver;
    Constants constant = new Constants();
    private WebElement element;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод возврата на главную страницу Яндекс Самокат
    public void returnToHomePage() {
        driver.findElement(By.className(constant.pageTitle)).click();
    }

    //Метод первой кнопки Заказать
    public void setFirstOrderButton() {
        driver.findElement(By.xpath(constant.firstOrderButton)).click();
    }

    //Метод Второй кнопки Заказать
    public void setSecondOrderButton() {
        driver.findElement(By.xpath(constant.secondOrderButton)).click();
    }

    //ожидание прогрузки
    public void wait(String lokator) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lokator)));
    }

    //Метод Найти и прокрутить до второй кнопки Заказать
    public void scrolSecondOrderButton() {
        element = driver.findElement(By.xpath(constant.secondOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод внести Имя, Фамилию, Адрес, телефон и нажать далее
    public void fillInTheForm(String name, String lastName, String adress, String metro, String phone) {
        driver.findElement(By.xpath(constant.enterName)).sendKeys(name);//внести имя
        driver.findElement(By.xpath(constant.enterlastName)).sendKeys(lastName);//внести фамилию
        driver.findElement(By.xpath(constant.enterAdress)).sendKeys(adress);//внести адрес
        driver.findElement(By.xpath(constant.enterMetro)).sendKeys(metro + ARROW_DOWN + ENTER);//внести станцию метро
        driver.findElement(By.xpath(constant.enterPhone)).sendKeys(phone);//внести номер телефона
        driver.findElement(By.xpath(constant.further)).click();//кликнуть на кнопку далее
        wait(constant.aboutRent);
    }

    //Метод заполнения формы про аренду
    public void rentalForm(String date, String daySelection, String color, String comment) {
        driver.findElement(By.xpath(constant.whenToBringIt)).sendKeys(date + ENTER);//внести дату
        driver.findElement(By.xpath(constant.rentalPeriod)).click();//кликнуть на срок аренды
        driver.findElement(By.xpath(daySelection)).click();//кликнуть четверо суток
        driver.findElement(By.xpath(color)).click();//нажать чекбокс цвет самоката черный жемчуг
        driver.findElement(By.xpath(constant.commentLocator)).sendKeys(comment);//внести запись в поле Комментарий для клиента
        driver.findElement(By.xpath(constant.order)).click();//нажать на кнопку заказать
        wait(constant.validePurchase);
        driver.findElement(By.xpath(constant.validePurchase)).click();
        wait(constant.orderIsProcessed);
    }

    //Метод получения текста Заказ оформлен
    public String orderIsProcessed() {
        return driver.findElement(By.xpath(constant.orderIsProcessed)).getText();
    }

    //Метод для второго набора
    public void secondSet(){
        driver.findElement(By.xpath(constant.orderStatus)).click();
        wait(constant.homePageTitle);
        driver.findElement(By.className(constant.pageTitle)).click();
    }
}
