package cn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cn.Page.LoginPage;

//@Listeners({ZTestReport.class})
public class EmailTest {
	private WebDriver driver;
	
	@Test
	public void Login(){
	try{
		//创建一个LoginPage对象
		LoginPage loginpage=new LoginPage(driver);
		//直接调用页面对象的 密码登录在这里 对象，进行单击
		loginpage.Login.click();
		//将控制权交给frame页面
		driver.switchTo().frame(0);
		//显示等待
		WebDriverWait wait1=new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		//直接使用页面对象的用户名元素对象，输入用户名
		loginpage.userName.sendKeys("13647452447");
		//直接使用页面对象的密码元素对象，输入密码
		loginpage.passWord.sendKeys("puhongjun123456");
		//直接使用页面对象的登录按钮对象，进行单击
		loginpage.loginButton.click();
		//将控制权交给原来的界面
		driver.switchTo().defaultContent();
		//显示等待首页title
		WebDriverWait waitTitle=new WebDriverWait(driver,5);
		waitTitle.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//title[contains(text(),'网易邮箱6.0版')]")));
		//断言登录后的页面的Title值是否为“网易邮箱6.0版”
		Assert.assertTrue(driver.getTitle().contains("网易邮箱6.0版"));
		}catch(Exception e){
			Assert.fail("测试失败”");			
		}
		
	}
	@Test
	public void test2(){
		try{
			//断言登录后的页面的url
			Assert.assertTrue(driver.getCurrentUrl().contains("mail.163.com"));
			}catch(Exception e){
				Assert.fail("网页url没有包含mail.163.com");		
			}
		
	}
	@Test
	public void test3(){
		try{
			//断言登录后的页面的url
			Assert.assertTrue(driver.getCurrentUrl().contains("mail.163"));
			}catch(Exception e){
				Assert.fail("网页url没有包含mail.163");		
			}
	}
	@Test
	public void test41(){
		try{
			//断言登录后的页面的url
			Assert.assertTrue(driver.getCurrentUrl().contains("mail."));
			}catch(Exception e){
				Assert.fail("网页url没有包含mail.");		
			}
	}
	@Test
	public void test5(){
		try{
			//断言登录后的页面的url
			Assert.assertTrue(driver.getCurrentUrl().contains("163.com"));
			}catch(Exception e){
				Assert.fail("网页url没有包含163.com");		
			}
	}
	@Test
	public void test6(){
		try{
			//断言登录后的页面的url
			Assert.assertTrue(driver.getCurrentUrl().contains(".com"));
			}catch(Exception e){
				Assert.fail("网页url没有包含.com");		
			}
	}
	
	@BeforeMethod
	public void Before(){
		//获取当前工程项目的路径
		String path=System.getProperty("user.dir");
		//获取cheomedriver文件的所在路径
		String driverPath=path+"/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
		//浏览器最大化
		driver.manage().window().maximize();
		driver.get("https://mail.163.com/");
	}
	@AfterMethod
	public void After(){
		driver.quit();
	}
}
