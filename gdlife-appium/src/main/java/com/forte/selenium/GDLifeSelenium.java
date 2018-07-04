package com.forte.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GDLifeSelenium {
	WebDriver dr = null;
	private static Logger logger = Logger.getLogger(GDLifeSelenium.class); 

	public GDLifeSelenium() {
		Properties prop = new Properties();
		try {
			InputStream in = GDLifeSelenium.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(in);
			String value = prop.getProperty("webdriver.chrome.driver");
			System.setProperty("webdriver.chrome.driver", value);
			this.dr = new ChromeDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login() {
		try {
			Thread.sleep(3000);
			dr.get("http://172.95.65.100:8080/wyweb/login");
			dr.findElement(By.id("acct")).sendKeys("admin");
			dr.findElement(By.id("pwd")).sendKeys("admin");
			dr.findElement(By.id("btn-login")).click();
			Thread.sleep(3000);
			logger.info("登录运管后台成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAuthInfo(){
		try {
			dr.findElement(By.linkText("小区管理")).click();
			Thread.sleep(1000);
			dr.findElement(By.linkText("认证信息管理")).click();
			dr.findElement(By.id("authName")).sendKeys("刘晨");
			dr.findElement(By.id("roomDesc")).sendKeys("宝山路268-1-1001");
			dr.findElement(By.id("queryAuthBtn")).click();
			Thread.sleep(1000);
			dr.findElement(By.linkText("取消认证")).click();
			dr.findElement(By.id("cancelBtn")).click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e1) {
			logger.error("取消认证失败，检查该用户是否已认证");
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
	}
	
	public void quit() {
		dr.quit();
	}
	
	public static void main(String[] args) {
		GDLifeSelenium gd = new GDLifeSelenium();
		 gd.login();
		 gd.enterAuthInfo();
		 gd.quit();
	}

}