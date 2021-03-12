package step_definitions;

import pages.RegisterPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RegisterStepDef {

    RegisterPage registerPage = new RegisterPage();


    @Given("the user is on the register page")
    public void the_user_is_on_the_register_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("user should enter {string}, {string} and {string}")
    public void user_should_enter_and(String mobileNumber, String email, String password) {
        registerPage.phoneInput.sendKeys(mobileNumber);
        registerPage.emailInput.sendKeys(email);
        registerPage.passwordInput.sendKeys(password);

    }

    @When("the user should be able to click to updates buttons and Terms & Conditions")
    public void theUserShouldBeAbleToClickToUpdatesButtonsAndTermsConditions() {
        BrowserUtils.clickWithJS(registerPage.updates1);
        registerPage.updates2.click();
        registerPage.terms.click();
        registerPage.nextBtn.click();


    }

    @Then("the user should see {string} messages")
    public void theUserShouldSeeMessages(String expectedText) {

        if (expectedText.contains("email")) {
            BrowserUtils.scrollToElement(registerPage.emailText);
            String actualText = registerPage.emailText.getText();
            assertThat(expectedText, is(actualText));

        } else if (expectedText.contains("number")) {

            BrowserUtils.scrollToElement(registerPage.phoneText);
            String actualText = registerPage.phoneText.getText();
            assertThat(expectedText, is(actualText));


        } else if (expectedText.contains("password")) {
            BrowserUtils.scrollToElement(registerPage.passwordText);
            String actualText = registerPage.passwordText.getText();
            assertThat(expectedText, is(actualText));

        }

    }

}

