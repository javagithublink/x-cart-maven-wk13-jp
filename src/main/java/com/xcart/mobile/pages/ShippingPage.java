package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ShippingPage extends Utility {

    By shippingPageText = By.xpath("//h1[@id='page-title']");

    public void verifyUserIsOnShippingPage(){

        useVerifyResult("Shipping",shippingPageText,"wrong page");
    }


}
