package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Browser {
    protected  WebDriver driver;
    @BeforeTest
    public void browserSetup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://34.131.129.205:8069/web/login?redirect=%2Fodoo%3F");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        //driver.close();
    }

}
