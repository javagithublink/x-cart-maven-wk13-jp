package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ComingSoonPage extends Utility {

    By comingSoonText = By.xpath("(//h1[normalize-space()='Coming soon'])[1]");

    public void verifyUserIsOnComingSoonPage(){
        useVerifyResult("Coming soon",comingSoonText,"wrong page");
    }
}
