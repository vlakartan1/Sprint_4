package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OrderPage {
    public final String acceptCookies = "rcc-confirm-button";//принять куки
    public final String pageTitle = "Header_LogoScooter__3lsAR";//заголовок страницы
    public final String homePageTitle = ".//a[@class='Header_LogoScooter__3lsAR']";//заголовок главной страницы
    public final String firstOrderButton = ".//div[1]/div[2]/button[1]"; //первая кнопка Заказать
    public final String secondOrderButton = ".//div[4]/div[2]/div[5]/button"; //вторая кнопка Заказать
    public final String aboutRent = ".//div[@class='Order_Header__BZXOb']";//локатор страницы Про аренду
    public final String whenToBringIt = ".//input[@placeholder='* Когда привезти самокат']";//локатор  выбора даты привоза самоката
    public final String rentalPeriod = ".//div[@class='Dropdown-control']";//локатор выбора поля срока аренды
    public final String fourDays = ".//div[text()='четверо суток']";//выбор четверо суток
    public final String threeDays = ".//div[text()='трое суток']";//выбор трое суток
    public final String blackPearl = ".//input[@id='black']";//выбор черный жемчуг цвет самоката
    public final String grey = ".//input[@id='grey']";//выбор серый цвет самоката
    public final String commentLocator = ".//input[@placeholder='Комментарий для курьера']";//локатор поля комментарий для курьера
    public final String order = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";//локатор Заказать
    public final String validePurchase = ".//div[5]/div[2]/button[2]";//Подтвердить заказ
    public final String orderIsProcessed = ".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']";//Локатор Заказ оформлен
    public final String orderStatus = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']";//Локатор Посмотреть статус
    public final String enterName = ".//div/div[2]/div[2]/div[1]/input";//локатор для внесения Имени
    public final String enterlastName = ".//div/div[2]/div[2]/div[2]/input";//лакатор для внесения фамилии
    public final String enterAdress = ".//div/div[2]/div[2]/div[3]/input";//лакатор для внесения адреса
    public final String enterMetro = ".//input[@class='select-search__input']";//локатор для внесения Метро
    public final String enterPhone = ".//div/div[2]/div[2]/div[5]/input";//локатор для внесения телефона
    public final String further = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";//локатор кнопки Далее
    public final String whoIsTheScooterFor = ".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']" ;//форма заказа Для кого самокат
    private final WebDriver driver;
    private WebElement element;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод возврата на главную страницу Яндекс Самокат
    public void returnToHomePage() {
        driver.findElement(By.className(pageTitle)).click();
    }

    //Метод первой кнопки Заказать
    public void setFirstOrderButton() {
        loadingHomePage();
        driver.findElement(By.xpath(firstOrderButton)).click();
    }

    //Загрузка страницы и принятие куки
    public void loadingHomePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(pageTitle)));
        driver.findElement(By.id(acceptCookies)).click();//Принять куки
    }

    //Проскролить до Второй кнопки Заказать, кликнуть, получить текст формы
    public String setSecondOrderButton() {
        loadingHomePage();
        element = driver.findElement(By.xpath(secondOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);//проскролить до второй кнопки
        driver.findElement(By.xpath(secondOrderButton)).click();//кликнуть на второй кнопке заказа
        wait(whoIsTheScooterFor);
        return driver.findElement(By.xpath(whoIsTheScooterFor)).getText();//получить текст Для кого самокат
    }

    //ожидание прогрузки
    public void wait(String lokator) {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lokator)));
    }

    //Метод внести Имя, Фамилию, Адрес, телефон и нажать далее
    public void fillInTheForm(String name, String lastName, String adress, String metro, String phone) {
        driver.findElement(By.xpath(enterName)).sendKeys(name);//внести имя
        driver.findElement(By.xpath(enterlastName)).sendKeys(lastName);//внести фамилию
        driver.findElement(By.xpath(enterAdress)).sendKeys(adress);//внести адрес
        driver.findElement(By.xpath(enterMetro)).sendKeys(metro + ARROW_DOWN + ENTER);//внести станцию метро
        driver.findElement(By.xpath(enterPhone)).sendKeys(phone);//внести номер телефона
        driver.findElement(By.xpath(further)).click();//кликнуть на кнопку далее
        wait(aboutRent);
    }

    //Метод заполнения формы про аренду
    public String rentalForm(String date, String daySelection, String color, String comment) {
        driver.findElement(By.xpath(whenToBringIt)).sendKeys(date + ENTER);//внести дату
        driver.findElement(By.xpath(rentalPeriod)).click();//кликнуть на срок аренды
        driver.findElement(By.xpath(daySelection)).click();//кликнуть четверо суток
        driver.findElement(By.xpath(color)).click();//нажать чекбокс цвет самоката черный жемчуг
        driver.findElement(By.xpath(commentLocator)).sendKeys(comment);//внести запись в поле Комментарий для клиента
        driver.findElement(By.xpath(order)).click();//нажать на кнопку заказать
        wait(validePurchase);
        driver.findElement(By.xpath(validePurchase)).click();//Подтвердить заказ
        wait(orderIsProcessed);
        return driver.findElement(By.xpath(orderIsProcessed)).getText();//получить текст Заказ оформлен
    }

    //Метод для второго набора
    public void makeASecondOrder() {
        driver.findElement(By.xpath(orderStatus)).click();//нажать на Узнать статус Заказа
        wait(homePageTitle);
        driver.findElement(By.className(pageTitle)).click();//Перейти на главную страницу
    }
}
