package ru.comp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Viktor on 19.03.2017.
 * Класс главной страницы сайта, унаследованный от абстрактного класса Page
 */
public class HomePage extends Page {
    /**
     * Конструктор
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получить WebElement - поле для ввода логина
     * @return
     */
    public WebElement getLoginInputField(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("mailbox__login")));
    }

    /**
     * Получить WebElement - поле для ввода пароля
     * @return
     */
    public WebElement getPasswordInputField() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("mailbox__password")));
    }

    /** public свойство - кнопка входа */
    @FindBy(how = How.ID, using = "mailbox__auth__button")
    public WebElement submitButton;
}
