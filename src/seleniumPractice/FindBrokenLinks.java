package seleniumPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) throws Exception  {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		//Get all the links
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		  
		System.out.println("Total number of links: "+links.size());
		int noOfBrokenLinks = 0;
		for(WebElement elementLink : links) 
		{
			String hrefAtValue = elementLink.getAttribute("href");
			
			if(hrefAtValue == null || hrefAtValue.isEmpty()) 
			{
				System.out.println("hrefAtValue is null or empty so not possible to check");
				continue;
			}
			
			//hit url to the server
			URL linkurl = new URL(hrefAtValue); //Convert href value from string to url format
			HttpURLConnection conn =(HttpURLConnection) linkurl.openConnection(); //open connection to the server
			conn.connect(); //connect to the server and sent request to the server
			
			if(conn.getResponseCode()>=400) 
			{
				System.out.println(hrefAtValue+ "=====>Broken link");
				
				noOfBrokenLinks ++;
			}
			else 
			{
				System.out.println(hrefAtValue+ "Not a broken link");
			}
			
		}
		  
		System.out.println("The total number of links are " +noOfBrokenLinks);
		
		
	}

}
