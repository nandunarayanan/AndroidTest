/*****************************************************************************
 * File Name 	: DP_Home_Screen.java
 * 
 * Version		: 0.1
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
import org.testng.asserts.Assertion;

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

import static org.testng.Assert.assertEquals;

import java.util.Map;

/*Below class contains the test scripts for the Home screen*/
/*TestNG settings for run all the defined test cases*/
public class DP_Home_Screen  
{
	static int count_1 = 0;
	public AppiumDriver<MobileElement> driver;
	
	/*Data provider with excel settings in the name of PatientData*/
	@DataProvider
	public Object[][] PatientData() 
	{
	  try
		{
		  	
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\"
					+ "Test_DP_Mobile_App\\src\\test\\java\\test_data"
					+ "\\Test.xlsx","Sheet3");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse"
					+ "\\Workspace\\Test_DP_Mobile_App\\src\\test\\java\\"
					+ "test_data\\Test.xlsx","Sheet3");		
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
	
	/*Data provider with excel settings in the name of PatientData*/
	@DataProvider
	public Object[][] PatientData1() 
	{
	  try
		{
		  	
			ExcelUtils.setExcelFile("E:\\Eclipse\\Workspace\\"
					+ "Test_DP_Mobile_App\\src\\test\\java\\test_data"
					+ "\\Test.xlsx","Sheet1");			
			Object[][] testObjArray = ExcelUtils.getTableArray("E:\\Eclipse"
					+ "\\Workspace\\Test_DP_Mobile_App\\src\\test\\java\\"
					+ "test_data\\Test.xlsx","Sheet1");		
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
	 * Test Name  : DP_Home_Screen_TC_4
	 * 
	 * Test ID	  : TC_4
	 * 
	 * Type		  :(Parameterized/Data Driven/other) other
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/

	  @Test(priority = 2, description = "Add Patient screen testing "
	  								+ "with parameterized testing",
	  								enabled = false)  //dependsOnMethods = {"DP_Home_Screen_TC_4", "DP_Home_Screen_TC_5"}
	  public void DP_Home_Screen_TC_5()
    {
		  count_1++;
		 // MobileElement el5 = (MobileElement) driver.findElementById
					//("us.drpad.drpadapp:id/lv_patient");
		  //el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/imgAddPatient");
		  el15.click();
		  MobileElement el26 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/edt_first_name");
		  el26.sendKeys("Test");
		  MobileElement el27 = (MobileElement) driver.findElementById
								("us.drpad.drpadapp:id/edt_lastname");		  
		  String L_name = String.valueOf(count_1);
		  el27.sendKeys(L_name);
		
		  MobileElement el8 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/btn_done");
		  el8.click();

    }

	/**************************************************************************
	 * Test Name  : DP_Home_Screen_TC_4
	 * 
	 * Test ID	  : TC_4
	 * 
	 * Type		  :(Parameterized/Data Driven/other) other
	 * 
	 * Group	  :(Smoke/Sanity/Regression) Regression
	 * 
	 * Description: This test case will verify the screen functions are working 
	 * 				as per the SRS document
	 *************************************************************************/
	  @Test(priority = 4, dataProvider = "PatientData1", description = "Home screen testing with priority and "
  		+ "description facility", enabled = false)
    public void DP_Home_Screen_TC_4(String sDOB, String sGender, 
  						String sFather_Name, String sMother_Name,
  						String sAddr, String sPh, String sAPh, String sEmail,
  						String sBT, String sHT, String sWT, String sOccu,
  						String sCom)
    {
		  count_1++;
		  MobileElement el5 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/lv_patient");
		  el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
	  				("us.drpad.drpadapp:id/imgAddPatient");
		  el15.click();
		  MobileElement el26 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/edt_first_name");
		  el26.sendKeys("Test");
		  MobileElement el27 = (MobileElement) driver.findElementById
								("us.drpad.drpadapp:id/edt_lastname");		  
		  String L_name = String.valueOf(count_1);
		  el27.sendKeys(L_name);
		
		  MobileElement el8 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/btn_done");
		  el8.click();

		  MobileElement el1 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/txt_title_age");
		  el1.click();
		  MobileElement el12 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_dob");
		  el12.sendKeys(sDOB);
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
		  MobileElement el21 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/btn_save");
		  el21.click();

		  System.out.println("Contains:..... "+ driver.getPageSource().contains(sFather_Name));
		  assertEquals(true, driver.getPageSource().contains(sFather_Name));
		  
		  MobileElement el01 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_title_address");
		  el01.click();
		  MobileElement el02 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_address");
		  el02.click();
		  el02.sendKeys(sAddr);
		  MobileElement el113 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_phone");
		  el113.sendKeys(sPh);
		  MobileElement el4 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_alt_phone");
		  el4.sendKeys(sAPh);
		  MobileElement el115 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_email");
		  el115.sendKeys(sEmail);
		  MobileElement el6 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/btn_save");
		  el6.click();
		  MobileElement el7 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_title_motes");
		  el7.click();
		  MobileElement el18 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_bloodtype");
		  el18.sendKeys(sBT);
		  MobileElement el9 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_weight");
		  el9.clear();
		  MobileElement el10 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_weight");
		  el10.sendKeys(sWT);
		  MobileElement el11 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_hieght");
		  el11.sendKeys(sHT);
		  MobileElement el112 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_company");
		  el112.sendKeys(sCom);
		  MobileElement el13 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/edt_occupation");
		  el13.sendKeys(sOccu);
		  driver.hideKeyboard();
		  MobileElement el14 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/btn_save");
		  el14.click();
		  try
		  {
			  System.out.println("sFather_Name: "+sFather_Name);
			  System.out.println("Contains: "+ driver.getPageSource().contains(sFather_Name));

			  screenshotLib.captureScreenshot("DP_Home_Screen_TC_4_"
					  				+ "b4_Err", driver);
			  assertEquals(true, driver.getPageSource().contains(sFather_Name));
			  assertEquals(true, driver.getPageSource().contains(sMother_Name));
			  assertEquals(true, driver.getPageSource().contains(sAddr));
			  assertEquals(true, driver.getPageSource().contains(sPh));
			  assertEquals(true, driver.getPageSource().contains(sAPh));
			  assertEquals(true, driver.getPageSource().contains(sBT));
			  assertEquals(true, driver.getPageSource().contains(sWT));
			  assertEquals(true, driver.getPageSource().contains(sHT));
			  assertEquals(true, driver.getPageSource().contains(sCom));
			  assertEquals(true, driver.getPageSource().contains(sOccu));
		  }
		  catch(Exception e)
			{
				System.out.println("Error Cause is:- "+e.getCause());
				System.out.println("Error Message is:- "+e.getMessage());
				e.printStackTrace();
			}
		  MobileElement el04 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/ic_clinic");
		  el04.click();
		  el04.click();
		  MobileElement el2 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_home");
		  el2.click();
		  
		//assertEquals();
		  
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
								+ "with dataProvider", enabled = false)
	  public void DP_Home_Screen_TC_3(String sDOB, String sGender, 
			  			String sFather_Name, String sMother_Name) 
	  {
		  count_1++;
		  MobileElement el5 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/lv_patient");
		  el5.click();
		  MobileElement el15 = (MobileElement) driver.findElementById
	  				("us.drpad.drpadapp:id/imgAddPatient");
		  el15.click();

		  MobileElement el126 = (MobileElement) driver.findElementById
					("us.drpad.drpadapp:id/edt_first_name");
		  el126.sendKeys("Test");
		  MobileElement el127 = (MobileElement) driver.findElementById
								("us.drpad.drpadapp:id/edt_lastname");
		  String L_name = String.valueOf(count_1);
		  el127.sendKeys(L_name);
		
		  MobileElement el118 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/btn_done");
		  el118.click();
		  MobileElement el1 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/txt_title_age");
				  el1.click();

		  MobileElement el112 = (MobileElement) driver.findElementById
				  				("us.drpad.drpadapp:id/edt_dob");
		  el112.sendKeys(sDOB);
		  System.out.println("sDOB: "+sDOB);
		  if(sGender.equalsIgnoreCase("Male"))
		  {
			  MobileElement el1118 = (MobileElement) driver.findElementById
					  					("us.drpad.drpadapp:id/rd_male");
			  el1118.click();
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
			  
		  MobileElement el21 = (MobileElement) driver.findElementById
				  					("us.drpad.drpadapp:id/btn_save");
		  el21.click();
		//  assertEquals(true, driver.getPageSource().contains(sDOB));
		  try
		  {
			  assertEquals(true, driver.getPageSource().contains(sFather_Name));
			  assertEquals(true, driver.getPageSource().contains(sMother_Name));
		  }
		  catch(Exception e)
			{
				System.out.println("Error Cause is:- "+e.getCause());
				System.out.println("Error Message is:- "+e.getMessage());
				e.printStackTrace();
			}
		  MobileElement el04 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/ic_clinic");
		  el04.click();
		  el04.click();
		  MobileElement el2 = (MobileElement) driver.findElementById("us.drpad.drpadapp:id/txt_home");
		  el2.click();
			  
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
  				dependsOnMethods = {"DP_Home_Screen_TC_1"}, enabled = false)
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

	  MobileElement el8 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/btn_done");
	  el8.click();
	  
	  MobileElement el9 = (MobileElement) driver.findElementById
							("us.drpad.drpadapp:id/ic_clinic");
	  el9.click();
	  
	  assertEquals(true, driver.getPageSource().contains(F_name));
	  assertEquals(true, driver.getPageSource().contains(L_name));
  }	

/**************************************************************************
 * Test Name  : DP_Home_Screen_TC_1
 * 
 * Test ID	  : TC_1
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will verify the screen functions are working 
 * 				as per the SRS document
 *************************************************************************/
  @Test(priority = 1, description = "Home screen testing with priority and "
  		+ "description facility", enabled = false)
  public void DP_Home_Screen_TC_1() 
  {

	  MobileElement el4 = (MobileElement) driver.findElementById
			  			("us.drpad.drpadapp:id/lv_patient");
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

	  MobileElement el8 = (MobileElement) driver.findElementById
			  					("us.drpad.drpadapp:id/btn_cancel");
	  el8.click();
	  
	  //Need to check the screen verification call
	  assertEquals(true,true);
  }
  

/**************************************************************************
 * Test Name  : DP_Home_Screen_TC_0
 * 
 * Test ID	  : TC_0
 * 
 * Type		  :(Parameterized/Data Driven/other) other
 * 
 * Group	  :(Smoke/Sanity/Regression) Regression
 * 
 * Description: This test case will verify the screen functions are working 
 * 				as per the SRS document
 *************************************************************************/
  @Test(priority = 0, description = "Home screen testing with priority and "
  		+ "description facility",enabled = false)
  public void DP_Home_Screen_TC0() 
  {
	  //Need to check the screen verification call
	  assertEquals(true,true);
  }
  /* As per test NG this is the function which will call before the test
	  *  automatically.*/
  @BeforeTest
  public void beforeTest() 
  {
	  try
		{
		  Map<String, String> map;
		  String path = "E:\\Eclipse\\Workspace\\Test_DP_Mobile_App\\src"
		   + "\\test\\java\\utility\\test.yaml";
		
		  map = yamlLib.yamlRead(path);
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
