package ru.levelup.daria.khekalo.qa.hw6.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseWebComponent {

    protected WebDriver driver;

    public BaseWebComponent(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }





}
