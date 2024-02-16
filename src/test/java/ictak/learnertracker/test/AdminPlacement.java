package ictak.learnertracker.test;

import org.testng.annotations.Test;

import ictak.learnertracker.pages.AdminHome;
import ictak.learnertracker.pages.LearnerDashboard;
import ictak.learnertracker.pages.LearnersForm;
import ictak.learnertracker.pages.Login;
import ictak.learnertracker.pages.PlacementUpdate;

public class AdminPlacement extends SetUpTest {
	AdminHome AH= null;
	Login Adminlogin = null;
	LearnerDashboard  LD= null;
	 LearnersForm LF=null;
	 PlacementUpdate PU=null;
	 @Test (priority=1)
	 public void AdminPlacementStatusUpdate() {
		 AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 PU=new PlacementUpdate(driver);
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Placement();
			 PU.navigateToUpdateDetailsForm("drishya");
			 PU.PlacementStatusUpdate("Job seeking");
			 PU.PlacementSubmit();
			 System.out.println("Successufully update the palcement status of the Learner");
			 
		 
	 }

}
