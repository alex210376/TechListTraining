package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import techList.core.BasePage;

public class ContentProviderEdit extends BasePage {

    @FindBy(xpath = "//label[@for='name']")
    private WebElement fieldName;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement fieldNameInput;

    @FindBy(xpath = "//label[@for='status']")
    private WebElement fieldStatus;

    @FindBy(xpath = "//select[@name='status']")
    private WebElement fieldStatusInput;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement fieldBIN;

    @FindBy(xpath = "//input[@name='bin']")
    private WebElement fieldBINInput;

    @FindBy(xpath = "//label[@for='active_from']")
    private WebElement fieldDateFrom;

    @FindBy(xpath = "//input[@name='active_from']")
    private WebElement fieldDateFromInput;

    @FindBy(xpath = "//label[@for='active_to']")
    private WebElement fieldDateTo;

    @FindBy(xpath = "//input[@name='active_to']")
    private WebElement fieldDateToInput;

    @FindBy(xpath = "//label[@for='comment']")
    private WebElement fieldComment;

    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement fieldCommentInput;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement clickSave;



    public ContentProviderEdit(WebDriver driver) {
        super(driver);
    }

    //Получаем название поля "Название"
    public String getName(){
        return fieldName.getText();
    }

    //Получаем название поля "Статус"
    public String getStatus(){
        return fieldStatus.getText();
    }

    //Получаем название поля "BIN"
    public String getBIN(){
        return fieldBIN.getText();
    }

    //Получаем название поля "С даты"
    public String getDateFrom(){
        return fieldDateFrom.getText();
    }

    //Получаем название поля "По дату"
    public String getDateTo(){
        return fieldDateTo.getText();
    }

    //Получаем название поля "Комментарий"
    public String getComment(){
        return fieldComment.getText();
    }



    //Ввод названия
    public ContentProviderEdit fillName(String name){
        fillField(fieldNameInput, name);
        return this;
    }

    //Выбор статуса - активный/неактивный
    public ContentProviderEdit selectStatus(String status){
        Select select = new Select(fieldStatusInput);
        select.selectByVisibleText(status);
        return this;
    }


    //Ввод BIN
    public ContentProviderEdit fillBIN(String bin){
        fillField(fieldBINInput, bin);
        return this;
    }

    //Ввод С даты
    public ContentProviderEdit fillDateFrom(String dateFrom){
        fillField(fieldDateFromInput, dateFrom);
        return this;
    }

    //Ввод По дату
    public ContentProviderEdit fillDateTo(String dateTo){
        fillField(fieldDateToInput, dateTo);
        return this;
    }

    //Ввод комментария
    public ContentProviderEdit fillComment(String comment){
        fillField(fieldCommentInput, comment);
        return this;
    }

    //Клик по кнопке Сохранить
    public ContentProvider clickSaveButton() {
        clickSave.click();
        return new ContentProvider(driver);
    }
}
