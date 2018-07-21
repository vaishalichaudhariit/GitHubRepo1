
import java.text.DateFormatSymbols;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 */

/**
 * @author Vaishali.Chaudhari
 * <p> This method is used to Select any Past or Present or Future Date from a calendar for Talento</p>
 * @param string
 * @return void
 */

public class calendarMethods {
   
	WebDriver driver;
		
	public void talentoDateSelection(String data, WebElement dateIcon) throws InterruptedException
	{
		
		try{
				dateIcon.click();
			    Thread.sleep(2000);

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
       }
	       catch(StaleElementReferenceException e)
	         {
	           	e.toString();
	            System.out.println("Trying to recover from a stale element :" + e.getMessage());
	         }
	}

	

}
