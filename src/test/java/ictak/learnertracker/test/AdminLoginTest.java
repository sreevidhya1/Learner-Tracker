package ictak.learnertracker.test;



import org.testng.Assert;
import org.testng.annotations.Test;
import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.Login;

public class AdminLoginTest extends SetUpTest{
	Login Adminlogin= null;
	@Test(priority=1)
	public void PositiveTest()   {
		Adminlogin = new Login(driver);
		String actualTitle=Adminlogin.Title();	
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,Contants.ExpectedTitle);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
	
		Adminlogin.MenuDropDown();
		Adminlogin.LogOut();
		
	}
	@Test(priority=2)
	public void Admininvalidusername() {
		Adminlogin = new Login(driver);
		String actualTitle=Adminlogin.Title();	
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,Contants.ExpectedTitle);
		Adminlogin.UserName("Admin");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		Assert.assertEquals(Contants.ExpectedErrorMessage,Adminlogin.ErrorMessage());
	}
	@Test (priority=3)
	 
	public void Admininvalidpasswd() {
		Adminlogin= new Login (driver);
		String actualTitle=Adminlogin.Title();	
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,Contants.ExpectedTitle);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("123");
		Adminlogin.LoginButton();
		Assert.assertEquals(Contants.ExpectedinvalidpasswdErrorMess,Adminlogin.InvalidPasswdErrorMess());
	}
	@Test(priority=4)
	public void Adminblankspace() {
		Adminlogin = new Login(driver);
		String actualTitle=Adminlogin.Title();	
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,Contants.ExpectedTitle);
		Adminlogin.UserName("      ");
		Adminlogin.PassWd("admin@123");
		Adminlogin.LoginButton();
		Assert.assertEquals(Contants.ExpectedErrorMessage,Adminlogin.ErrorMessage());
		
	}
	@Test(priority=5)
public void AdminPasswordBlank() {
		Adminlogin = new Login(driver);
		Adminlogin.UserName("admin");
		Adminlogin.PassWd("           ");
		Adminlogin.LoginButton();
		Assert.assertEquals(Contants.ExpectedinvalidpasswdErrorMess,Adminlogin.InvalidPasswdErrorMess());
	}
	@Test(priority=6)
	public void AdminInvaildUserAndPassword() {
		Adminlogin = new Login(driver);
		Adminlogin.UserName("Admin");
		Adminlogin.PassWd("12345");
		Adminlogin.LoginButton();
		Assert.assertEquals(Contants.ExpectedErrorMessage,Adminlogin.ErrorMessage());
	}
}
