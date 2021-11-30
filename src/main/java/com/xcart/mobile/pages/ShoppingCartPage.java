package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utility {

    By shoppingCartHeader = By.xpath("//h1[@id='page-title']");
    By quantityField = By.xpath("//input[@id='amount16']");
    By subTotalText = By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']");
    By totalAmountText = By.xpath("//li[@class='total']//span[@class='surcharge']");
    By checkOutButton = By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");
    By emptyYourCartText = By.xpath("//a[normalize-space()='Empty your cart']");
    By itemDeletedText = By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]");
    By cartEmptyText = By.xpath("//h1[contains(normalize-space(),'Your cart is empty')]");

    public void verifyShoppingCartHeaderMessage() throws InterruptedException {
        Thread.sleep(1000);
        useVerifyResult("Your shopping cart - 1 item",shoppingCartHeader, "product is not added to cart");
    }

    public void changeQuantityAndVerifyHeaderMessage(String qty) throws InterruptedException {
        driver.findElement(quantityField).clear();
        Thread.sleep(1000);
        useSendTextToElement(By.xpath("//input[@id='amount16' and @ name='amount']"),qty);
        Thread.sleep(4000);
        useVerifyResult("Your shopping cart - "+qty+" items",shoppingCartHeader ,"product is not added to cart");
    }

    public void verifySubTotal(String subTotal) throws InterruptedException {
        Thread.sleep(500);
        useVerifyResult(subTotal,subTotalText,"wrong subtotal");
    }

    public void verifyTotalAmount(String total) throws InterruptedException {
        Thread.sleep(500);
        useVerifyResult(total,totalAmountText,"wrong subtotal");
    }

    public void clickOnGoToCheckOutButton(){
        useClickOnElement(checkOutButton);

    }

    public void clickOnEmptyYourCart() throws InterruptedException {
        Thread.sleep(500);
        useClickOnElement(emptyYourCartText);

    }

    public void verifyAlertMessageAndAccept() throws InterruptedException {
        String expected =  "Are you sure you want to clear your cart?";
        Assert.assertEquals(expected,useGetTextAlert());
        Thread.sleep(500);

        useAcceptAlert();
    }

   public void verifyItemDeletedFromYourCartMessage() throws InterruptedException{
       Thread.sleep(2000);
       useVerifyResult("Item(s) deleted from your cart",itemDeletedText,"item is not deleted");
   }

    public void verifyYourCarIsEmptyMessage() throws InterruptedException {
        Thread.sleep(2000);
        useVerifyResult("Your cart is empty",cartEmptyText,"cart is not empty");
    }

}
