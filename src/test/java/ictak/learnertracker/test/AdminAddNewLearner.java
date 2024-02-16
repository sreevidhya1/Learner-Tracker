package ictak.learnertracker.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.AdminHome;
import ictak.learnertracker.pages.LearnerDashboard;
import ictak.learnertracker.pages.LearnersForm;
import ictak.learnertracker.pages.Login;

public class AdminAddNewLearner extends SetUpTest {
	AdminHome AH= null;
	Login Adminlogin = null;
	LearnerDashboard  LD= null;
	 LearnersForm LF=null;
	 @Test(priority=1)
	 public void AddNewLearnerwithValidDATA() {
		 AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
		 LD.AddNewLearner();
		 LF.LearnersID("ST-22");
		 LF.LeanerName("Vidhya");
		 LF.LearnerCourse("ST");
		 LF.LearnerProject("NORKA");
		 LF.LearnerBatch("Aug_22");
		 LF.LearnerCourseStatus("Qualified");
		 LF.LearnerSubmitButton();
		 LF.LearnerPopUpMessage();
		 System.out.println("Adding new learner is successfully ");
	 }
   @Test(priority=3)
   public void InvalidLearnerid() {
	   AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
		 LD.AddNewLearner();
		 LF.LearnersID("      ");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedInvalidLearneridmess,LF.InvalidLearnerId());
		 System.out.println("Adding new Leaner is failed beacuse Leanerid field ,Must contain letters,numbers and - only");
   }
   @Test(priority=4)
   public void InvalidLernerName() {
	   AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
		 LD.AddNewLearner();
		 LF.LearnersID("St-22");
		 LF.LeanerName("123455566");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedInvalidLearnerName,LF.InvalidLearnerName());
		 System.out.println("Adding new Learner failed because Leaner name field Must contain letters only");
	   
   }
   @Test(priority=5)
   public void BlankSelectionofCoursefield() {
	   
		   AH= new AdminHome(driver);
			 Adminlogin = new Login(driver);
			 LD= new LearnerDashboard(driver);
			 LF = new LearnersForm(driver);
			 
				Adminlogin.UserName("vidhya");
				Adminlogin.PassWd("admin@123");
				Adminlogin.LoginButton();
				AH.Leaners();
			 LD.AddNewLearner();
			 LF.LearnersID("St-22");
			 LF.LeanerName("jinu");
			 LF.LearnerCourse("     ");
			 LF.LearnerSubmitButton();
	   Assert.assertEquals(Contants.ExpectedinvalidlearnerCourseMess,LF.BlankLearnerCoursemess());
	   System.out.println("Adding new Leaner failed because leaner course field do  not accept blank selection");
	   
   }
   @Test(priority=6)
   public void BlankSelectionOfProjectField() {
	   AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
		 LD.AddNewLearner();
		 LF.LearnersID("St-22");
		 LF.LeanerName("jinu");
		 LF.LearnerCourse("ML-AI");
		 LF.LearnerProject("          ");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedinvalidLearnerProjectMess,LF.BlankLearnerProjectMess());
          System.out.println("Adding new learner failed because learner project field do not accept blank selection");
          
   }
   @Test(priority=7)
   public void BlankSelectionOfLearnerBatch() {
	   AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
		 LD.AddNewLearner();
		 LF.LearnersID("St-22");
		 LF.LeanerName("jinu");
		 LF.LearnerCourse("ML-AI");
		 LF.LearnerProject("ABCD");
		 LF.LearnerBatch("   ");
		 LF.LearnerSubmitButton(); 
		 Assert.assertEquals(Contants.ExpectedblankLearenerBatchMess,LF.BlankLearnerBatchMess());
         System.out.println("Adding New User failed because learner batch field do not accept blank selection");
   }
   @Test(priority=8)
	   public void BlankSelectionOfLearnerCourseStatus() {
		   AH= new AdminHome(driver);
			 Adminlogin = new Login(driver);
			 LD= new LearnerDashboard(driver);
			 LF = new LearnersForm(driver);
			 
				Adminlogin.UserName("vidhya");
				Adminlogin.PassWd("admin@123");
				Adminlogin.LoginButton();
				AH.Leaners();
			 LD.AddNewLearner();
			 LF.LearnersID("St-22");
			 LF.LeanerName("jinu");
			 LF.LearnerCourse("ML-AI");
			 LF.LearnerProject("ABCD");
			 LF.LearnerBatch("Jun_22");
			 LF.LearnerCourseStatus("    ");
			 LF.LearnerSubmitButton(); 
			 Assert.assertEquals(Contants.ExpectedblanklearnerCourseStatusMess,LF.BlankLearnersCourseStatus());
		   
	   }
   @Test(priority=2)
   
  public void AddingBulkLeanerDetailsUsingCSVFile() {
	   AH= new AdminHome(driver);
		 Adminlogin = new Login(driver);
		 LD= new LearnerDashboard(driver);
		 LF = new LearnersForm(driver);
		 
			Adminlogin.UserName("vidhya");
			Adminlogin.PassWd("admin@123");
			Adminlogin.LoginButton();
			AH.Leaners();
			LD.AddBulkNewLearner();
			LF.AddingBulkDetailsOfLearnerByCSVFile("C:\\Users\\abhi8\\Desktop\\Leaners details.csv");
			LF.BulkLearnerSubmitButton();
			LF.BulkAddingAfterBAckToDashboardpopup();
			LF.BulkAddingFilileSavedPopup();
			System.out.println("Adding Bulk details of the new Learner Using .csv File Successfully");
	   
   }
   }
   

