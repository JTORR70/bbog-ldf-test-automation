package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    //Esperas Explícitas
    private static WebDriverWait wait;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        options.addArguments("start-maximized","--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    //Sin Shadow Root
    public WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void click(String locator){
        Find(locator).click();
    }

    public void shadowClickOne(By root, By element) {
        WebElement rootOne = driver.findElement(root);
        SearchContext shadowRoot1 = rootOne.getShadowRoot();
        shadowRoot1.findElement(element).click();
    }

    public void shadowSendKeysOne(By root, By element, String data) {
        WebElement rootOne = driver.findElement(root);
        SearchContext shadowRoot1 = rootOne.getShadowRoot();
        shadowRoot1.findElement(element).clear();
        shadowRoot1.findElement(element).sendKeys(data);
    }

    public void shadowClearOne(By root, By element) {
        WebElement rootOne = driver.findElement(root);
        SearchContext shadowRoot1 = rootOne.getShadowRoot();
        shadowRoot1.findElement(element).clear();
    }

    public static String getText(By root, By element) {
        WebElement rootOne = driver.findElement(root);
        SearchContext shadowRoot1 = rootOne.getShadowRoot();
        return shadowRoot1.findElement(element).getText();
    }

    @AfterAll
    public static void tearDown(){
       driver.quit();
    }
}
