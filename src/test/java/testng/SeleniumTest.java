package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static WebDriver d=null;
	
	
	public  void mainTest(String[] args) {
			
		try {
			System.setProperty("webdriver.chrome.driver","C:\\JavaLearning\\SeleniumAssignment\\chromedriver.exe");
			d=new ChromeDriver();
			d.get("http://demo-store.seleniumacademy.com/customer/account/create/");
			enterOtherMandatoryValues();
			enterPassword("Googl");
			submitApplication();
			validateErrorMessage();
			enterPassword("Google@123");
			submitApplication();
			validateSuccessfullRegistration("Hemant","Kumar","Girewal");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			d.quit();
		}
	

	}
	
	private static void validateSuccessfullRegistration(String firstName,String middleName,String lastName) {
		// TODO Auto-generated method stub
		if(d.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Madison Island.')]")).isDisplayed()) {
			System.out.println("Successfully Registered To Mainland Site");
		}
		else {
				System.out.println("Failed To Registere To Mainland Site");
			}		
		
		
		String helloString="Hello, "+firstName+" "+middleName+" "+lastName+"!";
				
		if(d.findElement(By.xpath("//*[text()='"+helloString+"']")).isDisplayed()) {
			System.out.println("Hello With First And Last name Displayed");
		}
		else {
				System.out.println("Hello With First And Last name Not Displayed: Failed ");
			}		
						

		
	}

	private static void validateErrorMessage() {
		// TODO Auto-generated method stub
		if(d.findElement(By.xpath("//div[contains(text(),'Please enter 6 or more characters')]")).isDisplayed()) {
			System.out.println("Error Message Displayed For Wrong Password Field");
		}
		else {
				System.out.println("No Error Message Displayed For Wrong Password Field");
			}
	}

	public static void enterPassword(String password) {
		try {
			d.findElement(By.id("password")).clear();
			d.findElement(By.id("password")).sendKeys(password);
			d.findElement(By.id("confirmation")).clear();
			d.findElement(By.id("confirmation")).sendKeys(password);
			System.out.println("Entered Password And Confirm Password As : "+password );
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}catch(NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void enterOtherMandatoryValues() throws InterruptedException {
		try {
			d.findElement(By.id("firstname")).sendKeys("Hemant");
			d.findElement(By.id("middlename")).sendKeys("Kumar");
			d.findElement(By.id("lastname")).sendKeys("Girewal");
			d.findElement(By.id("email_address")).sendKeys("hkg3@Gmail.com");
			System.out.println("Entered All Other Mandatory Values");
			Thread.sleep(5000);
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}catch(NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void submitApplication() {
		try {
			d.findElement(By.xpath("//button[@title='Register']")).submit();
			System.out.println("Clciked On Register Button ");
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}catch(NotFoundException e) {
			e.printStackTrace();
		}
	}

}