package ictak.learnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver= driver;
	}
	public String Title() 
	{
    	return(driver.getTitle());
	}
	public void UserName(String un) {
		WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(un);
	}
	public void PassWd(String pw) {
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(pw);
		
	}
	public void ShowPassword() {
		WebElement showpwd=driver.findElement(By.xpath("//i[@class='bi bi-eye-slash']"));
		showpwd.click();
		
	}
	public void LoginButton() {
		WebElement loginbut= driver.findElement(By.xpath("//button[@class='btn btn-success w-100']"));
		loginbut.click();
	}
	
	public void MenuIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    WebElement menuIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='navbar-toggler-icon']")));
	    
		//WebElement menuIcon = driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",menuIcon);
		
	}
	public void MenuDropDown() {
		
	    WebElement dropdown = driver.findElement(By.id("basic-nav-dropdown"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
	    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	    // Click on the dropdown menu to reveal the options
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdown);
		
	}
	public void LogOut() {
		
		WebElement logoutOption = driver.findElement(By.xpath("//a[text()='Logout']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(logoutOption));
	    // Click on the dropdown menu to reveal the options
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutOption);
        
	}
	public String ErrorMessage() {
		WebElement actualerrormessage= driver.findElement(By.xpath("//button[@class=\"btn-close\"]/parent::div"));
		return actualerrormessage.getText();
			
		
	}
	public String BlankErrorMessage() {
		WebElement actualblankerrormess = driver.findElement(By.xpath("//div[@class=\"col col-12 col-sm-12 col-md-12 col-lg-12\"]/small[text()='Username is required.']"));
		return actualblankerrormess.getText();
	}
	public String InvalidPasswdErrorMess() {
		WebElement invalidpaswdmess=driver.findElement(By.xpath("//div[@role='alert' and contains(@class, 'alert-danger') and contains(text(), 'Login Failed')]\r\n"
				+ ""));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(invalidpaswdmess));
		
          return 	invalidpaswdmess.getText();
	}
	public String TrainerLoginUrl() 
	{
		
		
		return(driver.getCurrentUrl());
	}
	/*public void DropDownForLogOut() {
		 WebElement menuIcon = driver.findElement(By.xpath("//button[@aria-controls='basic-navbar-nav']"));
		    menuIcon.click();
		    
		    // Wait for the dropdown menu to be visible
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-labelledby='basic-nav-dropdown']")));
		    
		    // Click on the dropdown menu to reveal the options
		    dropdown.click();
		    
		    // Now, locate and click on the logout option based on the provided text
		    WebElement logoutOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
		    logoutOption.click();

		}*/
}
