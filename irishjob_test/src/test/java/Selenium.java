import com.google.protobuf.Duration;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DURATION;

public class Selenium {
    @Step("Open browser")
    public void open_browser(){
        WebDriver webDriver = Driver.webDriver;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        webDriver.get("https://www.irishjobs.ie/");

        this._get_element_by_id(webDriver, "sign-in-toggle").click();

        //webDriver.findElement(By.id("sign-in-toggle")).click();
        webDriver.findElement(By.id("Email")).sendKeys("tester.cdiaz@gmail.com");
        webDriver.findElement(By.id("Password")).sendKeys("20.Serv3r.Id");
        webDriver.findElement(By.id("loginButton")).click();


        WebElement element = webDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        List<WebElement> elements = element.findElements(By.tagName("div"));

        assertThat(elements).isNotNull();
    }

    public WebElement _get_element_by_id(WebDriver web, String id){
        WebDriverWait wait = new WebDriverWait(web, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        WebElement element = web.findElement(By.id(id));
        return element;

    }



}
