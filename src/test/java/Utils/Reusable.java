package utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class Reusable {

    public void getAstrixSymbolfromTextField(WebElement element) {
        element.clear();
//		Assert.assertTrue(element.getText().contains("*"));
        if (element.getText().contains("*")) {
            System.out.println(element.getText() + " filed is contains * symbol");
        } else {
            System.out.println(element.getText() + " field doesnot contais * symbol");
        }

    }

    public void getToastMessage(WebElement element, String expectedMessage) {
        String Actual = element.getText();
        System.out.println("Actual Message is : " + Actual);
        Assert.assertEquals(Actual, expectedMessage);
        System.out.println("The toastmessage is as expected");
    }
}