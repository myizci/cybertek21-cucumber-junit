package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage extends BasePage{



    @FindBy(id = "month")
    public WebElement selectMonth;
}
