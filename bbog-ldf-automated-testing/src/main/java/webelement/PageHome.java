package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class PageHome {
    private WebDriver driver;
    private BasePage shadow;
    public PageHome(WebDriver driver){
        this.driver=driver;
        shadow = new BasePage(driver);
    }
    //Elementos pantalla principal
    By actualizaTasasRoot = By.tagName("bdb-ml-multi-action");
    By actualizaTasasElement = By.id("card__0");
    By tasaDtf = By.id("DTF");
    By tasaDtfElement = By.id("bdb-at-input");
    By tasaIbr1m = By.id("IBR 1M");
    By tasaIbr1mElement = By.id("bdb-at-input");
    By tasaIbr3m = By.id("IBR 3M");
    By tasaIbr3mElement = By.id("bdb-at-input");
    By tasaIbr6m = By.id("IBR 6M");
    By tasaIbr6mElement = By.id("bdb-at-input");
    By toastPageElement = By.xpath("//bdb-at-toast[@type='SUCCESS']");
    By toastPage = By.className("bdb-at-toast__content__title");
    String saveButton = "//*[@id=\"btnSave\"]";

    public void uptadeRates(){
        shadow.shadowClickOne(actualizaTasasRoot,actualizaTasasElement);
    }
    public void uptadeDtf(){
        shadow.shadowSendKeysOne(tasaDtf,tasaDtfElement,"20.35");
    }
    public void uptadeIbr1m(){
        shadow.shadowSendKeysOne(tasaIbr1m,tasaIbr1mElement,"15.2569");
    }
    public void uptadeIbr3m() {
        shadow.shadowSendKeysOne(tasaIbr3m, tasaIbr3mElement, "13.1416");
    }
    public void uptadeIbr6m() {
        shadow.shadowSendKeysOne(tasaIbr6m, tasaIbr6mElement, "5.14");
    }
    public void button() {
        shadow.click(saveButton);
    }
}
