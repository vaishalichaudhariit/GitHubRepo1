import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;



public class captureScreenShot {

	WebDriver driver;
	/*File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("D:\\SaveScreenShot.png"));*/
	
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("c:\\screenshot.png");
	//FileUtils.copyFile(screenshot, destination);
}
