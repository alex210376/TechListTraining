package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class ContentProviderAdd extends BasePage {

    @FindBy(name = "name")
    private WebElement fieldName;

    @FindBy(name = "email")
    private WebElement fieldEmail;

    @FindBy(name = "phone")
    private WebElement fieldPhone;

    @FindBy(name = "bin")
    private WebElement fieldBIN;

    @FindBy(name = "active_from")
    private WebElement fieldActiveFrom;

    @FindBy(name = "active_to")
    private WebElement fieldActiveTo;

    @FindBy(name = "comment")
    private WebElement fieldComment;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement clickSave;

    public ContentProviderAdd(WebDriver driver){
        super(driver);
        }

    //Ввод названия
    public ContentProviderAdd fillName(String name){
        fillField(fieldName, name);
        return this;
    }

    //Ввод Email
    public ContentProviderAdd fillEmail(String email){
        fillField(fieldEmail, email);
        return this;
    }

    //Ввод телефона
    public ContentProviderAdd fillPhone(String phone){
        fillField(fieldPhone, phone);
        return this;
    }

    //Ввод BIN
    public ContentProviderAdd fillBIN(String bin){
        fillField(fieldBIN, bin);
        return this;
    }

    //Ввод С даты
    public ContentProviderAdd fillDateFrom(String dateFrom){
        fillField(fieldActiveFrom, dateFrom);
        return this;
    }

    //Ввод По дату
    public ContentProviderAdd fillDateTo(String dateTo){
        fillField(fieldActiveTo, dateTo);
        return this;
    }

    //Ввод комментария
    public ContentProviderAdd fillComment(String comment){
        fillField(fieldComment, comment);
        return this;
    }

    //Клик по кнопке Сохранить
    public ContentProvider clickSaveButton() {
        clickSave.click();
        return new ContentProvider(driver);
    }

}

