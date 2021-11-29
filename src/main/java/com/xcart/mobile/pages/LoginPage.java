package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By logInPageHeader = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By email = By.cssSelector("#email");
    By continueButton = By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");

    public void verifyUserIsOnLogInPage() throws InterruptedException {
        Thread.sleep(500);
        useVerifyResult("Log in to your account",logInPageHeader ,"incorrect message on log in");
    }

    public void enterYourEmail(){
        useSendTextToElement(email,useGetUniqueEmailAddress());
    }

    public void clickOnContinueButton(){
        useClickOnElement(continueButton);

    }

}
