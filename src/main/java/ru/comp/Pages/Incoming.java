package ru.comp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Viktor on 19.03.2017.
 */
public class Incoming extends Page{
    /**
     * Констректор
     * @param driver
     */
    public Incoming(WebDriver driver) {
        super(driver);
    }
    public WebElement getWriteLetterButton() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("a.b-toolbar__btn > span:nth-child(2)")));
    }
}
