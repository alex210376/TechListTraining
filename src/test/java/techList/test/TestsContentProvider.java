package techList.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techList.core.BaseTest;
import techList.page.ContentProvider;
import techList.page.ContentProviderEdit;
import techList.page.Dashboard;
import techList.page.LoginPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class TestsContentProvider extends BaseTest {

    //Проверка логирования, перехода на страницу "Контент-провайдер" и ограничения количества отображаемых записей
    @Test (enabled = true)
    public void testLogin() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()    //кликаем по кнопке login
                .clickMenu();          //кликаем по пиктограмее Menu

        new Dashboard(driver)
                .clickContProv();  //кликаем по пункту меню "Контент-провайдер"
        ContentProvider contentProvider = new ContentProvider(driver);
        String pageTitle = contentProvider.selectPageName(); //Получаем название страницы

        System.out.println("Название страницы: " + pageTitle);
        Assert.assertEquals(pageTitle, "Контент-провайдеры"); //Сравниваем полученное название страницы с ожидаемым

        contentProvider.selectTableLength(numberOflines);  //Выбираем количества отображаемых на экране записей (из common.properties)


        List<WebElement> elements = contentProvider.selectLinesID();   //Заносим в коллекцию полученные элементы с идентификаторами

        System.out.println(contentProvider.getElements(elements));     //выводим полученные ID на экран

        int actualNumberOflines = elements.size();                  //Заносим в переменную actualNumberOflines количество реально выведенных записей
        int expectedNumberOflinesInt = Integer.parseInt (numberOflines);         //Приводим к типу int ожидаемое количество записей

        Assert.assertEquals(actualNumberOflines, expectedNumberOflinesInt);      //выполняем сравнение ожидаемого и реального количества записей
        System.out.println("Количество отображаемых строк: " + elements.size());

//        new ContentProvider(driver)
//                .clickLogout().clickLogoutSecond(); //выходим из аккаунта

        sleep(3000);

    }

    //Проверка сортировки по всем полям на странице Контент-провайдер
    @Test (enabled = true)
    public void testSort() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()    //кликаем по кнопке login
                .clickMenu();          //кликаем по пиктограмее Menu

        new Dashboard(driver)
                .clickContProv();   //кликаем по пункту меню "Контент-провайдер"

        ContentProvider contentProvider = new ContentProvider(driver)
                .selectTableLength(numberOflines)
                .clickN().clickN()              //двойной клик по "#"
                .clickID().clickID()            //двойной клик по ID
                .clickStatus().clickStatus()    //двойной клик по статусу
                .clickName().clickName()       //двойной клик по имени
                .clickBIN().clickBIN();         //двойной клик по BIN


        List<WebElement> elements = contentProvider.selectLinesNames();   //Заносим в коллекцию полученные элементы с названиями

        List <String> elementsName = contentProvider.getElements(elements);  //Вызываем метод getElements для получения коллекции с названиями
        System.out.println(elementsName);     //выводим полученные названия на экран
        Collections.sort(elementsName);       //выполняем сортировку полученных значений
        System.out.println(elementsName);     //выводим полученные названия на экран после сортировки


        contentProvider.clickLogout().clickLogoutSecond();  //выходим из аккаунта

        sleep(3000);
    }

    //Проверка наличия полей ввода на форме редактирования
    @Test(enabled = true)
    public void testEditForm() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()     //кликаем по кнопке login
                .clickMenu();           //кликаем по пиктограмее Menu

        new Dashboard(driver)
                .clickContProv()    //кликаем по пункту меню "Контент-провайдер"
                .clickEditButton(); //кликаем по пиктограмме редактирования

        ContentProviderEdit contentProviderEdit = new ContentProviderEdit(driver);


        String name = contentProviderEdit.getName();     //Получаем имя поля "Название" и сравниваем с сожидаемым
        Assert.assertEquals(name, "Название");

        String status = contentProviderEdit.getStatus();  //Получаем имя поля "Статус" и сравниваем с сожидаемым
        Assert.assertEquals(status, "Cтатус");

        String bin = contentProviderEdit.getBIN();         //Получаем имя поля "БИН" и сравниваем с сожидаемым
        Assert.assertEquals(bin, "БИН");

        String dateFrom = contentProviderEdit.getDateFrom(); //Получаем имя поля "С даты" и сравниваем с сожидаемым
        Assert.assertEquals(dateFrom, "С даты");

        String dateTo = contentProviderEdit.getDateTo();    //Получаем имя поля "По дату" и сравниваем с сожидаемым
        Assert.assertEquals(dateTo, "По дату");

        String comment = contentProviderEdit.getComment();   //Получаем имя поля "Комментарий" и сравниваем с сожидаемым
        Assert.assertEquals(comment, "Коментарий");


        sleep(3000);
    }

    //Проверка добавления записи на странице "Контент-провайдер"
    @Test (enabled = true)
    public void testAddLine() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()     //кликаем по кнопке login
                .clickMenu();           //кликаем по пиктограмее Menu

        driver.manage().window().maximize(); //разворачиваем окно браузера на весь экран
        new Dashboard(driver)
                .clickContProv();  //кликаем по пункту меню "Контент-провайдер"

        ContentProvider contentProvider = new ContentProvider(driver);
        String infoLineBefore = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsBefore = Integer.parseInt(infoLineBefore.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей до добавления: "+ numberOfRecordsBefore);   //выводим на экран количество строк

        new ContentProvider(driver)
                .clickAddButton()             //кликаем по кнопке добавления записи "Добавить"
                .fillName("Test")             //вводим наименование контент-провайдера
                .selectStatus("Активный")   //выбираем статус контент-провайдера - активный/неактивный
                .fillEmail("test@gmail.com")  //вводим электронный адрес
                .fillPhone("0501234567")      //вводим телефон
                .fillBIN("7777")               //вводим BIN
                .fillDateFrom("10.10.2020")   //вводим С даты
                .fillDateTo("10.10.2030")     //вводим По дату
                .fillComment("Test Provider") //вводим комментарий
                .clickSaveButton();           //кликаем по кнопке Сохранить

        driver.navigate().refresh(); //обновляем страницу

        String infoLineAfter = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsAfter = Integer.parseInt(infoLineAfter.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей после добавления: "+ numberOfRecordsAfter); //выводим на экран количество строк

        Assert.assertEquals(numberOfRecordsBefore, numberOfRecordsAfter-1); //выполняем сравнение количества записей до добавления и после

        new ContentProvider(driver)
                .clickLogout().clickLogoutSecond(); //выходим из аккаунта

        sleep(3000);
    }



    //Проверка удаления записи
    @Test (enabled = true)
    public void testDeleteLine() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()     //кликаем по кнопке login
                .clickMenu();           //кликаем по пиктограмее Menu

        new Dashboard(driver)
                .clickContProv();  //кликаем по пункту меню "Контент-провайдер"

        ContentProvider contentProvider = new ContentProvider(driver);
        String infoLineBefore = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsBefore = Integer.parseInt(infoLineBefore.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей до удаления: "+ numberOfRecordsBefore);   //выводим на экран количество строк

        new ContentProvider(driver).clickDeleteButton(); //кликаем по пиктограмме удаления

        sleep(200);   //безусловное ожидание формы удаления (надо доработать)

        new ContentProvider(driver)
                .clickConfirmDeleteButton();       //кликаем по кнопке подтверждения удаления

        String infoLineAfter = contentProvider.getInfo();    //получаем информационную строку с количеством записей
        int numberOfRecordsAfter = Integer.parseInt(infoLineAfter.substring(23, 26));  //выделяем количество и приводим к типу int
        System.out.println("Количество записей после удаления: "+ numberOfRecordsAfter); //выводим на экран количество строк

        Assert.assertEquals(numberOfRecordsBefore, numberOfRecordsAfter+1); //выполняем сравнение количества записей до удаления и после удаления + 1

        new ContentProvider(driver)
                .clickLogout().clickLogoutSecond(); //выходим из аккаунта

        sleep(3000);
    }

    //Проверка формы редактирования на ввод новых значений и сохранение
    @Test(enabled = true)
    public void testEditFormInput() throws InterruptedException {
        new LoginPage(driver)
                .goToHome(baseUrl)      //открываем страницу
                .fillUserName(login)    //вводим логин
                .fillPassword(password) //вводим пароль
                .clickLoginButton()     //кликаем по кнопке login
                .clickMenu();           //кликаем по пиктограмее Menu
        driver.manage().window().maximize(); //разворачиваем окно браузера на весь экран


        new Dashboard(driver)
                .clickContProv()    //кликаем по пункту меню "Контент-провайдер"
                .clickEditButton(); //кликаем по пиктограмме редактирования

        ContentProviderEdit contentProviderEdit = new ContentProviderEdit(driver);

        String name = "Test EditForm";
        String status = "Активный";
        String bin = "7777";

        new ContentProviderEdit(driver)
                .fillName(name)             //вводим наименование контент-провайдера
                .selectStatus(status)          //выбираем статус контент-провайдера - активный/неактивный
                .fillBIN(bin)               //вводим BIN
                .fillDateFrom("01.01.2019")   //вводим С даты
                .fillDateTo("01.01.2029")     //вводим По дату
                .fillComment("Проверка ввода данных на форме редактирования") //вводим комментарий
                .clickSaveButton();           //кликаем по кнопке Сохранить


        driver.navigate().refresh(); //обновляем страницу
        ContentProvider contentProvider = new ContentProvider(driver);
        String nameAfter = contentProvider.getName();    //получаем наименование контент-провайдера после редактирования
        String statusAfter = contentProvider.getStatus();    //получаем статус контент-провайдера после редактирования
        String binAfter = contentProvider.getBIN();    //получаем BIN контент-провайдера после редактирования

        Assert.assertEquals(nameAfter, name);         //выполняем сравнение наименований контент-провайдера до и после редактирования
        Assert.assertEquals(statusAfter, status);     //выполняем сравнение статусов контент-провайдера до и после редактирования
        Assert.assertEquals(binAfter, bin);           //выполняем сравнение BIN контент-провайдера до и после редактирования

        sleep(3000);
    }
}
