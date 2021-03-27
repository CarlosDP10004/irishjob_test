import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class Test_Case_01 {
    private Methods FW = new Methods();
    private WebDriver webDriver = Driver.webDriver;

    @Step("Verify amount jobs recommended for you")
    public void verify_jobs(){
        FW._get_element_by_xpath(webDriver, "//a[contains(text(),'IrishJobs.ie')]").click();
        WebElement element = FW._get_element_by_xpath(webDriver, "//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
        List<WebElement> elements = element.findElements(By.tagName("div"));
        System.out.print("Amount of jobs found is: " + elements.size());
        elements.forEach(System.out::println);
        Assert.assertTrue(elements.size() > 0);
        //assertThat(elements).isNotNull();
    }

}
