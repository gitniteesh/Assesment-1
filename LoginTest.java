package Demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.LoginPage;
import util.Base;
import util.ExcellReader;

public class LoginTest extends Base{
	
	@Test(dataProvider="dp")
	public void loginTest(String uname, String pass, String expected)
	{
		driver = connect();
		LoginPage log = new LoginPage(driver);
		log.enterusername(uname);
		log.enterpassword(pass);
		log.login();
		
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			assertEquals(expected, text);
			
		} catch (Exception e) {
			String actualTitle = driver.getTitle();
			assertEquals(expected, actualTitle);
		}
		
		
	}
	
	@DataProvider(name="dp")
	public Object[][] dataprovider()
	{
		ExcellReader rd= new ExcellReader("C:\\Users\\Admin\\OneDrive\\Documents\\Sheet\\Login.xlsx", "Login");
		int row = rd.rowCount();
		int col = rd.colCount();
		Object obj[][]= new Object[row-1][col];
		
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String data = rd.getdata(i, j);
				obj[i-1][j]=data;
			}
		}
		
		return obj;
	}

}









