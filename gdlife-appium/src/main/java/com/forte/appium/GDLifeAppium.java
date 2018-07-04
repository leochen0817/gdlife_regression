package com.forte.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GDLifeAppium {
    private AppiumDriver<AndroidElement> driver;
    private static Logger logger = Logger.getLogger(GDLifeAppium.class);
    
    public GDLifeAppium() {
    	File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "gdlife-test-20170104.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.forte.wujia");
        capabilities.setCapability("appActivity", ".activity.account.UserLoginActivity");
        try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

    public void quit(){
    	driver.quit();
    }
    
    public void login() throws InterruptedException{
		List<AndroidElement> list = driver.findElementsByClassName("android.widget.EditText");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		list.get(0).sendKeys("15800960260");
		list.get(1).sendKeys("123456");
		WebElement login = driver.findElementByName("登录");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.click();
		WebElement city = driver.findElementByName("上海市");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		city.click();
		WebElement community = driver.findElementByName("上海新都国际");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		community.click();
		Thread.sleep(1000);
		logger.info("登录app成功");
    }
    
    public void enterMine() throws InterruptedException{
    	WebElement mine = driver.findElementByName("我的");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	mine.click();
    	Thread.sleep(1000);
    }
    
    public void authAddress(){
    	try{
	    	WebElement auth = driver.findElementByName("认证住址");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	auth.click();
	    	WebElement level1 = driver.findElementByName("宝山路268弄");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	level1.click();
	    	WebElement level2 = driver.findElementByName("1号");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	level2.click();
	    	WebElement level3 = driver.findElementByName("宝山路268-1-1001");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	level3.click();
	    	WebElement commit = driver.findElementByName("提交");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	commit.click();
	    	List<AndroidElement> list = driver.findElementsByClassName("android.widget.EditText");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).sendKeys("5858");
			WebElement confirm = driver.findElementByName("提交认证");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			confirm.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement success = driver.findElementByName("确认");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			success.click();
			Thread.sleep(1000);
			logger.info("认证成功");
    	}catch(InterruptedException e1){
    		e1.printStackTrace();
    	}catch(NoSuchElementException e2){
    		logger.error("房产认证异常，请检查是否已认证或者手机号码不对或者认证接口异常");
    		List<AndroidElement> list = driver.findElementsByClassName("android.widget.ImageView");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).click();
    	}
    }
    
    public void returnIndex(){
    	WebElement index = driver.findElementByName("首页");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	index.click();
    }
    
    public void affair(){
    	try{
    		WebElement affair = driver.findElementByName("报事报修");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	affair.click();
        	Thread.sleep(1000);
        	List<AndroidElement> list = driver.findElementsByClassName("android.widget.EditText");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).sendKeys("appium回归测试，请忽略！");
			WebElement next = driver.findElementByName("下一步");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	next.click();
        	Thread.sleep(1000);
        	WebElement rightnow = driver.findElementByName("立刻报事");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	rightnow.click();
        	Thread.sleep(1000);
        	WebElement close = driver.findElementByName("关闭");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	close.click();
        	Thread.sleep(1000);
        	logger.info("报事报修成功");
    	}catch(InterruptedException e1){
    		e1.printStackTrace();
    	}catch(NoSuchElementException e2){
    		logger.error("报事异常，请检查报事接口");
    		List<AndroidElement> list = driver.findElementsByClassName("android.widget.ImageView");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).click();
    	}
    }
    
    public void enterPay(){
    	try{
    		WebElement pay = driver.findElementByName("物业缴费");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	pay.click();
        	Thread.sleep(1000);
        	List<AndroidElement> list = driver.findElementsByClassName("android.widget.ImageView");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).click();
			Thread.sleep(1000);
			logger.info("联通物业缴费成功");
    	}catch(InterruptedException e1){
    		e1.printStackTrace();
    	}catch(NoSuchElementException e2){
    		logger.error("物业缴费异常，请检查缴费接口或者易软jar包");
    		List<AndroidElement> list = driver.findElementsByClassName("android.widget.ImageView");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			list.get(0).click();
    	}
    }
    
    public static void main(String[] args) {
    	GDLifeAppium app = new GDLifeAppium();
    	try {
			app.login();
			app.enterMine();
			app.authAddress();
			app.returnIndex();
			app.enterPay();
			app.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
