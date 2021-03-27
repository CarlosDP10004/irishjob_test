import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class Test_Case_01 {
    private Methods FW = new Methods();
    private WebDriver webDriver = Driver.webDriver;

    /*@Step("Go to site <url> now")
    public void go_to_site(String url){
        FW.open_browser(url);
    }

    @Step("Login user <user> with password <password>")
    public void login_user(String user, String password){
        FW._javascript_element(webDriver, "/html[1]/body[1]/span[1]/span[1]/div[2]/div[1]/div[2]/button[2]");
        FW._get_element_by_id(webDriver, "sign-in-toggle").click();
        FW._get_element_by_id(webDriver, "Email").sendKeys("tester.cdiaz@gmail.com");
        FW._get_element_by_id(webDriver, "Password").sendKeys("20.Serv3r.Id");
        FW._get_element_by_id(webDriver, "loginButton").click();
    }*/
    @Step("Verify amount jobs recommended for you")
    public void verify_jobs(){
        FW._get_element_by_xpath(webDriver, "//a[contains(text(),'IrishJobs.ie')]").click();
        WebElement element = FW._get_element_by_xpath(webDriver, "//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
        List<WebElement> elements = element.findElements(By.tagName("div"));
        System.out.print("Amount of jobs found is: " + elements.size());
        elements.forEach(System.out::println);

        assertThat(elements).isNotNull();
    }

}
