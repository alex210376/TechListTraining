package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "login-username")
    private WebElement userNameInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement clickLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Открывает страницу
    public LoginPage goToHome(String baseUrl){
        driver.get(baseUrl + "/index.php");
        return this;
    }

    //Ввод имени пользователя
    public LoginPage fillUserName(String userName){
        fillField(userNameInput, userName);
        return this;
    }

    //Ввод пароля пользователя
    public LoginPage fillPassword(String password){
        fillField(passwordInput, password);
        return this;
    }

    //Клик по кнопке Login
    public Dashboard clickLoginButton() {
        clickLogin.click();
        return new Dashboard(driver);
    }

}
