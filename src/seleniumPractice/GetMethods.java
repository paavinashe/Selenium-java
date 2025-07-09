package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		//System.out.println(driver.getWindowHandle());
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
		
		Set <String> windowIDs = driver.getWindowHandles();
		
		System.out.println(windowIDs);

	}

}
