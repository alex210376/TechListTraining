package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class Dashboard extends BasePage {

    @FindBy(xpath = "//a[@id='toggle-btn']")
    private WebElement menu;

    @FindBy(xpath = "//a[text() ='Контент-провайдеры']")
    private WebElement clickContentProvider;

    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement clickLogout;

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    //Клик по пиктограмме Меню
    public Dashboard clickMenu(){
        menu.click();
        return this;
    }

    //Клик по пункту меню Контент-провайдеры
    public ContentProvider clickContProv() {
        clickContentProvider.click();
        return new ContentProvider(driver);
    }


    //Клик по кнопке Logout
    public Dashboard clickLogout() {
        clickLogout.click();
        return this;
    }
    //Повторный клик по кнопке Logout
    public LoginPage clickLogoutSecond() {
        clickLogout.click();
        return new LoginPage(driver);
    }
}


