package selenium;

import java.util.regex.Pattern;

import javax.print.DocFlavor.BYTE_ARRAY;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.omg.CORBA.OBJ_ADAPTER;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@RunWith(Parameterized.class)
public class Testgit {
  private String stnum ;
  private String stname;
  private String stgit;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  // private StringBuffer verificationErrors = new StringBuffer();
  // static String[] Studentnum = new String[200];
  // static String[] Studentname = new String[200];
  // static String[] giturl = new String[200];
  public Testgit(String stn,String stna,String stgt)
  {
	  stnum = stn;
	  stname = stna;
	  stgit = stgt;
  }

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800/login";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseUrl + "/");
  }
  @Parameters
	public static Collection<Object[]>getData(){
		String xlsxpath = "C:/workspace/scs_lab2/src/软件测试名单.xlsx";
		ArrayList<String> Studentnum = new ArrayList<String>();
		ArrayList<String> Studentname = new ArrayList<String>();
		ArrayList<String> giturl = new ArrayList<String>();
		try{
			  OPCPackage pkg= OPCPackage.open(xlsxpath);
			  XSSFWorkbook excel = new XSSFWorkbook(pkg);
			  XSSFSheet sheet = excel.getSheet("Sheet1");
			  for(int i=2;i<=sheet.getLastRowNum();i++){
	              Row row = sheet.getRow(i);
	              // System.out.println(row.getCell(0));
	              // System.out.println(row.getCell(1).getNumericCellValue());
	          	  row.getCell(1).setCellType(XSSFCell.CELL_TYPE_STRING);
	              Studentnum.add(row.getCell(1).getStringCellValue());
	              Studentname.add(row.getCell(2).getStringCellValue());
	              giturl.add(row.getCell(3).getStringCellValue());
			  }
			  excel.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		System.out.println(Studentnum.size());
		System.out.println(Studentname.size());
		System.out.println(giturl.size());
		System.out.println(Studentnum.get(0));
		// getxlsx(xlsxpath);
		Object[][] obj = new Object[Studentnum.size()][];
		for(int i=0;i<Studentnum.size();i++)
		{
			obj[i]=new Object[3];
		    obj[i][0]=Studentnum.get(i);
			obj[i][1]=Studentname.get(i);
			obj[i][2]=giturl.get(i);
		}
		return Arrays.asList(obj);
	}
  @Test
  public void test() throws Exception {
    WebElement we = driver.findElement(By.name("id"));
    // WebElement we = driver.findElement(By.id("kw"));
    we.click();
    // driver.findElement(By.id("kw")).click();
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys(stnum);
    WebElement we1 = driver.findElement(By.name("password"));
    we1.click();
    we1.clear();
    we1.sendKeys(stnum.substring(4));
    driver.findElement(By.id("btn_login")).click();
    assertEquals(stname, driver.findElement(By.id("student-name")).getText());
    assertEquals(stnum, driver.findElement(By.id("student-id")).getText());
    assertEquals(stgit, driver.findElement(By.id("student-git")).getText());
    driver.findElement(By.id("btn_logout")).click();
    driver.findElement(By.id("btn_return")).click();
    //driver.findElement(By.id("kw")).sendKeys("天津大学");
    //driver.findElement(By.id("su")).click();
    //assertEquals("天津大学_百度搜索", driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

