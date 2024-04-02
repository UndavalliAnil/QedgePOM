package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.AddCustomerPage;
import conFig.AppUtils;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtils

{
	String inputpath = "./FileInput/CustomerData.xlsx";
	String outputpath = "./FileOutput/AddCustomer_Results.xlsx";
	String Sheetname ="CustomerDetails";
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@Test
	public void startTest() throws Throwable {
		
		report = new ExtentReports("./target/Extentreports/CustomerResults.html");
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//no of rows in excel sheet
		int rc = xl.rowCount(Sheetname);
		Reporter.log("No of rows:: "+rc,true);
		
		
		
		
		for(int i =1;i<=rc;i++)
		{
			logger = report.startTest("Customer validation");
			logger.assignAuthor("UndavalliSaiAnil");
			String Cname=xl.getCellData(Sheetname, i, 0);
			String Address=xl.getCellData(Sheetname, i, 1);
			String city=xl.getCellData(Sheetname, i, 2);
			String country=xl.getCellData(Sheetname, i, 3);
			String Cperson=xl.getCellData(Sheetname, i, 4);
			String Pnumber=xl.getCellData(Sheetname, i, 5);
			String Email=xl.getCellData(Sheetname, i, 6);
			String Mnumber=xl.getCellData(Sheetname, i, 7);
			String Notes=xl.getCellData(Sheetname, i, 8);
			AddCustomerPage cuspage=PageFactory.initElements(driver, AddCustomerPage .class);
			boolean res = cuspage.addCustomer(Cname, Address, city, country, Cperson, Pnumber, Email, Mnumber, Notes);
			if(res)
			{
				xl.setCellData(Sheetname, i, 9, "Pass", outputpath);
				logger.log(LogStatus.PASS, "Customer ids are matching");
				
			}
			else
			{
				xl.setCellData(Sheetname, i, 9, "Fail", outputpath);
				logger.log(LogStatus.FAIL, "Customer ids are not matching");
			}
			report.endTest(logger);
			report.flush();
			
		}
		
		
		
	}
	

}
