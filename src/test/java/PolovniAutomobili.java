import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PolovniAutomobili {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }


    @Test(description = "Search for automobile")
    @Description("Search by brand and model")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("EP001")
    @Feature("FE001")
    @Story("ST001")
    @TmsLink("PA-1")
    @Issue("PA-2")
    @Link("PA-3")
    public void searchAutomobile() {
        driver.get("https://www.polovniautomobili.com/");

        Select brand = new Select(driver.findElement(By.id("brand")));
        brand.selectByValue("alfa-romeo");

        driver.findElement(By.id("model")).click();
        driver.findElement(By.xpath("//label[contains(text(),'156 Crosswagon')]")).click();

    }
}