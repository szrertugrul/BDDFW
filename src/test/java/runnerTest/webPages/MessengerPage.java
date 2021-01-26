package runnerTest.webPages;

import org.openqa.selenium.By;

public class MessengerPage extends ElementUtil{ // we don't use constructor since we use inheritance
    // According to POM we define locators and actions in Page class then we will call them
    // Locators:
    private By messengerLink = By.linkText("Messenger");
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.id("loginbutton");
    private By errorMessage = By. xpath("//div[contains(text(), 'your password')]");
    //Actions:
    public void clickOnMessengerLink(){
        clickOn(messengerLink);
    }
    public void enterEmail (String email){
        sendValue(emailField, email);
    }
    public void enterPassword(String password){
        sendValue(passwordField, password);
        scrollByPixel("0","1000");
    }
    public void clickOnSignin(){
        clickOn(signInButton);
    }
    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }
}
