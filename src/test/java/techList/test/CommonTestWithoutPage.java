package techList.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import techList.page.ContentProvider;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CommonTestWithoutPage {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        Properties properties = new Properties();
        // Вычитываем файл *.properties из директории <root>/src/main/resources
        properties.load(this.getClass().getClassLoader().getResourceAsStream("common.properties"));

        // Инициализируем драйвер Chrome
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
        driver = new ChromeDriver();

        // Инициализируем драйвер FireFox
//        System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
//        driver = new FirefoxDriver();

        // Инициализируем драйвер Opera
//        System.setProperty("webdriver.opera.driver", properties.getProperty("opera.driver"));
//        driver = new OperaDriver();

        baseUrl = properties.getProperty("baseUrl");

    }

    @Test
    @Ignore
    public void testIncorrectLogin() throws InterruptedException, IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("common.properties"));

        //Открываем страницу
        driver.get(baseUrl);

        //Вводим имя пользователя
        driver.findElement(By.id("login-username")).click();
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(properties.getProperty("login"));

        //Вводим пароль
        driver.findElement(By.id("login-password")).click();
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys(properties.getProperty("password"));

        //Нажимаем на кнопку Логин
        driver.findElement(By.id("login")).click();

        //Раскрываем окно браузера на весь экран
        driver.manage().window().maximize();

        //Нажимаем на пункт меню "Контент-провайдеры"
        driver.findElement(By.xpath("//a[@href ='/dict/providers']")).click();

        //Выполняем проверку названия страницы
        String pageTitle = driver.findElement(By.cssSelector("body > div > section > div.container-fluid > header > div:nth-child(1) > span")).getText().trim();
        System.out.println("Название страницы: "+pageTitle);
        Assert.assertEquals(pageTitle, "Контент-провайдеры");

        //Заносим в переменную expectedNumberOflines количество записей
        String NumberOflines = properties.getProperty("numberOflines");

        //Выбираем "Показать переданное в "numberOflines" количество записей"
        WebElement element = driver.findElement(By.cssSelector("[name=\"entTable_length\"]"));
        Select select = new Select(element);
        select.selectByValue(NumberOflines);

        //Заносим в коллекцию выведенные записи
        List<WebElement> elements = driver.findElements (By.xpath("//*[@id=\"entTable\"]/tbody/tr"));

        //Заносим в переменную actualNumberOflines количество реально выведенных записей
        int actualNumberOflines = elements.size();

        //Приводим к типу int ожидаемое количество записей
        int expectedNumberOflinesInt = Integer.parseInt (NumberOflines);

        //Выполняем сравнение ожидаемого и реального количества записей
        Assert.assertEquals(actualNumberOflines, expectedNumberOflinesInt);
        System.out.println(elements.size());

        //Клик по сортировке "#"
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[1]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[1]")).click();

        //Клик по сортировке "ID"
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[2]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[2]")).click();

        //Клик по сортировке "Статус"
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[3]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[3]")).click();

        //Клик по сортировке "Наименование"
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[4]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[4]")).click();

        //Клик по сортировке "БИН"
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[5]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"entTable\"]/thead/tr/th[5]")).click();

        //Ожидание для просмотра результата
        sleep(5000);


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Закрываем браузер (все окна)
        driver.quit();
    }

}
