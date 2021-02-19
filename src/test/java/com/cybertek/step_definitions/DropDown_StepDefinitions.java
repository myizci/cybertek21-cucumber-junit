package com.cybertek.step_definitions;

import com.cybertek.pages.DropDownPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown_StepDefinitions {

DropDownPage dropDownPage = new DropDownPage();
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        String url = ConfigurationReader.getProperty("dropDownUrl");
        Driver.getDriver().get(url);
    }

    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List<String > months) {

        Select select = new Select(dropDownPage.selectMonth);
        List<WebElement> list = select.getOptions();

//List<String> monthsAsString = new ArrayList<>();
//
//        for(WebElement each: list){
//            //Assert.assertTrue(months.contains(each.getText()));
//            monthsAsString.add(each.getText());
//        }

        Assert.assertTrue(months.equals( BrowserUtils.getElementsText(list)));

    }
}

