package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.time.Duration;

// ExtentReports import panrom
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginTest {

  
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
       
        ExtentSparkReporter reporter = new ExtentSparkReporter("Automation_Report.html");
        reporter.config().setReportName("QA Automation Results");
        reporter.config().setDocumentTitle("Test Execution Report");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        return ExcelReader.getExcelData();
    }

    @Test(dataProvider = "LoginData")
    public void testLoginScenario(String username, String password) throws Exception {
        
        if(username == null || username.trim().isEmpty()) {
            return; 
        }

      
        test = extent.createTest("Login Test: " + username);

        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();
            
            Thread.sleep(2000); 

            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            
            Assert.assertEquals(actualUrl, expectedUrl, "Login Failed for user: " + username);
            
        
            test.pass("Login successful and URL verified for user: " + username);

        } catch (AssertionError e) {
            test.fail("Test failed: " + e.getMessage());
            throw e; 
        } catch (Exception e) {
            test.fail("Automation Error: " + e.getMessage());
            throw e;
        } finally {
            driver.quit(); 
        }
    }

    @AfterTest
    public void tearDownReport() {
       
        extent.flush();
    }
}