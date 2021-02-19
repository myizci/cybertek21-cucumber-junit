package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearPage {

    public SmartBearPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
// login method where we do not have to pass username and password
    public void loginToSmartBear() {
        usernameInput.sendKeys("Tester");
        passpordInput.sendKeys("test");
        submitButton.click();
    }
// overloaded version 1
    public void loginToSmartBear(String username, String password){
        usernameInput.sendKeys(username);
        passpordInput.sendKeys(password);
        submitButton.click();
    }
    // overloaded version 2, pass data from configuration.properties
    public void loginToSmartBear_Config() {
        usernameInput.sendKeys(ConfigurationReader.getProperty("smartBearUsername"));
        passpordInput.sendKeys(ConfigurationReader.getProperty("smartBearPassword"));
        submitButton.click();

    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInput;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passpordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement submitButton;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement orderPageLink;

    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productDropDown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpressButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrders;

    @FindBy(xpath = "(//table)[2]//tr[2]/td[2]")
    public WebElement name;

}
