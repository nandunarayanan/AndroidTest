/*****************************************************************************
 * File Name 	: DP_Home_Screen.java
 * 
 * Versn		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Test Scripts
 * 
 * Description	: This .java file is written to test the Home_Screen
 * 				  as part of the scripting. 
 * 
 * Test cases	: DP_Home_Screen_TC_1, DP_Home_Screen_TC_2, DP_Home_Screen_TC_3
 *****************************************************************************/
package test_scripts;
import org.testng.annotations.Test;

/*Inclusion of required libraries*/

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tcsLib.applicationLaunchLib;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import tcsLib.screenshotLib;
import tcsLib.yamlLib;
import utility.ExcelUtils;

/*Db Utils related libraries*/
import tcsLib.dbUtils;
import org.json.simple.JSONObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.Map;
/*Below class contains the test scripts for the Home screen*/
/*TestNG settings for run all the defined test cases*/
public class DP_Home_Screen  
{
	static int count_1 = 0;
	public AppiumDriver<MobileElement> driver;
	JSONObject document;
	
	/*Data provider with excel settings in the name of PatientData*/
	@DataProvider
	public Object[][] PatientData() 
	{
	  try
		{
		  	
			ExcelUtils.setExcelFile("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","Sheet3");			
			Object[][] testObjArray = ExcelUtils.getTableArray("/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/test_data/Test.xlsx","Sheet3");		
			return (testObjArray);	
		}
		
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}	

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_3
	 * 
	 * Test ID	  : TC_3
	 * 
	 * Type		  :(Parameterized/Data Driven/other) Data Driven
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will input the patient data from the
	 * 				excel and verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/
	  @Test(priority = 3, dataProvider = "PatientData", 
			description = "Add Patient details screen testing "
								+ "with dataProvider")
	  public void DP_Home_Screen_TC_3(String sDOB, String sGender, 
			  			String sFather_Name, String sMother_Name) 
	  {
		  
		  count_1++;
		  
		  MobileElement el1 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/txt_title_age");
		  el1.click();
		  screenshotLib.captureScreenshot("DP_Home_Screen_TC_3", driver);
		  MobileElement el2 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_dob");
		  el2.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el18 = (MobileElement) driver.findElementById
					  					("us.drpad.drpadapp:id/rd_male");
			  el18.click();
		  }
		  else
		  {
			  MobileElement el19 = (MobileElement) driver.findElementById
					  				("us.drpad.drpadapp:id/rd_female");
			  el19.click();
		  }

		  MobileElement el19 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_father_name");
		  el19.sendKeys(sFather_Name);
		  MobileElement el20 = (MobileElement) driver.findElementById
				  			("us.drpad.drpadapp:id/edt_mother_name");
		  el20.sendKeys(sMother_Name);
		  
		  screenshotLib.captureScreenshot("DP_Home_Screen_TC_3_"
				  				+ "b4_Complete", driver);
		  if(count_1 == 4)
		  {
			  MobileElement el21 = (MobileElement) driver.findElementById
					  					("us.drpad.drpadapp:id/btn_save");
			  el21.click();
		  }
		  else
		  {
			  MobileElement el22 = (MobileElement) driver.findElementById
					  					("us.drpad.drpadapp:id/btn_cancel");
			  el22.click();
		  }
		  screenshotLib.captureScreenshot("DP_Home_Screen_TC_3_"
		  									+ "Complete", driver);
	  
	  }

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_2
	 * 
	 * Test ID	  : TC_2
	 * 
	 * Type		  :(Parameterized/Data Driven/other) Parameterized
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will input the patient data from the
	 * 				xml and verify the screen functions are working 
	 * 				as per the SRS document. And also verifies the 
	 * 				dependsOnMethods.
	 *************************************************************************/
  @Parameters({"F_name","L_name"})
  @Test(priority = 2, description = "Add Patient screen testing "
  								+ "with parameterized testing",
  				dependsOnMethods = {"DP_Home_Screen_TC_1"})
  public void DP_Home_Screen_TC_2(String F_name, String L_name) 
  {
	  MobileElement el5 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/imgAddPatient");
	  el5.click();
	  MobileElement el26 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/edt_first_name");
	  el26.sendKeys(F_name);
	  MobileElement el27 = (MobileElement) driver.findElementById
			  						("us.drpad.drpadapp:id/edt_lastname");
	  el27.sendKeys(L_name);

	  screenshotLib.captureScreenshot("DP_Home_Screen_TC_2", driver);
	  MobileElement el8 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/btn_done");
	  el8.click();
	  screenshotLib.captureScreenshot("DP_Home_Screen_TC_2_Complete", driver);
  }	

/**************************************************************************
 * Test Name  : DP_Home_Screen_TC_1
 * 
 * Test ID	  : TC_2
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will verify the screen functions are working 
 * 				as per the SRS document
 *************************************************************************/
  @Test(priority = 1, description = "Home screen testing with priority and "
  		+ "description facility")
  public void DP_Home_Screen_TC_1() 
  {
	  /*MobileElement el4 = (MobileElement) driver.findElementById
			  			("us.drpad.drpadapp:id/lv_patient"); */
	MobileElement el4 = (MobileElement) driver.findElementById
	  			((String) (dbUtils.dbGetElement(document, "LoginScreen", "Button" , "e14")));
	  el4.click();
	  MobileElement el5 = (MobileElement) driver.findElementById
			  				("us.drpad.drpadapp:id/imgAddPatient");
	  el5.click();
	  MobileElement el6 = (MobileElement) driver.findElementById
			  				("us.drpad.drpadapp:id/edt_first_name");
	  el6.sendKeys("Test");
	  MobileElement el7 = (MobileElement) driver.findElementById
			  				("us.drpad.drpadapp:id/edt_lastname");
	  el7.sendKeys("01");
	  screenshotLib.captureScreenshot("DP_Home_Screen_TC_1", driver);

	  MobileElement el8 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/btn_cancel");
	  el8.click();
	  screenshotLib.captureScreenshot("DP_Home_Screen_TC_1_Complete", driver);
  }
  /* As per test NG this is the function which will call before the test
	  *  automatically.*/
  @BeforeTest
  public void beforeTest() 
  {
	  try
		{
		  DB db = dbUtils.dbGetDatabase("10.10.196.130", 27017, "MobileAppElementsRepo");
		  DBCollection collection = db.getCollection("App1");
		  dbUtils.InsertJsonData(collection, "/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/utility/test.json");
		  document = dbUtils.dbGetDoument(db,"App1",1, "/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/utility/json_array_output.json");
          	  String text = dbUtils.dbGetElement(document, "LoginScreen", "Button" , "enabled");
		  String e14_element = dbUtils.dbGetElement(document, "LoginScreen", "Button" , "e14");
		  System.out.println("element id :"+e14_element);
	          System.out.println("Text from method: "+text);
		  
		  Map<String, String> map;
		  String path = "/src/AndroidTest/Test_Mobile_Andriod_demo_docker/src/test/java/utility/test.yaml";
		
		  map = yamlLib.yamlRead(path);
		  System.out.println("Path of the config"+map.get("path_config"));
		  driver = applicationLaunchLib.appLaunch(map.get("path_config"),map.get("app_id"));		
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
  }
  /*As per test NG this is the function which will call after the test 
  * automatically.*/
  @AfterTest
  public void afterTest() 
  {
	  try
		{	
			driver.quit();		
		}
		catch(Exception e)
		{
			System.out.println("Error Cause is:- "+e.getCause());
			System.out.println("Error Message is:- "+e.getMessage());
			e.printStackTrace();
		}
  }

}
