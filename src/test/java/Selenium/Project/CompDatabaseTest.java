package Selenium.Project;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CompDatabaseTest {
	
	WebDriver driver;
	
	@Test
	public void computerBase() {
		driver  = new ChromeDriver();
		ComputerDatabase c = new ComputerDatabase(driver);
		c.goTo();
		c.createComputer("Hello Guhananthan", "1991-10-31", "1995-10-31", "Thinking Machines");
		c.checkAlertMsg();
	}
	
	@AfterTest()
	public void afterTest() {
		driver.quit();
	}

}
