package ictak.learnertracker.test;

import org.testng.Assert;
import org.testng.annotations.Test;


import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.Login;
import ictak.learnertracker.pages.UserForm;


public class AddUserAdmin extends SetUpTest{
	Login Adminlogin = null;
	UserForm	UF= null;
	@Test(priority=1)
	public void AdminAddUser() {
		UF =new UserForm(driver);
		Adminlogin = new Login(driver);
		Adminlogin.UserName("vidhya");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		
		UF.AddNewUser();
		UF.UserFullName("Vidhya");
		UF.UserEmail("sree@gmail.com");
	    UF.UserName("sree123");
	    UF.UserPassword("sree@123");
	    UF.UserRole("Admin");
	    UF.UserSubmitButton();
	    UF.UserPopUpMessage();	
	    System.out.println("New User Added successfully");
	}
	@Test(priority=2)
	public void FullNameNumeric() {
		UF =new UserForm(driver);
		Adminlogin = new Login(driver);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		UF.AddNewUser();
		UF.UserFullName("12345");
		UF.UserEmail("sree@gmail.com");
	    UF.UserName("sree123");
	    UF.UserPassword("sree@123");
	    UF.UserRole("Admin");
	    UF.UserSubmitButton();
	    Assert.assertEquals(Contants.ExpectedInvalidUserFullNameErrorMess,UF.InvalidFullNameErrormess());
	    System.out.println("Update failed because Fullname Field only accept Alphabets");
		
	}
	@Test(priority=3)
	public void InvaidEmail() {
		UF =new UserForm(driver);
		Adminlogin = new Login(driver);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		UF.AddNewUser();
		UF.UserFullName("vidhya");
		UF.UserEmail("ajhfgeu");
		UF.UserSubmitButton();
		Assert.assertEquals(Contants.ExpectedInvalidUserEmailErrormes,UF.InvalidEmail());
		System.out.println("Adding new user failed beacuse Email field only accept vaild email id ");	
	}
	@Test(priority=4)
	public void IvaildUsername() {
		UF =new UserForm(driver);
		Adminlogin = new Login(driver);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		UF.AddNewUser();
		UF.UserFullName("vidhya");
		UF.UserEmail("vidya@gmail.com");
		UF.UserName("sree");
		UF.UserSubmitButton();
		Assert.assertEquals(Contants.ExpectedInvalidUsernameErrorMEss,UF.InvalidUserName());
		System.out.println("Adding new user is failed User name field Must be min 5 characters with alphabets and numbers only");
	}
	@Test (priority=5)
	public void InvalidUserPassword() {
		UF =new UserForm(driver);
		Adminlogin = new Login(driver);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		UF.AddNewUser();
		UF.UserFullName("vidhya");
		UF.UserEmail("vidya@gmail.com");
		UF.UserName("sree123");
		UF.UserPassword("sree123");
		UF.UserSubmitButton();
		Assert.assertEquals(Contants.ExpectedInvalidUserPassword,UF.InvalidUserPasswd());
		System.out.println("Adding new user is failed Password field Must be a minimum of 8 characters long and include at least one letter, one special character (@$!%*?&), and one number.");
	    UF.UserBackToDashboard();
	    String actualurl1=UF.NavigatingToDashboard();
		Assert.assertEquals(actualurl1,Contants.NavigatingToDashboardurl);
		System.out.println("Navigate to the User Dashboard");
		
	}
	
	 @Test(priority=6)
	    public void testUserDetailsDisplayed() {
		 UF =new UserForm(driver);
			Adminlogin = new Login(driver);
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
		     UF.findUserDetails("vidhya"); 
		     UF.selectPageNumber(287);
	        String username = "Vidhya";
	        String email = "sree@gmail.com";
	        String password = "sree123";
	      
	        String role = "Admin";

	        Assert.assertTrue(UF.isUserDisplayed(username, email, password,  role), "User details are displayed in the dashboard.");
	    }

	
}
