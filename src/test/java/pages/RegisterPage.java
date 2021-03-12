package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(css = "#field-Member_CLI")
    public WebElement phoneInput;

    @FindBy(css = "#field-Member_Email")
    public WebElement emailInput;

    @FindBy(css = "#field-MemberPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement updates1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement updates2;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement terms;

    @FindBy(css = "#labyrinth_UserDetails_next")
    public WebElement nextBtn;

    @FindBy(xpath = "//span[contains(text(),'Email address is invalid')]")
    public WebElement emailText;

    @FindBy(xpath = "//span[contains(text(),'number ')]")
    public WebElement phoneText;

    @FindBy(xpath = "//span[contains(text(),'The password does not meet the correct format.')]")
    public WebElement passwordText;



}
