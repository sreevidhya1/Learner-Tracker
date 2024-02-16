package ictak.learnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnersForm {
	WebDriver driver;
	public LearnersForm(WebDriver driver) {
		this.driver=driver;
	}
	
	public void LearnersID(String id) {
		WebElement learnerid = driver.findElement(By.xpath("//input[@name='learnerid']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	    wait.until(ExpectedConditions.elementToBeClickable(learnerid ));
		learnerid.sendKeys(id);
	}
	public void LeanerName(String name) {
		WebElement learnername = driver.findElement(By.xpath("//input[@id=\"name\"]"));
		learnername.sendKeys(name);
		
	}
   public void LearnerCourse(String course) {
	   WebElement learnercourse=driver.findElement(By.xpath("//select[@name=\"course\"]"));
   Select lc = new Select(learnercourse);
   lc.selectByVisibleText(course);
   
   }
   public void LearnerProject(String project) {
	   WebElement learnerproject = driver.findElement(By.xpath("//select[@name='project']"));
	   Select lp= new Select (learnerproject);
	   lp.selectByVisibleText(project);
   }
   public void LearnerBatch(String batch) {
	   WebElement learnerbatch = driver.findElement(By.xpath("//select[@name='batch']"));
	   Select lb= new Select (learnerbatch);
	   lb.selectByVisibleText(batch);
   }
   public void LearnerCourseStatus(String coursestatus) {
	   WebElement learnercoursestatus  = driver.findElement(By.xpath("//select[@name='cstatus']"));
	   Select lcs = new Select (learnercoursestatus);
	   lcs.selectByVisibleText(coursestatus);
	   
   }
   public void LearnerSubmitButton() {
	   WebElement learnersubmitbutton= driver.findElement(By.xpath("//button[text()='Submit']"));
	   learnersubmitbutton.click();
	   
   }
   public void LearnerBackToDashboard() {
	   WebElement  learnerbacktodashboard=driver.findElement(By.xpath("//button[text()='Back to Dashboard']"));
	   learnerbacktodashboard.click();
	   
   }
   public void LearnerPopUpMessage() {
	   WebElement popupmess = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
	   popupmess.click();
	   
   }
   public String InvalidLearnerId() {
	   WebElement invalidlearneridmess= driver.findElement(By.xpath("//p[text()='Must contain letters,numbers and - only']"));
	   return invalidlearneridmess.getText();
   }
   public String InvalidLearnerName() {
	   WebElement invallidlearenrname =driver.findElement(By.xpath("//p[text()='Must contain letters only']"));
	   return invallidlearenrname.getText();   
   }
   public String BlankLearnerCoursemess() {
	   WebElement blanklearnercoursemess= driver.findElement(By.xpath("//p[text()='Please select a course for the learner']"));
	   return blanklearnercoursemess.getText();
	   
   }
   public String BlankLearnerProjectMess() {
	   WebElement blanklearnerprojectmess= driver.findElement(By.xpath("//p[text()='Please select a project for the learner']"));
	   return blanklearnerprojectmess.getText();
   }
   public String BlankLearnerBatchMess() {
	   WebElement blanklearnerbatchmess= driver.findElement(By.xpath("//p[text()='Please select a batch for the learner']"));
	   return blanklearnerbatchmess.getText();
   }
   public String BlankLearnersCourseStatus() {
	   WebElement blanklearnercoursestatusmess = driver.findElement(By.xpath("//p[text()='Please select the course status of the learner']"));
	   return blanklearnercoursestatusmess.getText();
	   
   }
   public void AddingBulkDetailsOfLearnerByCSVFile(String file) {
	   WebElement csvfile= driver.findElement(By.xpath("//input[@accept=\".csv\"]"));
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(csvfile ));
	   csvfile.sendKeys(file);
   }
   public void BulkLearnerSubmitButton() {
	   WebElement bulklearenersubmitbutton= driver.findElement(By.xpath("//button[@class=\"ui grey mini button\"]"));
	   bulklearenersubmitbutton.click();
   }
   public void BulkAddingAfterBAckToDashboardpopup() {
	   WebElement bulkaddingsuccessfulpopup = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
	   bulkaddingsuccessfulpopup.click();
   }
   public void BulkAddingFilileSavedPopup() {
	   WebElement bulkaddingfesavedpopup = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
	   bulkaddingfesavedpopup.click();
   }
   public WebElement findTable() {
       return driver.findElement(By.className("table-responsive")).findElement(By.tagName("table"));
   }

   public WebElement findLearnerById(String learnerId) {
       WebElement table = findTable();
       return table.findElement(By.xpath("//tr[td[contains(text(), '" + learnerId + "')]]"));
   }

   public void updateLearnerDetails(String learnerId) {
       WebElement learnerRow = findLearnerById(learnerId);
       WebElement updateButton = learnerRow.findElement(By.xpath("//button[@class=\"btn btn-success\"]"));
       updateButton.click();
       // Implement logic to update learner details
   }

   public void deleteLearner(String learnerId) {
       WebElement learnerRow = findLearnerById(learnerId);
       WebElement deleteButton = learnerRow.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
       deleteButton.click();
       // Implement logic to delete learner
   }
   public void selectPageNumber(int pageNumber) {
	    // Scroll to the footer to ensure page numbers are in view
	    WebElement footer = driver.findElement(By.tagName("footer"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

	    // Find the page number element and click on it
	    
	    WebElement pageElement = driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li/a[text()='" + pageNumber + "']"));
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(pageElement));
	   
	    driver.close();
	    pageElement.click();
	}
}

