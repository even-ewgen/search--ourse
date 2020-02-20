import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Main {
    private static ChromeOptions chromeOptions;
    private static WebDriver driver;

    private static final String urlPageSearch = "https://ednet.bulgakov.app/subject/";


    public static void main (String[] args) {

        chromeOptions = new ChromeOptions(); //задаем опции для работы с браузером
        //chromeOptions.setHeadless(true); //пользовательский интерфейс браузера выводиться не будет
        driver = new ChromeDriver(chromeOptions);  //работаем с сhrome
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //неявное ожидание появления результата для всех запросов

        driver.get("https://ednet.bulgakov.app"); //перешли в поисковик
        WebElement aut1 = driver.findElement(new By.ByCssSelector("input.sign-in-page__input:nth-child(1)"));
        aut1.sendKeys("ewgenia1997@gmail.com");

        WebElement aut2 = driver.findElement(new By.ByCssSelector("input.sign-in-page__input:nth-child(2)"));
        aut2.sendKeys("Schenya1997Ewgenia1997");

        WebElement aut3 = driver.findElement(new By.ByCssSelector(".sign-in-page__buttons > button:nth-child(1)"));
        aut3.click();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 2422; i < 2501; i++) {
            driver.get(urlPageSearch + i); //перешли в поисковик
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement searchString = driver.findElement(new By.ByCssSelector(".hub-lms-project-header__title"));
            System.out.println(i + " " + searchString.getText());

        }
        driver.quit();
    }
}
