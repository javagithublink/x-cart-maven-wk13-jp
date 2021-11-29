package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class NewArrivalsPage extends Utility {

    By newArrivalsText = By.xpath("(//h1[normalize-space()='New arrivals'])[1]");

    public void verifyUserIsOnNewArrivalsPage(){
        useVerifyResult("New arrivals",newArrivalsText,"wrong page");
    }

}
