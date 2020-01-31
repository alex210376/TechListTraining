package techList.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techList.core.BaseTest;
import techList.page.ContentProvider;
import techList.page.ContentProviderEdit;
import techList.page.Dashboard;
import techList.page.LoginPage;
import java.util.List;

import static java.lang.Thread.sleep;

public class TestsContentProvider extends BaseTest {

    //Проверка логирования, перехода на страницу "Контент-провайдер" и ограничения количества отображаемых записей
    @Test
    public void testLogin() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton();    //кликаем по кнопке login

        driver.manage().window().maximize(); //разворачиваем окно браузера на весь экран

        new Dashboard(driver)
                .clickContProv();  //кликаем по пункту меню "Контент-провайдер"
        ContentProvider contentProvider = new ContentProvider(driver);
        String pageTitle = contentProvider.selectPageName(); //Получаем название страницы

        System.out.println("Название страницы: "+pageTitle);
        Assert.assertEquals(pageTitle, "Контент-провайдеры"); //Сравниваем полученное название страницы с ожидаемым

        contentProvider.selectTableLength(numberOflines);  //Выбираем количества отображаемых на экране записей (из common.properties)

        //Заносим в коллекцию выведенные записи
        List<WebElement> elements = contentProvider.selectLines();
        //Заносим в переменную actualNumberOflines количество реально выведенных записей
        System.out.println(elements);
        int actualNumberOflines = elements.size();
        //Приводим к типу int ожидаемое количество записей
        int expectedNumberOflinesInt = Integer.parseInt (numberOflines);
        //выполняем сравнение ожидаемого и реального количества записей
        Assert.assertEquals(actualNumberOflines, expectedNumberOflinesInt);
        System.out.println("Количество отображаемых строк: "+elements.size());


        sleep(3000);

    }

    //Проверка сортировки по всем полям на странице Контент-провайдер
    @Test
    public void testSort() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton();    //кликаем по кнопке login

        driver.manage().window().maximize(); //разворачиваем окно браузера на весь экран

        new Dashboard(driver)
                .clickContProv();   //кликаем по пункту меню "Контент-провайдер"

        new ContentProvider(driver)
                .selectTableLength(numberOflines)
                .clickN().clickN()              //двойной клик по "#"
                .clickID().clickID()            //двойной клик по ID
                .clickStatus().clickStatus()    //двойной клик по статусу
                .clickName().clickName()        //двойной клик по имени
                .clickBIN().clickBIN();         //двойной клик по BIN

        sleep(3000);

    }

    //Проверка наличия полей ввода на форме редактирования
    @Test
    public void testEditForm() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton();    //кликаем по кнопке login

        driver.manage().window().maximize();  //разворачиваем окно браузера на весь экран

        new Dashboard(driver)
                .clickContProv()    //кликаем по пункту меню "Контент-провайдер"
                .clickEditButton(); //кликаем по пиктограмме редактирования

        ContentProviderEdit contentProviderEdit = new ContentProviderEdit(driver);

        //Получаем имя поля "Название" и сравниваем с сожидаемым
        String name = contentProviderEdit.getName();
        Assert.assertEquals(name, "Название");
        //Получаем имя поля "Статус" и сравниваем с сожидаемым
        String status = contentProviderEdit.getStatus();
        Assert.assertEquals(status, "Cтатус");
        //Получаем имя поля "БИН" и сравниваем с сожидаемым
        String bin = contentProviderEdit.getBIN();
        Assert.assertEquals(bin, "БИН");
        //Получаем имя поля "С даты" и сравниваем с сожидаемым
        String dateFrom = contentProviderEdit.getDateFrom();
        Assert.assertEquals(dateFrom, "С даты");
        //Получаем имя поля "По дату" и сравниваем с сожидаемым
        String dateTo = contentProviderEdit.getDateTo();
        Assert.assertEquals(dateTo, "По дату");
        //Получаем имя поля "Комментарий" и сравниваем с сожидаемым
        String comment = contentProviderEdit.getComment();
        Assert.assertEquals(comment, "Коментарий");

        sleep(3000);
    }

    //Проверка удаления записи
    @Test
    public void testDeleteLine() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton();    //кликаем по кнопке login

        driver.manage().window().maximize(); //разворачиваем окно браузера на весь экран

        new Dashboard(driver)
                .clickContProv();  //кликаем по пункту меню "Контент-провайдер"

        ContentProvider contentProvider = new ContentProvider(driver);
        String infoLineBefore = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsBefore = Integer.parseInt(infoLineBefore.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей до удаления: "+ numberOfRecordsBefore);   //выводим на экран количество строк

        new ContentProvider(driver).clickDeleteButton(); //кликаем по пиктограмме удаления

        sleep(500);

        new ContentProvider(driver)
                .clickConfirmDeleteButton();       //кликаем по кнопке подтверждения удаления

        String infoLineAfter = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsAfter = Integer.parseInt(infoLineAfter.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей после удаления: "+ numberOfRecordsAfter); //выводим на экран количество строк

        Assert.assertEquals(numberOfRecordsBefore, numberOfRecordsAfter+1); //выполняем сравнение количества записей до удаления и после удаления + 1

        sleep(3000);
    }

}
