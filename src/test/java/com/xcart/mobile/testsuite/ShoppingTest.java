package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {

    HomePage homePage = new HomePage();
    ShippingPage shippingPage = new ShippingPage();
    NewArrivalsPage newArrivalsPage = new NewArrivalsPage();
    ContactUsPage contactUsPage = new ContactUsPage();
    ComingSoonPage comingSoonPage = new ComingSoonPage();
    SalePage salePage = new SalePage();
    BestSellersPage bestSellersPage = new BestSellersPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker () throws InterruptedException{
        homePage.clickOnSaleSubPage();

        salePage.verifyUserIsOnSalePage();
        salePage.clickOnSortByAToZAndVerify();
        salePage.clickOnAddToCartButton();
        salePage.verifyProductHasBeenAddedToCartMessage();
        salePage.goToCartFromSalePage();

        shoppingCartPage.verifyShoppingCartHeaderMessage();
        shoppingCartPage.changeQuantityAndVerifyHeaderMessage("2");
        shoppingCartPage.verifySubTotal("$29.98");
        shoppingCartPage.verifyTotalAmount("$36.00");
        shoppingCartPage.clickOnGoToCheckOutButton();

        loginPage.verifyUserIsOnLogInPage();
        loginPage.enterYourEmail();
        loginPage.clickOnContinueButton();

        checkOutPage.verifyUserIsOnCheckOutPage();
        checkOutPage.addShippingAddress();
        checkOutPage.createProfile();
        checkOutPage.clickOnLocalShipping();
        checkOutPage.clickOnCODPaymentMethod();
        checkOutPage.verifyTotalAmount("$37.03");
        checkOutPage.clickOnPlaceOrderButton();
        checkOutPage.verifySuccessFullOrderMessage();


    }

}
