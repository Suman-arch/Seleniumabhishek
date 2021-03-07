package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAClickAcademyHomePage {

	public WebDriver driver;
	
	public QAClickAcademyHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login=By.xpath("//span[text()='Login']");
	
	//By login=By.cssSelector("a[href='sign_in']");
	
	By email=By.xpath("//input[@type='email']");
	
	By pass=By.xpath("//input[@type='password']");
		
	By value=By.xpath("//input[@value='Log In']");
	
	By text1=By.xpath("//*[text()='Featured Courses']");
	
    public WebElement login()
    {
    	return driver.findElement(login);
    }
    
    public WebElement email()
    {
    	return driver.findElement(email);
    }
    
    public WebElement pass()
    {
    	return driver.findElement(pass);
    }
    
    public WebElement value()
    {
    	return driver.findElement(value);
    }

    public WebElement text1()
    {
    	return driver.findElement(text1);
    }
}
