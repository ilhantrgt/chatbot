import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class app {

    WebDriver driver ;
    String BASE_URL = "https://demoqa.com/text-box";

    By messageTypeLocator = new By.ByXPath("//*[@id=\"userName\"]");
    By sendMessageLocator = new By.ByXPath("//*[@id=\"submit\"]");
    By resultLocator = new By.ByXPath("//*[@id=\"name\"]");

    public app() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        TimeUnit.SECONDS.sleep(5);
    }

     public void runChatBot(String question) throws InterruptedException {

        waitFor(messageTypeLocator);
        driver.findElement(messageTypeLocator).sendKeys(question);
        waitFor(sendMessageLocator);
        driver.findElement(sendMessageLocator).click();
        TimeUnit.SECONDS.sleep(5);
        String r1 = driver.findElement(resultLocator).getText();
        System.out.println(r1);
        waitFor(resultLocator);
    }


    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver , 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
