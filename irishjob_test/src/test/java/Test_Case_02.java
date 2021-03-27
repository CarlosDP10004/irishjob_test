import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class Test_Case_02 {

    private Methods FW = new Methods();
    private WebDriver webDriver = Driver.webDriver;

    @Step("Search a fake job <job>")
    public void search_fake_job(String job){
        FW._get_element_by_xpath(webDriver, "//a[contains(text(),'IrishJobs.ie')]").click();
        FW._get_element_by_xpath(webDriver, "//input[@id='Keywords']").clear();
        FW._get_element_by_xpath(webDriver, "//input[@id='Keywords']").sendKeys(job);
        FW._get_element_by_id(webDriver, "btnSubmit").click();
        String value = FW._get_element_by_xpath(webDriver, "//div[contains(text(),'No jobs were found to match your criteria, you can')]").getText();
        assertTrue(value.contains("No jobs were found to match your criteria, you can"));
    }

    @Step("Search a real job <job>")
    public void search_real_job(String job){
        FW._get_element_by_xpath(webDriver, "//a[contains(text(),'IrishJobs.ie')]").click();
        FW._get_element_by_xpath(webDriver, "//input[@id='Keywords']").clear();
        FW._get_element_by_xpath(webDriver, "//input[@id='Keywords']").sendKeys(job);
        FW._get_element_by_id(webDriver, "btnSubmit").click();
        String value = FW._get_element_by_xpath(webDriver, "//label[contains(text(),'Total Jobs Found:')]").getText();
        assertTrue(value.contains("Total Jobs Found:"));
    }

}
