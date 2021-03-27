import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium {
    @Step("Open browser")
    public void open_browser(){
        WebDriver webDriver = Driver.webDriver;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        webDriver.get("https://www.irishjobs.ie/");

        WebElement element = webDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        List<WebElement> elements = element.findElements(By.tagName("div"));

        

    }



}
