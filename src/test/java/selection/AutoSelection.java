package selection;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSelection {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com");
		driver.manage().window().maximize();
		WebElement autoComplete = driver.findElement(By.xpath("//img[@alt='Auto Complete']"));
		autoComplete.click();
		
		WebElement textBox=driver.findElement(By.xpath("//input[@class='ui-autocomplete-input']"));
		textBox.sendKeys("R");
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		List<WebElement>listOfCourses=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		
		for (WebElement course : listOfCourses) {
			String courseSelected=course.getText();
			if(courseSelected.equals("Rest API")) {
				course.click();
				String val=textBox.getAttribute("value");
				System.out.println(val);
			}
			
			
		}
		
		driver.quit();
	}

}
