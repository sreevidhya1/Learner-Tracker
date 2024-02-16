package ictak.learnertracker.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import ictak.learnertracker.contants.Contants;
import ictak.learnertracker.pages.LearnerDashboard;
import ictak.learnertracker.pages.LearnersForm;
import ictak.learnertracker.pages.Login;
import ictak.learnertracker.pages.PlacementUpdate;

public class TrainerAddNewLearner extends SetUpTest{
Login TL= null;
LearnersForm LF=null;
LearnerDashboard  LD= null;
PlacementUpdate UD=null;
	
	@Test(priority=1)
	public void TrainerAddingNewLearnerWithValidData(){
		LD= new LearnerDashboard(driver);
		LF=new LearnersForm(driver);
		TL =new Login(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LD.AddNewLearner();
		 LF.LearnersID("FSD-22");
		 LF.LeanerName("Jinu");
		 LF.LearnerCourse("FSD");
		 LF.LearnerProject("KKEM");
		 LF.LearnerBatch("Jul_22");
		 LF.LearnerCourseStatus("Qualified");
		 LF.LearnerSubmitButton();
		 LF.LearnerPopUpMessage();
		 System.out.println("Adding new learner is successfully ");
	}
	@Test(priority=2)
	public void TrainerAddNewLeanerWithInvalidLearnerid() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		
	   LD.AddNewLearner();
		 LF.LearnersID("      ");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedInvalidLearneridmess,LF.InvalidLearnerId());
		 System.out.println("Adding new Leaner is failed beacuse Leanerid field ,Must contain letters,numbers and - only");
	}
	@Test(priority=3)
	public void TrainerAddNewLeanerWithInvalidLernerName() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LD.AddNewLearner();
		 LF.LearnersID("St-22");
		 LF.LeanerName("123455566");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedInvalidLearnerName,LF.InvalidLearnerName());
		 System.out.println("Adding new Learner failed because Leaner name field Must contain letters only");
		
	}
	@Test(priority=4)
	public void TrainerAddNewLeanerWithBlankSelectionofCoursefield() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LD.AddNewLearner();
		LF.LearnersID("St-22");
		 LF.LeanerName("jinu");
		 LF.LearnerCourse("     ");
		 LF.LearnerSubmitButton();
  Assert.assertEquals(Contants.ExpectedinvalidlearnerCourseMess,LF.BlankLearnerCoursemess());
  System.out.println("Adding new Leaner failed because leaner course field do  not accept blank selection");
	}
	@Test(priority=5)
	public void TrainerAddNewLeanerWithBlankSelectionOfProjectField() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LD.AddNewLearner();
		LF.LearnersID("St-22");
		 LF.LeanerName("jinu");
		 LF.LearnerCourse("ML-AI");
		 LF.LearnerProject("          ");
		 LF.LearnerSubmitButton();
		 Assert.assertEquals(Contants.ExpectedinvalidLearnerProjectMess,LF.BlankLearnerProjectMess());
         System.out.println("Adding new learner failed because learner project field do not accept blank selection");
		
	}
	@Test(priority=6)
	public void TrainerAddNewLeanerWithBlankSelectionOfLearnerBatch() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
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
	@Test(priority=7)
	public void TrainerAddNewLeanerWithBlankSelectionOfLearnerCourseStatus() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
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
	@Test(priority=8)
	public void TrainerAddingBulkLeanerDetailsUsingCSVFile() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LD.AddBulkNewLearner();
		LF.AddingBulkDetailsOfLearnerByCSVFile("C:\\Users\\abhi8\\Desktop\\Leaners details.csv");
		LF.BulkLearnerSubmitButton();
		LF.BulkAddingAfterBAckToDashboardpopup();
		LF.BulkAddingFilileSavedPopup();
		System.out.println("Adding Bulk details of the new Learner Using .csv File Successfully");
	}
	@Test(priority=9)
	public void TrainerUpdateTheDetailsOfLearner() {
		
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LF.updateLearnerDetails("geetha");
		LF.LearnerProject("KKEM");
		 LF.LearnerBatch("Jul_22");
		 LF.LearnerCourseStatus("Qualified");
		 LF.LearnerSubmitButton();
		
		 System.out.println("Successfully Updated ");
	}
	
	@Test(priority=10)
	public void TrainerDeleteTheDetailsOfLearner() {
		LD= new LearnerDashboard(driver);
		TL =new Login(driver);
		LF=new LearnersForm(driver);
		TL.UserName("trainer");
		TL.PassWd("trainer@123");
		TL.LoginButton();
		LF.selectPageNumber(24);
		LF.deleteLearner("geetha");
	}
	
}
