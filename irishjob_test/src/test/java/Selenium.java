import com.google.protobuf.Duration;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        this._javascript_element(webDriver, "/html[1]/body[1]/span[1]/span[1]/div[2]/div[1]/div[2]/button[2]");

        this._get_element_by_id(webDriver, "sign-in-toggle").click();
        this._get_element_by_id(webDriver, "Email").sendKeys("tester.cdiaz@gmail.com");
        this._get_element_by_id(webDriver, "Password").sendKeys("20.Serv3r.Id");
        this._get_element_by_id(webDriver, "loginButton").click();

        this._get_element_by_xpath(webDriver, "//a[contains(text(),'IrishJobs.ie')]").click();



        WebElement element = webDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        List<WebElement> elements = element.findElements(By.tagName("div"));

        assertThat(elements).isNotNull();
    }

    public WebElement _get_element_by_id(WebDriver web, String id){
        WebDriverWait wait = new WebDriverWait(web, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        WebElement element = web.findElement(By.id(id));
        System.out.print("It interacts with: " + id);
        return element;
    }

    public WebElement _get_element_by_xpath(WebDriver web, String xpath){
        WebDriverWait wait = new WebDriverWait(web, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement element = web.findElement(By.xpath(xpath));
        System.out.print("It interacts with: " + xpath);
        return element;
    }

    public void _javascript_element(WebDriver web, String element){
        JavascriptExecutor executor = (JavascriptExecutor) web;
        executor.executeScript("arguments[0].click();", web.findElement(By.xpath(element)));
    }

    public WebElement _get_element_by_link(WebDriver web, String link){
        WebDriverWait wait = new WebDriverWait(web, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
        WebElement element = web.findElement(By.linkText(link));
        System.out.print("It interacts with: " + link);
        return element;
    }



}
