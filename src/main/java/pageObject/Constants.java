package pageObject;

public class Constants {
    public final String acceptCookies = "rcc-confirm-button";//принять куки
    public final String pageTitle = "Header_LogoScooter__3lsAR";//заголовок страницы
    public final String homePageTitle = ".//a[@class='Header_LogoScooter__3lsAR']";//заголовок главной страницы
    public final String firstOrderButton = ".//div[1]/div[2]/button[1]"; //первая кнопка Заказать
    public final String secondOrderButton = ".//div[4]/div[2]/div[5]/button"; //вторая кнопка Заказать
    public final String importantQuestions = ".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']";//раздел Вопросы о важном
    public final String questionPriceAndHowToPay = ".//div[text()='Сколько это стоит? И как оплатить?']";//Вопрос Сколько это стоит? И как оплатить?
    public final String answerPriceAndHowToPay = ".//p[contains(text(),'наличными или картой')]";//Ответ Сколько это стоит? И как оплатить?
    public final String priceAndPaymentTerms = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";//ответ Сколько это стоит? И как оплатить?
    public final String questionSeveraScooters = ".//div[contains(text(),'Хочу сразу несколько')]";//Вопрос Хочу сразу несколько самокатов! Так можно?
    public final String answerSeveraScooters = ".//p[contains(text(),'один заказ — один самокат')]";//ответ Хочу сразу несколько самокатов! Так можно?
    public final String severaScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public final String questionRentalTimeCalculation = ".//div[text()='Как рассчитывается время аренды?']";//Вопрос Как рассчитывается время аренды?
    public final String answerRentalTimeCalculation = ".//p[contains(text(),'Отсчёт времени аренды начинается с момента')]";//Ответ Как рассчитывается время аренды?
    public final String rentalTimeCalculation = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final String questionOrderToday = ".//div[text()='Можно ли заказать самокат прямо на сегодня?']";//Вопрос Можно ли заказать самокат прямо на сегодня?
    public final String answerOrderToday = ".//p[contains(text(),'Только начиная с завтрашнего дня.')]";//Ответ Можно ли заказать самокат прямо на сегодня?
    public final String orderToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final String questionExtendOrReturnEarlier = ".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']";//Вопрос Можно ли продлить заказ или вернуть самокат раньше?
    public final String answerExtendOrReturnEarlier = ".//p[contains(text(),'Пока что нет! Но если что-то срочное')]";//Ответ Можно ли продлить заказ или вернуть самокат раньше?
    public final String extendOrReturnEarlier = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final String questionScooterCharger = ".//div[text()='Вы привозите зарядку вместе с самокатом?']";//Вопрос Вы привозите зарядку вместе с самокатом?
    public final String answerScooterCharger = ".//p[contains(text(),'Самокат приезжает к вам с полной зарядкой.')]";//Ответ Вы привозите зарядку вместе с самокатом?
    public final String scooterCharger = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final String questionCancelTheOrder = ".//div[text()='Можно ли отменить заказ?']";//Вопрос Можно ли отменить заказ?
    public final String answerCancelTheOrder = ".//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет,')]";//Ответ Можно ли отменить заказ?
    public final String cancelTheOrder = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public final String questionBringForMKAD = ".//div[text()='Я жизу за МКАДом, привезёте?']";//Вопрос Я жизу за МКАДом, привезёте?
    public final String answerBringForMKAD = ".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']";//Ответ Я жизу за МКАДом, привезёте?
    public final String bringForMKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    /*
    Локаторы для формы заказа
     */

    public final String enterName = ".//div/div[2]/div[2]/div[1]/input";//локатор для внесения Имени
    public final String enterlastName = ".//div/div[2]/div[2]/div[2]/input";//лакатор для внесения фамилии
    public final String enterAdress = ".//div/div[2]/div[2]/div[3]/input";//лакатор для внесения адреса
    public final String enterMetro = ".//input[@class='select-search__input']";//локатор для внесения Метро
    public final String enterPhone = ".//div/div[2]/div[2]/div[5]/input";//локатор для внесения телефона
    public final String further = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";//локатор кнопки Далее
    public final String name1 = "Андрей";
    public final String lastName1 = "Иванов";
    public final String adress1 = "Москва, ул.Новослободская, д.15, кв.3";
    public final String metro1 = "Черкизовская";
    public final String phone1 = "+79220227222";
    public final String name2 = "Иван";
    public final String lastName2 = "Сидоров";
    public final String adress2 = "Балашиха, ул.Флерова, д.77, кв.53";
    public final String metro2 = "Новогиреево";
    public final String phone2 = "+79183227183";




    /*
    Локаторы после кнопки далее
     */
    public final String aboutRent = ".//div[@class='Order_Header__BZXOb']";//локатор страницы Про аренду
    public final String whenToBringIt = ".//input[@placeholder='* Когда привезти самокат']";//локатор  выбора даты привоза самоката
    public final String date = "05.11.2023";
    public final String rentalPeriod = ".//div[@class='Dropdown-control']";//локатор выбора поля срока аренды
    public final String fourDays = ".//div[text()='четверо суток']";//выбор четверо суток
    public final String threeDays = ".//div[text()='трое суток']";//выбор трое суток
    public final String blackPearl = ".//input[@id='black']";//выбор черный жемчуг цвет самоката
    public final String grey = ".//input[@id='grey']";//выбор серый цвет самоката
    public final String commentLocator = ".//input[@placeholder='Комментарий для курьера']";//локатор поля комментарий для курьера
    public final String comment = "Позвонить за час";
    public final String order = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";//локатор Заказать
    public final String validePurchase = ".//div[5]/div[2]/button[2]";//Подтвердить заказ
    public final String orderIsProcessed = ".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']";//Локатор Заказ оформлен
    public final String textOrderIsProcessed = "Заказ оформлен";
    public final String orderStatus = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']";//Локатор Посмотреть статус



}
