import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test1 {
	
	
	
	 public static void rightClick(WebDriver driver,WebElement element) {
	        try {
	        	System.out.println("hello");
	            Actions action = new Actions(driver).contextClick(element);
	            action.build().perform();

	            System.out.println("Sucessfully Right clicked on the element");
	        
	        } catch (NoSuchElementException e) {
	            System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element is not attached to the page document " + e.getStackTrace());
	        } catch (Exception e) {
	            System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver1;
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("http://sbvd-app-02:8093/#/");
		
	   	WebElement loginBtn = driver1.findElement(By.xpath(" //button[@id='register']"));
		rightClick(driver1,loginBtn);
	}

}
