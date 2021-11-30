package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {

    By checkOutHeader = By.xpath("//h1[normalize-space()='Secure Checkout']");
    By firstName = By.id("shippingaddress-firstname");
    By lastName = By.id("shippingaddress-lastname");
    By street = By.id("shippingaddress-street");
    By state = By.id("shippingaddress-custom-state");
    By profileCheckBox = By.id("create_profile");
    By password = By.id("password");
    By localShipping = By.xpath("//input[@id='method128']");
    By cashOnDelivery = By.id("pmethod6");
    By totalAmount = By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']");
    By placeOrderButton = By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");
    By orderSuccessMessage = By.xpath("//h1[normalize-space()='Thank you for your order']");


    public void verifyUserIsOnCheckOutPage() throws InterruptedException {
        Thread.sleep(2000);
        useVerifyResult("Secure Checkout",checkOutHeader,"wrong page");
    }

    public void addShippingAddress(){
        useSendTextToElement(firstName, "JJJ");
        useSendTextToElement(lastName, "PPP");
        useSendTextToElement(street, "1 North Ave");
        useSendTextToElement(state, "Beds");
    }

    public void createProfile(){
        useClickOnElement(profileCheckBox);
        useSendTextToElement(password,"abcdef123");
    }

    public void clickOnLocalShipping() throws InterruptedException {
        Thread.sleep(500);
        useClickOnElement(localShipping);
    }

    public void clickOnCODPaymentMethod() throws InterruptedException {
        Thread.sleep(500);
        useClickOnElement(cashOnDelivery);
    }

    public void verifyTotalAmount(String expectedAmount) throws InterruptedException {
        Thread.sleep(1000);
        useVerifyResult(expectedAmount,totalAmount,"wrong amount");
    }

    public void clickOnPlaceOrderButton() throws InterruptedException {
        Thread.sleep(1000);
        useClickOnElement(placeOrderButton);
    }

    public void verifySuccessFullOrderMessage() throws InterruptedException {
        Thread.sleep(1000);
        useVerifyResult("Thank you for your order",orderSuccessMessage,"order has not be placed successfully");
    }
}
