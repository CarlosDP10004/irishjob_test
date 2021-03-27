import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Test_Case_02 {

    private Methods FW = new Methods();
    private WebDriver webDriver = Driver.webDriver;

    public void search_job(String job){
        FW._get_element_by_xpath(webDriver, "//input[@id='Keywords']").sendKeys(job);
        FW._get_element_by_id(webDriver, "btnSubmit").click();

        String value = FW._get_element_by_xpath(webDriver, "//div[contains(text(),'No jobs were found to match your criteria, you can')]").getText();

        assertTrue(actualString.contains("specific text"));
    }
}
