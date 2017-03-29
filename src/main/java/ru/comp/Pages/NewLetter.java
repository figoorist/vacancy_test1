package ru.comp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Viktor on 29.03.2017.
 */
public class NewLetter extends Page {
    public NewLetter(WebDriver driver) {
        super(driver);
    }
    public WebElement getAttachFileButton(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".js-input-file")));
    }

    public WebElement getLogoutButton(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("#PH_logoutLink")));
    }

    public WebElement getDestinationEmailField(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("textarea.js-input:nth-child(6)")));

    }

    public WebElement getSubjectField(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".compose-head__row_nohr > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")));
    }

    public WebElement getSendButton(){
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("div.b-toolbar__item_:nth-child(1)")));
    }
}
