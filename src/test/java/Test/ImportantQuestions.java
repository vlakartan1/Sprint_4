package Test;

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
import pageObject.Constants;
import pageObject.HomePageScooter;

@RunWith(Parameterized.class)
public class ImportantQuestions {
    private WebDriver driver;
    private final String question;
    private final String answer;
    private final String result;

    public ImportantQuestions(String question, String result, String answer) {
        this.question = question;
        this.result = result;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswersToQuestions() {
        Constants constant = new Constants();
        return new Object[][]{
                {constant.questionPriceAndHowToPay, constant.priceAndPaymentTerms, constant.answerPriceAndHowToPay},
                {constant.questionSeveraScooters, constant.severaScooters, constant.answerSeveraScooters},
                {constant.questionRentalTimeCalculation, constant.rentalTimeCalculation, constant.answerRentalTimeCalculation},
                {constant.questionOrderToday, constant.orderToday, constant.answerOrderToday},
                {constant.questionExtendOrReturnEarlier, constant.extendOrReturnEarlier, constant.answerExtendOrReturnEarlier},
                {constant.questionScooterCharger, constant.scooterCharger, constant.answerScooterCharger},
                {constant.questionCancelTheOrder, constant.cancelTheOrder, constant.answerCancelTheOrder},
                {constant.questionBringForMKAD, constant.bringForMKAD, constant.answerBringForMKAD}
        };
    }

    @Test
    public void checkTheListWithQuestions() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.waitingForLoadinPage();//загрузка страницы
        homePageScooter.acceptCookies();//принятие куки
        homePageScooter.importantQuestions();//скрол до Вопросы о важном
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
