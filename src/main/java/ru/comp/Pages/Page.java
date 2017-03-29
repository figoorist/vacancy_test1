package ru.comp.Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Viktor on 18.03.2017.
 */

/** Абстрактный класс страницы веб-приложения*/
public abstract class Page {
    /** Член класса - драйвер веб-браузера*/
    protected final WebDriver driver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /** Метод получения заголовка страницы
     * @return текст заголовка страницы
     * */
    public String getTitle() {
        return driver.getTitle();
    }
}

