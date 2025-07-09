package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToFindBrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		//Get all the links
		List<WebElement>links =  driver.findElements(By.tagName("a"));
		
		System.out.println("The total number of links on the page "+links.size());
		
		int noOfBrokenLinks = 0;
		for(WebElement weblinks:links) 
		{
			  String hrefatValue = weblinks.getAttribute("href");
			  
			  if(hrefatValue == null || hrefatValue.isEmpty()) 
			  {
				  System.out.println("hrefatValue value is null or empty so not possible to check");
				  continue;
			  }
			  //hit url to the server
			  
			  try {
				URL linkURL = new URL(hrefatValue); //Converted href value from string to url format
				  
				 HttpURLConnection conn  = (HttpURLConnection) linkURL.openConnection(); //open connection to the srver
				 
				 conn.connect(); //Connect to the server and sent request to the server
				 
				 if(conn.getResponseCode()>=400)
				 {
					 System.out.println(hrefatValue+" ======>Broken Link");
					 
					noOfBrokenLinks++;
				 }
				 else 
				 {
					 System.out.println(hrefatValue+" ======>Not a broken Link");
				 }
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Number of broken links: "+noOfBrokenLinks);
		

	}

}
