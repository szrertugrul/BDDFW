package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.MessengerPage;
import utils.BasePage;

public class MessengerPageSD {
    // Create an object of messengerPage Class so we will be able to call the actions from MessengerPage Class
    private MessengerPage messengerPage = new MessengerPage();
    // !!!! we have to create definitions according to the highlighted steps in the Messenger.feature file !!!!
    @Given("^I am on the messenger page$") // should be the same with the highlighted statement in the feature file
    public void setMessengerPage(){
        messengerPage.clickOnMessengerLink(); // call the method from MessengerPage class
        //Verify the link:
        Assert.assertEquals(BasePage.get().getCurrentUrl(), "https://www.messenger.com/"); //org.junit.Assert
    }
    @When("^I enter (.+) into (username|password) field on the messenger page$")
    public void enterDataIntoTextField(String value, String textField){
        switch (textField){ //switch case to select either username or password from (username|password) above
            case"username":
                messengerPage.enterEmail(value);
            case"password":
                messengerPage.enterPassword(value);
        }
    }
    @And("^I click on login button on messenger page$")
    public void clickOnSignInButton(){
        messengerPage.clickOnSignin();
    }
    @Then("^I verify invalid login message on sign in page$")
    public void verifySignInErrorMessage(){
        Assert.assertEquals(messengerPage.getErrorMessage(), "Please re-enter your password");
    }
}
