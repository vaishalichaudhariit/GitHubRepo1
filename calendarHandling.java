import java.text.DateFormatSymbols;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class calendarHandling {

	public static void main(String[] args){
		try {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://sbvd-app-02:8093/#/");
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		//span[@class='mydpicon icon-mydpcalendar']
	    WebElement userName = driver.findElement(By.xpath("//input[@id='eXinputUserName']"));
	    userName.sendKeys("vpawar");
	    WebElement password = driver.findElement(By.xpath("//input[@id='eXinputPassword']"));
	    password.sendKeys("Passw0rd");
 
	    WebElement loginBtn = driver.findElement(By.xpath(" //button[@id='register']"));
	    loginBtn.click();
	    Thread.sleep(10000);
		WebElement menu = driver.findElement(By.xpath("//*[@id='nav-header']/nav/a"));
	    menu.click();
	    WebElement icon = driver.findElement(By.xpath("//li[@class='treeview menu-access EmployeeOnBoarding']/a"));
	    icon.click();
	    WebElement searchEmp = driver.findElement(By.xpath("//li[@class='menu-access SearchEmployee']"));
	    searchEmp.click();

	    Thread.sleep(10000);
	    WebElement emailSE = driver.findElement(By.xpath("//tr[@class='ui-state-default']//span[text()='Email']/following::input[1]"));
	    emailSE.sendKeys("isha@shinde.com");
	    Thread.sleep(5000);
	    WebElement iconSE = driver.findElement(By.xpath("//md-icon[@class='mat-icon material-icons']"));
	    iconSE.click();
	    Thread.sleep(7000);
	    WebElement menuEditEmp = driver.findElement(By.xpath("//div[@id='cdk-overlay-1']/div/div/button[2]/div[@class='mat-menu-ripple mat-ripple']"));
	    menuEditEmp.click();
	    Thread.sleep(7000);
	    WebElement generalTab = driver.findElement(By.xpath("//div[@id='headingOne']"));
	    if (generalTab. isEnabled())
	    {
		    generalTab.click();
		    Thread.sleep(2000);
	    }
	  //  WebElement dateIcon = driver.findElement(By.xpath("//*[@id='collapseOne']/div/div[12]/div[1]/my-date-picker/div/div/div/button[2]/span"));
	    WebElement dateIcon = driver.findElement(By.xpath("//label[text()='Date Of Joining']/following::button[2]"));
	    
	    //label[text()='Last Day Date']/following::button[2]
	    //label[text()='Last Day Date']/following::button[@aria-label='Open Calendar'][1] 
	    //label[text()='Start Date']/following::button[@aria-label='Open Calendar'][1]
	    //label[text()='Start Date']/following::button[2]
	
	    dateIcon.click();
	    Thread.sleep(2000);
	    String data = "13/01/2018";
	    String strMonth = "invalid";
	  //split the date into Days, Month and Year.
    	String[] dateArr=data.split("/");
    	String strYear = dateArr[2];
      
       	System.out.println("Year:- " + strYear);
    	int intMonth=Integer.valueOf(dateArr[1]); 
      	System.out.println("Month:- " + intMonth);
   	    DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
      	    if (intMonth >= 0 && intMonth <= 11 ) {
      	    	strMonth = months[intMonth-1];
      	    }
      	System.out.println("Month:- " + strMonth);
      	
      	driver.findElement(By.xpath("//div[@class='headeryeartxt']")).click();      
      	Thread.sleep(5000);
      	WebElement yearTextBox = driver.findElement(By.xpath("//div[@class='headeryeartxt']//input[@type='text']"));
      	yearTextBox.clear();
	    yearTextBox.sendKeys(strYear);
	    driver.findElement(By.xpath("//div[@class='headermonthtxt']")).click(); 
	    Thread.sleep(5000);
	    WebElement monthTextBox = driver.findElement(By.xpath("//div[@class='headermonthtxt']//input[@type='text']"));
	    monthTextBox.clear();
	    monthTextBox.sendKeys(strMonth);
	    
	    List<WebElement> DateSelect=driver.findElements(By.xpath("//td[@class='daycell currmonth tablesingleday']"));
    	for(int a=0; a<DateSelect.size(); a++)
    	{
    		int getdate=Integer.valueOf(DateSelect.get(a).getText().toString());
    			
    		if(getdate==(Integer.valueOf(dateArr[0])))
    		{
    			System.out.println("getdate:- " +getdate);
    			System.out.println("App date:- " +dateArr[0]);
    			DateSelect.get(a).click();
    			break;
    		}
    	}
	    
      	
	    Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
