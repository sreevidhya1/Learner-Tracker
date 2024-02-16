package ictak.learnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnerDashboard {
	WebDriver driver;
	public LearnerDashboard(WebDriver driver) {
		this.driver=driver;
	}
	public void AddNewLearner() {
		WebElement addnewlearner = driver.findElement(By.xpath("//ion-icon[@name=\"person-add-outline\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	    wait.until(ExpectedConditions.elementToBeClickable(addnewlearner ));
		addnewlearner.click();
		
	}
	public void AddBulkNewLearner() {
		WebElement addbulklearner = driver.findElement(By.xpath("//ion-icon[@name=\"cloud-upload\"]"));
		addbulklearner.click();
		
	}
    public void SelectThePageNoLearner(String pagenumber) {
    	WebElement pagenumberlearner= driver.findElement(By.xpath("//ul[@class=\"pagination\"]"));
    	Select pgl = new Select (pagenumberlearner);
    	pgl.selectByVisibleText(pagenumber);
    	
    }
    
}
