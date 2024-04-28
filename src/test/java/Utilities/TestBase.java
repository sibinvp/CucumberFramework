package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestBase {
	public WebDriver driver;
	public WebDriver webDriverManager() throws IOException {
		Properties pi=new Properties();
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Global.properties");
	pi.load(fi);
	String url=pi.getProperty("url");
	
	
		if(driver==null) {
		String browserName=pi.getProperty("browser");
			if(browserName.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.msedge.driver", System.getProperty("user.dir")+"//src//test//resources//msedgedriver.exe");
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("-guest");
		driver=new EdgeDriver(opt);
		driver.manage().window().maximize();
			}
		else
		{
		System.out.println("Please select browser as edge");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		System.out.println("browser is: "+browserName);
		
			
			}
		
		return driver;
	}

}
