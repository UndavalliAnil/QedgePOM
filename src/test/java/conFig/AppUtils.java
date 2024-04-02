package conFig;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogout;


public class AppUtils

{
	public static WebDriver driver;
	public static Properties conpro;
	@BeforeTest
	public void setup() throws Throwable
	{
		conpro = new Properties();
		conpro.load(new FileInputStream("./PropertyFiles/Envinornment.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(conpro.getProperty("Url"));
		//call login page class
		AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
		//call login method
		login.adminLogin("admin", "master");
	}
	@AfterTest
	public void tearDown()
	{
		AdminLogout Alogout = PageFactory.initElements(driver, AdminLogout.class);
		Alogout.Logout();
		driver.quit();
	}

}
