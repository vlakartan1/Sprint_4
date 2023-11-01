package test;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePageScooter;

@RunWith(Parameterized.class)
public class GetListOfQuestionsAboutImportant {
    private static WebDriver driver;
    private static final String PRICE_AND_PAYMENT_TERMS = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";//ответ Сколько это стоит? И как оплатить?
    private static final String SEVERA_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String RENTAL_TIME_CALCULATION = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ORDER_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXTEND_OR_RETURN_EARLIER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String SCOOTER_CHARGER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String CANCEL_THE_ORDER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String BRING_FOR_MKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final String question;
    private final String answer;
    private final String result;

    public GetListOfQuestionsAboutImportant(String question, String result, String answer) {
        this.question = question;
        this.result = result;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswersToQuestions() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        return new Object[][]{
                {homePageScooter.questionPriceAndHowToPay, PRICE_AND_PAYMENT_TERMS, homePageScooter.answerPriceAndHowToPay},
                {homePageScooter.questionSeveraScooters, SEVERA_SCOOTERS, homePageScooter.answerSeveraScooters},
                {homePageScooter.questionRentalTimeCalculation, RENTAL_TIME_CALCULATION, homePageScooter.answerRentalTimeCalculation},
                {homePageScooter.questionOrderToday, ORDER_TODAY, homePageScooter.answerOrderToday},
                {homePageScooter.questionExtendOrReturnEarlier, EXTEND_OR_RETURN_EARLIER, homePageScooter.answerExtendOrReturnEarlier},
                {homePageScooter.questionScooterCharger, SCOOTER_CHARGER, homePageScooter.answerScooterCharger},
                {homePageScooter.questionCancelTheOrder, CANCEL_THE_ORDER, homePageScooter.answerCancelTheOrder},
                {homePageScooter.questionBringForMKAD, BRING_FOR_MKAD, homePageScooter.answerBringForMKAD}
        };
    }

    @Test
    public void checkTheListWithQuestions() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.loadPageOnQuestions();//загрузка страницы, принятие куки и скрол до вопросов
        String textAnswer = homePageScooter.clickOnQuestion(question, answer);//кликнуть на вопросе и получить ответ
        MatcherAssert.assertThat("Ответ не совпадает", textAnswer, Matchers.is(result));
    }

    @Before
    public void pageLaunchSettings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }
}
