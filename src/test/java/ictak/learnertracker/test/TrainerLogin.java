package ictak.learnertracker.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.Login;

public class TrainerLogin extends SetUpTest  {
	Login TL= null;
	
	@Test(priority=1)
	public void TrainerLoginWithValidData()throws IOException, InterruptedException {
		TL =new Login(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		Thread.sleep(500);
		Assert.assertEquals(TL.TrainerLoginUrl(),Contants.ExpectedTrainerLoginUrl);
	}
	@Test(priority=2)
	public void TrainerLoginWithInavaildUserName() {
		TL =new Login(driver);
		TL.UserName("areeebh");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		Assert.assertEquals(TL.ErrorMessage(),Contants.ExpectedErrorMessage);
		
	}
	@Test(priority=3)
	public void TrainerLoginWithInvalidPasswd() {
		TL =new Login(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer123");
		TL.LoginButton();
		Assert.assertEquals(TL.InvalidPasswdErrorMess(),Contants.ExpectedinvalidpasswdErrorMess);
		
	}
	@Test(priority=4)
	public void TrainerLoginWithBlankUsername() {
		TL =new Login(driver);
		TL.UserName("         ");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		Assert.assertEquals(TL.ErrorMessage(),Contants.ExpectedErrorMessage);
		
	}
	@Test(priority=5)
	public void TrainerLoginWithBlankPasswd() {
		TL =new Login(driver);
		TL.UserName("trainer");
		TL.PassWd("        ");
		TL.LoginButton();
		Assert.assertEquals(TL.InvalidPasswdErrorMess(),Contants.ExpectedinvalidpasswdErrorMess);
		
	}
	@Test(priority=6)
	public void TrainerLoginWithINVALIDUsernameAndPAsswd() {
		TL =new Login(driver);
		TL.UserName("bhwgd");
		TL.PassWd(" chsdweud");
		TL.LoginButton();
		Assert.assertEquals(TL.ErrorMessage(),Contants.ExpectedErrorMessage);
		
	}

}
