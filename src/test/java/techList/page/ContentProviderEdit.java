package techList.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techList.core.BasePage;

public class ContentProviderEdit extends BasePage {

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/div[1]/div[1]/label")
    private WebElement fieldName;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/div[1]/div[2]/label")
    private WebElement fieldStatus;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/div[2]/div[1]/label")
    private WebElement fieldBIN;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/div[2]/div[2]/label")
    private WebElement fieldDateFrom;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/div[2]/div[3]/label")
    private WebElement fieldDateTo;

    @FindBy(xpath = "/html/body/div/div/div/div/div/form/div[2]/label")
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
