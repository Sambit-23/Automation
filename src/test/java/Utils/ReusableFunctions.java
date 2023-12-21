package utils;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.assertj.core.api.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageobject.settingsModule;

public class ReusableFunctions  {
	 private WebDriver driver;
	 
	 settingsModule sett = new settingsModule(driver);

	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

	public void toastMessageValidation(String message) {
		
		assertEquals(message, driver.findElement(sett.getApprovalWorkflowToastMessage()).getText());
	}
	
	public void checkTheCodeInApprovalDashboard(String workflowCode) throws InterruptedException {
	
		List<WebElement> codes = driver.findElements(sett.getApprovalWorkflowWorkflowCodeList());
		for (WebElement code : codes) {
			if(code.getText().equalsIgnoreCase(workflowCode)){
				
			   System.out.println("code added successfully");
			  break;
			  }
			else 
			{
				junit.framework.Assert.fail("code not matched");
			}
		}
	}
	
	public void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}

	public void robotArrowDown(Integer number) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < number; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public void robotArrowUp(Integer number) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < number; i++) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
	}

	public void Clear(WebElement el) throws AWTException {
		el.sendKeys(Keys.CONTROL + "a");
		el.sendKeys(Keys.BACK_SPACE);
	}

	public void robotTabEnter(int num) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < num; i++) {
			r.keyPress(KeyEvent.VK_TAB);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void selectSecondElement(List<WebElement> el) {
		el.get(1).click();
	}

	public void robotEnter() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}


	public void robotTab(Integer num) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < num; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}

	public void windowMinimize(int num) throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		for (int i = 0; i < num; i++) {
			r.keyPress(KeyEvent.VK_MINUS);
		}
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_MINUS);

	}

}