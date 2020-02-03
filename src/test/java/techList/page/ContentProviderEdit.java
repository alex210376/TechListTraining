package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class ContentProviderEdit extends BasePage {

    @FindBy(xpath = "//label[@for='name']")
    private WebElement fieldName;

    @FindBy(xpath = "//label[@for='status']")
    private WebElement fieldStatus;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement fieldBIN;

    @FindBy(xpath = "//label[@for='active_from']")
    private WebElement fieldDateFrom;

    @FindBy(xpath = "//label[@for='active_to']")
    private WebElement fieldDateTo;

    @FindBy(xpath = "//label[@for='comment']")
    private WebElement fieldComment;

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
}
