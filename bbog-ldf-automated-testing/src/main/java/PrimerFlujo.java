import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.BasePage;
import utils.Browser;
import webelement.PageHome;

public class PrimerFlujo extends BasePage{
    private PageHome page;

    public PrimerFlujo() {
        super(driver);
        page = new PageHome(driver);
    }

    @Test()
    public void createRate() throws InterruptedException {
        driver.get("https://ldf-digital-web-ui.bbogcreditocomercialtccstg.com/");
        page.uptadeRates();
        Thread.sleep(4000);
        page.uptadeDtf();
        Thread.sleep(1000);
        page.uptadeIbr1m();
        Thread.sleep(1000);
        page.uptadeIbr3m();
        Thread.sleep(1000);
        page.uptadeIbr6m();

        Thread.sleep(4000);
        page.button();
        //Assert.assertEquals("¡Actualizamos las tasas de hoy satisfactoriamente!", getText(toastPageElement,toastPage));
    }
}
