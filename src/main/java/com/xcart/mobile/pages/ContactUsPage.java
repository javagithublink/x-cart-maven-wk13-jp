package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ContactUsPage extends Utility {

    By contactUsText = By.xpath("//h1[text()='Contact us']");

    public void verifyUserIsOnContactUsPage(){
        useVerifyResult("Contact us",contactUsText,"wrong page");
    }
}
