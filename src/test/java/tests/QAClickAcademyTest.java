package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.Base;
import Main.TestData;
import pageObjects.QAClickAcademyHomePage;

public class QAClickAcademyTest extends Base{
	
      WebDriver driver;
       public static Logger log=LogManager.getLogger(QAClickAcademyTest.class.getName());
       
       @BeforeTest
       public void startup() throws IOException
       {
    	driver=Capabilities();
    	log.info("driver is initialized");
   		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
   		log.info("waiting for 20 seconds in each operation");
   		
       }
	
    @Test(dataProvider="Inputdata",dataProviderClass=TestData.class)   
	public void start(String username,String pass)
	{
    	driver.get(props.getProperty("url"));
     	log.info("getting the url");
    	QAClickAcademyHomePage p=new QAClickAcademyHomePage(driver);
		p.login().click();
		log.info("clicking on the login button");
		p.email().sendKeys(username);
		log.info("entering the email");
		p.pass().sendKeys(pass);
		log.info("entering the password");
		p.value().click();
		log.info("clicking on the login button");
		driver.navigate().back();
		log.info("navigating back to the screen");
		//String text1=p.text1().getText();
		//System.out.println(text1);
//		String text2="Featured Courses";
//		Assert.assertEquals(text1, text2);
		//log.info("checking the text are equal or not.");
	}
    @AfterTest
    public void teardown()
    {
    	driver.close();
    	    }

}
