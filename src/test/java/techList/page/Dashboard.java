package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class Dashboard extends BasePage {

    @FindBy(xpath = "//a[text() ='Контент-провайдеры']")
    private WebElement clickContentProvider;

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    //Клик по пункту меню Контент-провайдеры
    public ContentProvider clickContProv() {
        clickContentProvider.click();
        return new ContentProvider(driver);
    }
}


