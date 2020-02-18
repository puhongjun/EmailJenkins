package cn.Page;
//使用PageFactor类给测试类提供待操作元素和封装页面元素
//使用LoadableComponent类

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//使用@FindBy注解，定位到需要操作的页面元素
	//163邮箱首页  密码登录在这里
	@FindBy(xpath="//div[@id='lbNormal']")
	public WebElement Login;
	//邮箱账号
	@FindBy(xpath="//input[@name='email']")
	public WebElement userName;
	//邮箱密码
	@FindBy(name="password")
	public WebElement passWord;
	//登录按钮
	@FindBy(id="dologin")
	public WebElement loginButton;
	//未读邮件
	@FindBy(xpath="//b[@class='nui-ico gWel-ico gWel-ico-unread-top']")
	public WebElement WD;
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
}
