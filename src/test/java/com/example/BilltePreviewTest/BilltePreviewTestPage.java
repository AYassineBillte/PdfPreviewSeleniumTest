package com.example.BilltePreviewTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BilltePreviewTestPage {
    /*@FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    @FindBy(xpath = "//div[contains(@class, 'menu-main__item') and text() = 'Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test=menu-main-icon-search]")
    public WebElement searchButton;*/

    @FindBy(css = "#loginBtn")
    public WebElement loginBtn;

    @FindBy(css = "#username")
    public WebElement usernameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(css = "#login-button")
    public WebElement confirmLogin;

    @FindBy(css = "#updatesModal > div.modal-card > div > footer > button")
    public WebElement closePopup;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/section/div/div[2]/div/div[3]/div[1]/div/div[3]/p/button")
    public WebElement start;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/section/div/div[2]/div/div[2]/div[1]/div/img")
    public WebElement template;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/section/div/div[2]/div/section[1]/p/a[1]")
    public WebElement continueBtn;

    @FindBy(css = "#cancelBtn1")
    public WebElement previewBtn;

    @FindBy(css = "#saveBtn")
    public WebElement saveBtn;


    public BilltePreviewTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
