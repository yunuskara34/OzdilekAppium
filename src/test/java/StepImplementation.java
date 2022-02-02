import com.thoughtworks.gauge.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class StepImplementation extends BaseTest {
    PageMethods pageMethods = new PageMethods();
    Logger logger = LogManager.getLogger(PageMethods.class);

    @Step("<time> saniye kadar bekle")
    public void waitForSeconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000L);
    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickElement(String xpath) {
        pageMethods.click(By.xpath(xpath));
    }

    @Step("id <id> li elemente tıkla")
    public void clickById(String id) {
        pageMethods.click(By.id(id));
    }

    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void pageControlById(String id, String text) {
        String actualValue = pageMethods.findElement(By.id(id)).getText();
        pageMethods.assertPage("Element text değerini içermiyor", actualValue, text);

    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void pageControlByXpath(String xpath, String text) {
        String actualValue = pageMethods.findElement(By.xpath(xpath)).getText();
        pageMethods.assertPage("Element text değerini içermiyor", actualValue, text);
    }

    @Step("Sayfayı aşağı kaydır")
    public void swipeDown() {
        pageMethods.swipeDown();
    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomElement(String xpath) {
        pageMethods.clickRandomElement(xpath);
    }

    @Step("id <name> li ementi bul ve <value> değerini yaz")
    public void sendkeysByid(String id, String text) {
        pageMethods.sendKeys(By.id(id), text);
    }


}
