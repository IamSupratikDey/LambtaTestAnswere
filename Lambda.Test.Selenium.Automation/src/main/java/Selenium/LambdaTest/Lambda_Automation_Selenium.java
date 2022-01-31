package Selenium.LambdaTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lambda_Automation_Selenium {

	public String username = "supratikdeyece08";
    public String accesskey = "t8SEqVrdXsJRLb9ysp0CvGZdZLoIqWhWgg3JuukXwgX2S9QRHy";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    
    @Parameters(value= {"browser","version","platform"})
    @BeforeClass
    public void setUp(String browser, String version, String platform) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
    }
    
    @Test(priority=1)
    public void Test_Scenario1() throws InterruptedException
    {
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.lambdatest.com/selenium-playground");
    	
    	
        WebElement Demo =  driver.findElement(By.xpath("//*[@id=\'__next\']/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[1]/a"));
        Thread.sleep(1500);
        Demo.click();
        
        String URL = "https://www.lambdatest.com/selenium-playground/simple-form-demo";
        String actual_URL = driver.getCurrentUrl();
        
        Assert.assertEquals(URL, actual_URL);
        
        String Welcome = "Welcome to LambdaTest";
        WebElement Enter_Text = driver.findElement(By.xpath("//*[@id=\'user-message\']"));
        Enter_Text.sendKeys(Welcome);
        Thread.sleep(2000);
        WebElement checked = driver.findElement(By.xpath("//*[@id=\'showInput\']"));
        checked.click();
        Thread.sleep(2000);
        
        WebElement my_msg = driver.findElement(By.xpath("//*[@id=\'message\']"));
        String My_MSG = my_msg.getText();
        Assert.assertEquals(My_MSG,Welcome);      
        
    }
    
    
    
  /* @Test(priority=2)
    public void Test_Scenario2() throws InterruptedException
    {
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
    	
    	
        
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        
        WebElement DEF = driver.findElement(By.xpath("//*[@id=\'rangeSuccess\']"));
        String Def = DEF.getText();
        WebElement real = driver.findElement(By.xpath("//*[@id=\'slider3\']/div/input"));
        
        while(!Def.matches("95"))
        {    
        	Actions builder = new Actions(driver);
        	Action dragAndDrop = builder.clickAndHold(real)
        			.moveToElement(real)
        			.release(real)
        			.build();
        			dragAndDrop.perform();
          Def = DEF.getText();
          Thread.sleep(5000);
        }
        
    }*/
    
   @Test(priority=3)
    public void Test_Scenario3() throws InterruptedException
    {
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
    	
    	
        
        WebElement submit = driver.findElement(By.cssSelector("#seleniumform > div.text-right.mt-20 > button")); 
        submit.click();
        WebElement Name = driver.findElement(By.id("name"));

        String pleasefilloutthisform = Name.getAttribute("required");
        Assert.assertTrue(true, pleasefilloutthisform);
        String errormsg = "Please fill out this field.";
        Assert.assertTrue(true, errormsg);
        Thread.sleep(5000);
       WebElement country = driver.findElement(By.xpath("//*[@id=\'seleniumform\']/div[3]/div[1]/select"));
       country.click();
       driver.findElement(By.cssSelector("#seleniumform > div:nth-child(3) > div.form-group.w-6\\/12.smtablet\\:w-full.pr-20.smtablet\\:pr-0 > select > option:nth-child(238)")).click();
       
       
       WebElement name = driver.findElement(By.xpath("//*[@id=\'name\']"));
       name.sendKeys("Test Lambda");
       Thread.sleep(1000);
       WebElement Email = driver.findElement(By.cssSelector("#inputEmail4")); 
       Email.sendKeys("TestData@gmail.com"); 
       Thread.sleep(1000);
       WebElement password = driver.findElement(By.id("inputPassword4")); 
       password.sendKeys("Test_Lamda#@123");
       Thread.sleep(1000);
       WebElement Company = driver.findElement(By.xpath("//*[@id=\'company\']"));
       Company.sendKeys("Test_Lamda pvt ltd.");
       Thread.sleep(1000);
       WebElement Website  = driver.findElement(By.cssSelector("#websitename")); 
       Website.sendKeys("www.Test_Lamda.com");
       Thread.sleep(1000);		
       WebElement City = driver.findElement(By.id("inputCity")); 
       City.sendKeys("Earth");
       Thread.sleep(1000);
       WebElement Address1 = driver.findElement(By.xpath("//*[@id=\'inputAddress1\']"));
       Address1.sendKeys("Earth_Air");
       Thread.sleep(1000);
       WebElement Address2 = driver.findElement(By.cssSelector("#inputAddress2")); 
       Address2.sendKeys("Earth Water");
       Thread.sleep(1000);
       WebElement state = driver.findElement(By.id("inputState"));
       state.sendKeys("Test_Lamda State");
       Thread.sleep(1000);
       WebElement Zipcode =  driver.findElement(By.xpath("//*[@id=\'inputZip\']"));
       Zipcode.sendKeys("111111");
       Thread.sleep(1000);
       
       submit.click();
       String submit_msg = "Thanks for contacting us, we will get back to you shortly.";
       String actual_submit = driver.findElement(By.xpath("//*[@id=\'__next\']/div[1]/section[3]/div/div/div[2]/div/p")).getText();
       Assert.assertEquals(actual_submit, submit_msg);
       
       Thread.sleep(5000);
       driver.close();
	
	
    }
   
   
}
