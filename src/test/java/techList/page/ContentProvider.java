package techList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import techList.core.BasePage;

import java.util.List;

public class ContentProvider extends BasePage {

    @FindBy(css = "[name=\"entTable_length\"]")
    private WebElement tableLength;

    @FindBy(css = "body > div > section > div.container-fluid > header > div:nth-child(1) > span")
    private WebElement pageName;

    @FindBy(xpath = "//*[@id=\"entTable\"]/thead/tr/th[1]")
    private WebElement clickNElement;

    @FindBy(xpath = "//*[@id=\"entTable\"]/thead/tr/th[2]")
    private WebElement clickIDElement;

    @FindBy(xpath = "//*[@id=\"entTable\"]/thead/tr/th[3]")
    private WebElement clickStatusElement;

    @FindBy(xpath = "//*[@id=\"entTable\"]/thead/tr/th[4]")
    private WebElement clickNameElement;

    @FindBy(xpath = "//*[@id=\"entTable\"]/thead/tr/th[5]")
    private WebElement clickBINElement;

    @FindBy(xpath = "//*[@id=\"entTable\"]/tbody/tr[1]/td[6]/a[1]/i")
    private WebElement clickEdit;

    @FindBy(xpath = "//*[@id=\"entTable\"]/tbody/tr[1]/td[6]/a[2]/i")
    private WebElement clickDelete;

    @FindBy(xpath = "//*[@id=\"del\"]/button")
    private WebElement clickConfirmDelete;

    @FindBy(xpath = "//*[@id=\"entTable_info\"]")
    private WebElement infoLine;



    public ContentProvider(WebDriver driver) {
        super(driver);
    }

    //Выбор количества отображаемых на экране записей
    public ContentProvider selectTableLength(String number){
        Select select = new Select(tableLength);
        select.selectByValue(number);
        return this;
    }

    //Запись имени страницы
    public String selectPageName(){
        return pageName.getText().trim();
    }

    //Запись в коллекцию всех отображаемых строк
    public List<WebElement> selectLines(){
        List<WebElement> elements = driver.findElements (By.xpath("//*[@id=\"entTable\"]/tbody/tr"));
        return elements;
    }

    //Клик по N для сортировки
    public ContentProvider clickN(){
        clickNElement.click();
        return this;
    }

    //Клик по ID для сортировки
    public ContentProvider clickID(){
        clickIDElement.click();
        return this;
    }

    //Клик по Статус для сортировки
    public ContentProvider clickStatus(){
        clickStatusElement.click();
        return this;
    }

    //Клик по Наименование для сортировки
    public ContentProvider clickName(){
        clickNameElement.click();
        return this;
    }

    //Клик по BIN для сортировки
    public ContentProvider clickBIN(){
        clickBINElement.click();
        return this;
    }

    //Клик по пиктограмме редактирования
    public ContentProviderEdit clickEditButton(){
        clickEdit.click();
        return new ContentProviderEdit(driver);
    }

    //Клик по пиктограмме удаления
    public ContentProvider clickDeleteButton(){
        clickDelete.click();
        return this;
    }

    //Клик по кнопке подтверждения удаления
    public ContentProvider clickConfirmDeleteButton(){
        clickConfirmDelete.click();
        return this;
    }

    //Чтение информации о количестве записей
    public String getInfo(){
        return infoLine.getText().trim();
    }

}
