import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("http://34.131.129.205:8069/web/login?redirect=%2Fodoo%3F");
        driver.manage().window().maximize();
    }
}
