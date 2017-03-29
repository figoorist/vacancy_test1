package ru.comp;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.comp.Pages.HomePage;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import ru.comp.Pages.Incoming;
import ru.comp.Pages.NewLetter;

/**
 * Created by Viktor on 19.03.2017.
 */
public class AppTest {
    /** Свойство - драйвер браузера*/
    private WebDriver driver;
    /** Свойство - объект стартовой страницы*/
    private HomePage homepage;
    private Incoming incoming;
    NewLetter newLetter;

    /**
     * Метод инициализации тестового стенда, браузер Mozilla Firefox 46
     * @throws InterruptedException
     */
    @BeforeTest
    public void init() throws InterruptedException {
        driver = new FirefoxDriver(); //создаём драйвер Firefox
        //используем фабрику PageFactory для создания объекта страницы
        homepage = PageFactory.initElements(driver,HomePage.class);
        //используем фабрику PageFactory для создания объекта страницы
        incoming = PageFactory.initElements(driver,Incoming.class);
        //используем фабрику PageFactory для создания объекта страницы
        newLetter = PageFactory.initElements(driver,NewLetter.class);
    }

    /**
     * Действия по окончании, закрытие браузера
     */
    @AfterTest
    public void closePage() throws InterruptedException {
        newLetter.getLogoutButton().click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://mail.ru");
        try{
            homepage.getLoginInputField().sendKeys("luisfigo_10");
        }
        catch(NoSuchElementException e){
            System.out.println("Не найдено поле ввода логина");
        }
        try{
            homepage.getPasswordInputField().sendKeys("realmadrid");
        }
        catch(NoSuchElementException e){
            System.out.println("Не найдено поле ввода пароля");
        }
        try{
            homepage.submitButton.click();
        }
        catch (NoSuchElementException e){
            System.out.println("Не найдена кнопка");
        }

        incoming.getWriteLetterButton().click();

        // newLetter.getAttachFileButton().click();

        Thread.sleep(2000);
    }
}
