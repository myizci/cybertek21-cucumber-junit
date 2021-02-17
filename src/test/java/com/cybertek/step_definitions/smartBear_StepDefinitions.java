package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class smartBear_StepDefinitions {
    SmartBearPage smartBearPage = new SmartBearPage();

    @Given("User logs in to smartBear website")
    public void user_logs_in_to_smart_bear_website() {
        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

        smartBearPage.usernameInput.sendKeys("Tester");
        smartBearPage.passpordInput.sendKeys("test");
        smartBearPage.submitButton.click();
    }


    @Given("User navigates to order page")
    public void user_navigates_to_order_page() {
        smartBearPage.orderPageLink.click();
    }

    @Given("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String dropDownChoice) {
        Select select = new Select(smartBearPage.productDropDown);
        select.selectByVisibleText(dropDownChoice);
    }

    @Given("User enter {string} to quantity")
    public void user_enter_to_quantity(String quantity) {
        smartBearPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        smartBearPage.quantityBox.sendKeys(quantity);
    }

    @Given("User enters {string} to customer name")
    public void user_enters_to_customer_name(String customerName) {
        smartBearPage.customerNameBox.sendKeys(customerName);
    }

    @Given("User enters {string} to street")
    public void user_enters_to_street(String street) {
        smartBearPage.streetBox.sendKeys(street);
    }

    @Given("User enters {string} to city")
    public void user_enters_to_city(String city) {
        smartBearPage.cityBox.sendKeys(city);
    }

    @Given("User enters {string} to state")
    public void user_enters_to_state(String state) {
        smartBearPage.stateBox.sendKeys(state);
    }

    @Given("User enters {string} to zip")
    public void user_enters_to_zip(String zip) {
        smartBearPage.zipBox.sendKeys(zip);
    }

    @Given("User enters {string} as card type")
    public void user_enters_as_card_type(String cardType) {

        switch (cardType) {

            case "Visa":
                smartBearPage.visaButton.click();
                break;

            case "MasterCard":
                smartBearPage.masterButton.click();
                break;

            default:
                smartBearPage.americanExpressButton.click();

        }
    }

    @Given("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {
        smartBearPage.cardNumberBox.sendKeys(cardNumber);

    }

    @Given("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String date) {
        smartBearPage.expirationDateBox.sendKeys(date);
    }

    @Given("User clicks process button")
    public void user_clicks_process_button() {
        smartBearPage.processButton.click();
        smartBearPage.viewAllOrders.click();
    }


    @Then("User verifies {string} is in the list")
    public void userVerifiesIsInTheList(String expectedName) {


        Assert.assertTrue(smartBearPage.name.getText().equals(expectedName));
    }
}
