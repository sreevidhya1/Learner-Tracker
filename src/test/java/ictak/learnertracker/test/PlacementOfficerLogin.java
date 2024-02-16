package ictak.learnertracker.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.Login;
import ictak.learnertracker.pages.PlacementUpdate;

public class PlacementOfficerLogin extends SetUpTest{
	Login PL=null;
	PlacementUpdate PU=null;
	@Test(priority=1)
	public void PlacementOfficerLoginWithVaildValue() {
		PL = new Login(driver);
		PL.UserName("pofficer");
		PL.PassWd("pofficer@123");
        PL.LoginButton();
        
	}
	@Test(priority=2)
	public void POffierLoginWithInvalidUsername() {
		PL = new Login(driver);
		PL.UserName("placement");
		PL.PassWd("pofficer@123");
        PL.LoginButton();
        Assert.assertEquals(PL.ErrorMessage(),Contants.ExpectedErrorMessage);
        
	}
	@Test(priority=3)
	public void POfficerLoginWithInvalidPasswd() {
		PL = new Login(driver);
		PL.UserName("pofficer");
		PL.PassWd("Pofficer");
        PL.LoginButton();
        Assert.assertEquals(PL.InvalidPasswdErrorMess(),Contants.ExpectedinvalidpasswdErrorMess);
        
	}
	@Test(priority=4)
	public void POfficerLoginWithBlankUsername() {
		PL = new Login(driver);
		PL.UserName("       ");
		PL.PassWd("pofficer@123");
        PL.LoginButton();
        Assert.assertEquals(PL.ErrorMessage(),Contants.ExpectedErrorMessage);
        
	}
	@Test(priority=5)
	public void POfficerLoginWithBlankPasswd() {
		PL = new Login(driver);
		PL.UserName("pofficer");
		PL.PassWd("");
        PL.LoginButton();
        Assert.assertEquals(PL.InvalidPasswdErrorMess(),Contants.ExpectedinvalidpasswdErrorMess);
        
	}
	@Test(priority=6)
	public void POfficerLoginWithInvalidUserNameAndPasswd() {
		PL = new Login(driver);
		PL.UserName("pofficer");
		PL.PassWd("vyfyrsr");
        PL.LoginButton();
        Assert.assertEquals(PL.InvalidPasswdErrorMess(),Contants.ExpectedinvalidpasswdErrorMess);
        
	} 
	@Test(priority=7)
	public void POfficerUpdateThePlacementStatusOfLeaner() {
		PU=new PlacementUpdate(driver);
		PL = new Login(driver);
		PL.UserName("pofficer");
		PL.PassWd("pofficer@123");
        PL.LoginButton();
        PU.findLearnerDetailsTable();
        PU.findLearnerDetails("Karthika");
        PU.navigateToUpdateDetailsForm("Karthika");
        PU.PlacementStatusUpdate("Job seeking");
        PU.PlacementSubmit();
        
	}
	
	

}
