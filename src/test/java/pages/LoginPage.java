package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement userPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(), Epic sadface: Password is required')]")
    public WebElement errorMessage;
}
