package ru.comp;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.comp.Pages.HomePage;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import ru.comp.Pages.Incoming;
import ru.comp.Pages.NewLetter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
    @Parameters({"filePath", "site", "login", "password", "destinationEmail"})
    public void test1(String filePath,
                      String site,
                      String login,
                      String password,
                      String destinationEmail) throws InterruptedException, AWTException {
        driver.get(site);
        try{
            homepage.getLoginInputField().sendKeys(login);
        }
        catch(NoSuchElementException e){
            System.out.println("Не найдено поле ввода логина");
        }
        try{
            homepage.getPasswordInputField().sendKeys(password);
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

        newLetter.getDestinationEmailField().sendKeys(destinationEmail);
        newLetter.getDestinationEmailField().sendKeys(" ");
        Thread.sleep(1000);
        newLetter.getSubjectField().sendKeys("Проверка связи");
        Thread.sleep(1000);
        newLetter.getAttachFileButton().click();
        Thread.sleep(1000);
        StringSelection s = new StringSelection(filePath);
        //заносим строку с путем до файла в буфер обмена
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);

        //Создаем объект класса Robot для генерациинативных событий ввода
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        newLetter.getSendButton().click();
    }
}
