import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {

    public String baseUrl = "https://app2-8804548.skytap.fulcrum.net:8443/cats/login";
    String driverPath = "C:\\selenium Browser Drivers\\Chrome\\chromedriver.exe";
    public WebDriver driver ;

    @BeforeTest
    public void launchBrowser() {
        String property = System.getProperty("ENV");
        ChromeDriver();
        driver.get(baseUrl);
    }

    private void ChromeDriver() {
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    private void IEDriver() {
        System.out.println("launching chrome browser");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        System.setProperty("webdriver.ie.driver","C:\\selenium Browser Drivers\\IE\\IEDriverServer.exe");
        WebDriver driver=new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyHomepageTitle() {
        String expectedTitle = "CATS CenterPoint:";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

   }
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
