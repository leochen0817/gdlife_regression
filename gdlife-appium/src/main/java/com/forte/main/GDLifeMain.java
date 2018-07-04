package com.forte.main;

import org.apache.log4j.Logger;

import com.forte.appium.GDLifeAppium;
import com.forte.selenium.GDLifeSelenium;

public class GDLifeMain {
	private static Logger logger = Logger.getLogger(GDLifeMain.class);
	public static void main(String[] args) {
		GDLifeSelenium sele = new GDLifeSelenium();
		logger.info("==================开始执行回归脚本=====================");
		logger.info("------------------执行管理后台脚本------------------------");
		sele.login();
		sele.enterAuthInfo();
		sele.quit();
		
		logger.info("------------------执行app脚本------------------------");
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
