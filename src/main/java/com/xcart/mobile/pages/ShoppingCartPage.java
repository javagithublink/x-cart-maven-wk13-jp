package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartHeader = By.xpath("//h1[@id='page-title']");
    By quantityField = By.xpath("//input[@id='amount16']");
    By subTotalText = By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']");
    By totalAmountText = By.xpath("//li[@class='total']//span[@class='surcharge']");
    By checkOutButton = By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");

    public void verifyShoppingCartHeaderMessage(){
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

}
