package ictak.learnertracker.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserForm {
WebDriver driver;
public UserForm(WebDriver driver) {
	this.driver=driver;
}
public void AddNewUser() {
	WebElement addnewuser = driver.findElement(By.xpath("//button[@class=\"mb-3 btn btn-success\"]"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    wait.until(ExpectedConditions.elementToBeClickable(addnewuser));
	addnewuser.click();
	
	
}
public void UserFullName(String uname) {
	WebElement userfullname= driver.findElement(By.xpath("//input[@id='name']"));
	userfullname.sendKeys(uname);	
}
public void UserEmail(String email) {
	WebElement uemail= driver.findElement(By.xpath("//input[@id='email']"));
	uemail.sendKeys(email);
	
}
public void UserName(String uname ) {
	WebElement username= driver.findElement(By.xpath("//input[@id='username']")) ;
	username.sendKeys(uname);
}
public void UserPassword(String upassword) {
	WebElement userpassword=driver.findElement(By.xpath("//input[@id='password']"));
	userpassword.sendKeys(upassword);
}
public void UserRole(String urole) {
	WebElement userrole=driver.findElement(By.xpath("//select[@class='form-select required']"));
    Select role= new Select(userrole);
    role.selectByVisibleText(urole);
    
}
public void UserSubmitButton() {
	WebElement usersubmit= driver.findElement(By.xpath("//button[text()='Submit']"));
	usersubmit.click();
}
public void UserBackToDashboard() {
	WebElement userbtd= driver.findElement(By.xpath("//button[text()='Back to Dashboard']"));
	userbtd.click();
}
public void  UserPopUpMessage()
{
    WebElement userpopupmsg=driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    wait.until(ExpectedConditions.elementToBeClickable(userpopupmsg));
    userpopupmsg.click();

}
public String InvalidFullNameErrormess() {
	WebElement Errormess= driver.findElement(By.xpath("//p[text()='Must contain letters only']"));
	return Errormess.getText();
	
}
public String InvalidEmail() {
     WebElement invaildemail = driver.findElement(By.xpath("//p[text()='Must be a valid Email ID']"))	;
return invaildemail.getText();
}
public String InvalidUserName() {
	WebElement invalidusername = driver.findElement(By.xpath("//p[text()='Must be min 5 characters with alphabets and numbers only']"));
	return invalidusername.getText();
}
public String InvalidUserPasswd() {
	WebElement invaliduserpasswd=driver.findElement(By.xpath("//p[text()='Must be a minimum of 8 characters long and include at least one letter, one special character (@$!%*?&), and one number.']"));
	return invaliduserpasswd.getText();
}
public String  NavigatingToDashboard() {
	return(driver.getCurrentUrl());
}
public boolean isUserDisplayed(String username, String email, String password,  String role) {
    WebElement userRow = driver.findElement(By.xpath("//tr[td[text()='" + username + "'] and td[text()='" + email + "'] and td[text()='" + password + "']  and td[text()='" + role + "']]"));
    return userRow.isDisplayed();
}
public void scrollToHorizontalScrollbar(int index) {
    // Find all elements with horizontal scroll
    java.util.List<WebElement> horizontalScrollbars = driver.findElements(By.xpath("//*[contains(@style, 'overflow-x: auto')]"));

    // Check if the desired index is valid
    if (index >= 0 && index < horizontalScrollbars.size()) {
        WebElement targetScrollbar = horizontalScrollbars.get(index);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(targetScrollbar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", targetScrollbar);
    } else {
        System.out.println("Invalid index or no horizontal scrollbar found at the specified index.");
    }
}
public void scrollToVerticalScrollbar(int index) {
    // Find all elements with vertical scroll
    java.util.List<WebElement> verticalScrollbars = driver.findElements(By.xpath("//*[contains(@style, 'overflow-y: auto')]"));

    // Check if the desired index is valid
    if (index >= 0 && index < verticalScrollbars.size()) {
        WebElement targetScrollbar = verticalScrollbars.get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", targetScrollbar);
    } else {
        System.out.println("Invalid index or no vertical scrollbar found at the specified index.");
    }
}

public void selectPageNumber(int pageNumber) {
    // Scroll to the footer to ensure page numbers are in view
    WebElement footer = driver.findElement(By.tagName("footer"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

    // Find the page number element and click on it
    
    WebElement pageElement = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='" + pageNumber + "']"));
    
    
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    wait.until(ExpectedConditions.elementToBeClickable(pageElement));
   
    driver.close();
    pageElement.click();
}
public WebElement findUserDetails(String username) {
    WebElement userDetails = null;
    // Locate the table
    WebElement table = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]"));
    // Find all rows
    List<WebElement> rows = table.findElements(By.tagName("tr"));
    // Iterate through each row
    for (WebElement row : rows) {
        // Find cells in each row
        List<WebElement> cells = row.findElements(By.tagName("td"));
        // Check if username matches
        if (cells.size() > 0 && cells.get(0).getText().equals(username)) {
            // Found the user, store the row
            userDetails = row;
            break;
        }
    }
    return userDetails;
}
public void navigateToUpdateDetailsForm(WebElement userDetails) {
    // Find the update button in the row
    WebElement updateButton = userDetails.findElement(By.xpath(".//button[contains(text(),'Update')]"));
    // Click on the update button
    updateButton.click();
}
public void scrollElementIntoView(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
}


}
