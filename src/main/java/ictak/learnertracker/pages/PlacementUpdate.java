package ictak.learnertracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PlacementUpdate {
	WebDriver driver;
	public PlacementUpdate(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement findLearnerDetailsTable() {
	        return driver.findElement(By.className("table-bordered"));
		}
		public WebElement findLearnerDetails(String learnerName) {
	        WebElement table = findLearnerDetailsTable();
	        return table.findElement(By.xpath("//tbody//tr[td[contains(text(),'" + learnerName + "')]]"));
	    }
		public void navigateToUpdateDetailsForm(String learnerName) {
	        WebElement learnerRow = findLearnerDetails(learnerName);
	        WebElement updateButton = learnerRow.findElement(By.xpath("//button[@class=\"btn btn-success btn btn-primary\"]"));
	        updateButton.click();
	    }
		public void PlacementStatusUpdate(String placement) {
			WebElement placementstatusupdate= driver.findElement(By.xpath("//select[@name=\"pstatus\"]"));
				Select pu= new Select(placementstatusupdate);
			pu.selectByVisibleText(placement);
		}
		public void PlacementSubmit() {
			WebElement palcementsubmit= driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]"));
			palcementsubmit.click();
		}
		
	}


