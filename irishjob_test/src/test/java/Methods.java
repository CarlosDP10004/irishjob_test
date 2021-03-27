import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Methods {

    public WebDriver open_browser(String url){
        WebDriver driver = Driver.webDriver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.get(url);
        return driver;
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
        System.out.print("It interacts with: " + element);
    }

    public WebElement _get_element_by_link(WebDriver web, String link){
        WebDriverWait wait = new WebDriverWait(web, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
        WebElement element = web.findElement(By.linkText(link));
        System.out.print("It interacts with: " + link);
        return element;
    }
}
