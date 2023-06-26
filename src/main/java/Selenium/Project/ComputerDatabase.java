package Selenium.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ComputerDatabase {
	
	WebDriver driver;
	
	public ComputerDatabase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="a.btn.success")
	WebElement addComp;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="introduced")
	WebElement introducedEle;
	
	@FindBy(id="discontinued")
	WebElement discontinuedEle;
	
	@FindBy(id="company")
	WebElement compDriv;
	
	@FindBy(css=".btn.primary")
	WebElement createComp;
	
	@FindBy(css=".alert-message.warning")
	WebElement alertMsg;
	
	
	public void goTo()
	{
		driver.get("https://computer-database.gatling.io/computers");
	}

	public void createComputer(String nameValue,String introducedOn,String discontinuedOn,String computers)
	{
		addComp.click();
		name.sendKeys(nameValue);
		introducedEle.sendKeys(introducedOn);
		discontinuedEle.sendKeys(discontinuedOn);
		Select company = new Select(compDriv);
		company.selectByVisibleText(computers);
		createComp.click();
		
	}
	
	public void checkAlertMsg() {
		
		String value = alertMsg.getText().split("Computer")[1].trim().split("has")[0].trim();
		System.out.println(value);
		
		if(value.contains("Guhananthan")) {
			Assert.assertTrue(true);
		}
	}
	
}
