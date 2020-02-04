package techList.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import techList.core.BasePage;

import java.util.List;

public class ContentProvider extends BasePage {

    @FindBy(xpath = "//select[@name='entTable_length']")
    private WebElement tableLength;

    @FindBy(xpath = "//span[text()='Контент-провайдеры']")
    private WebElement pageName;

    @FindBy(xpath = "//th[text()='#']")
    private WebElement clickNElement;

    @FindBy(xpath = "//th[text()='ID']")
    private WebElement clickIDElement;

    @FindBy(xpath = "//th[text()='Статус']")
    private WebElement clickStatusElement;

    @FindBy(xpath = "//*[@id='entTable']/tbody/tr[1]/td[3]/div")
    private WebElement Status;

    @FindBy(xpath = "//th[text()='Наименование']")
    private WebElement clickNameElement;

    @FindBy(xpath = "//*[@id='entTable']/tbody/tr[1]/td[4]")
    private WebElement Name;

    @FindBy(xpath = "//th[text()='БИН']")
    private WebElement clickBINElement;

    @FindBy(xpath = "//*[@id='entTable']/tbody/tr[1]/td[5]")
    private WebElement BIN;

    @FindBy(xpath = "//*[@id='entTable']/tbody/tr[1]/td[6]/a[1]/i")
    private WebElement clickEdit;

    @FindBy(xpath = "//*[@id='entTable']/tbody/tr[1]/td[6]/a[2]/i")
    private WebElement clickDelete;

    @FindBy(xpath = "//button[text()='Удалить']")
    private WebElement clickConfirmDelete;

    @FindBy(xpath = "//*[@id='entTable_info']")
    private WebElement infoLine;

    @FindBy(xpath = "//a[text()=' Добавить']")
    private WebElement clickAdd;

    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement clickLogout;

    @FindBy(xpath = "//td[@class='sorting_1']")
    private List<WebElement> allIdOnPage;


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
        List<WebElement> elements = driver.findElements (By.xpath("//td[@class='sorting_1']"));
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

    //Клик по по кнопке "Добавить"
    public ContentProviderAdd clickAddButton(){
        clickAdd.click();
        return new ContentProviderAdd(driver);
    }


    //Чтение информации о количестве записей
    public String getInfo(){
        return infoLine.getText().trim();
    }

    //Получение имени контент-провайдера
    public String getName(){
        return Name.getText().trim();
    }

    //Получение статуса контент-провайдера
    public String getStatus(){
        return Status.getText().trim();
    }

    //Получение BIN контент-провайдера
    public String getBIN(){
        return BIN.getText().trim();
    }


    //Клик по кнопке Logout
    public ContentProvider clickLogout() {
        clickLogout.click();
        return this;
    }
    //Повторный клик по кнопке Logout
    public LoginPage clickLogoutSecond() {
        clickLogout.click();
        return new LoginPage(driver);
    }




}
