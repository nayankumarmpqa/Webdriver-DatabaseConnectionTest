package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Statement;



public class JDBCconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="127.0.0.1";
		//String host="localhost"; // we can use this command as well
		String port="3306";
		

		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/QADBT", "nkumar", "t3stf1rst@123");
	
		Statement stm = (Statement) con.createStatement();
	
		ResultSet rs = stm.executeQuery("select*from Einfo where ename='nayan';");
		
		while(rs.next()) {
			
		//System.out.println(rs.getString("ename"));
		//System.out.println(rs.getString("location"));
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Drivers\\chromedriver88.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.vialivetext.com/");
			
		driver.findElement(By.id("input-login-username")).sendKeys(rs.getString("ename"));
		driver.findElement(By.id("input-login-password")).sendKeys(rs.getString("location"));
		}
	}

}
