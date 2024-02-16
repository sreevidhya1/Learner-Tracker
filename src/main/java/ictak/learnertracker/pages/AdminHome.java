package ictak.learnertracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHome {
WebDriver driver;

public AdminHome(WebDriver driver) {
	this.driver = driver;
			
}

public void User() {
	WebElement user=driver.findElement(By.xpath("//span[text()=\"Users\"]"));
	user.click();
}
public void Leaners() {
	WebElement learn = driver.findElement(By.xpath("//span[text()='Learners']"));
	learn.click();
	
}
public void Placement () {
	WebElement place= driver.findElement(By.xpath("//span[text()='Placement']"));
	place.click();
}
public void UserUpdateButton(String locatename) {
	WebElement locate=driver.findElement(By.xpath("//tr[td[contains(text(),'\" + username + \"')]]"));
	locate.sendKeys(locatename);
	WebElement updatebutton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	updatebutton.click();

}
public void UserDeleteButton (String locatename) {
	WebElement  locate=driver.findElement(By.xpath("//tr[td[contains(text(),'\" + username + \"')]]"));
     locate.sendKeys(locatename);
	WebElement deletebutton= driver.findElement(By.xpath("//button[@class=\"btn btn-danger btn btn-primary\"]"));
     deletebutton.click();
     
}




}

