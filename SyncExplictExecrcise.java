import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SyncExplictExecrcise {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nunix\\OneDrive\\Pulpit\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] phones = {"iphone", "Samsung", "Nokia", "Blackberry"};
	
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[@class='customradio'][2]/span[@class='checkmark']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("consult");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.card-title"));
		int j = 0;
		
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split(" ");
			String formattedName = name[0].trim();
			List phonesList = Arrays.asList(phones);
			
			if(phonesList.contains(formattedName)) 
			{
					j++;
			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
			
			if(j==phones.length)
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	}
}
