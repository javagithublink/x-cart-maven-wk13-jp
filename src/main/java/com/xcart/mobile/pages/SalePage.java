package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalePage extends Utility {

    By saleText = By.xpath("//h1[@id='page-title']");
    By sortByDropDown = By.xpath("//span[@class='sort-by-value']");
    By productList = By.xpath("//h5[@class='product-name']");
    By sortByAToZText = By.xpath("//a[normalize-space()='Name A - Z']");
    By productPriceList = By.xpath("//ul[@class='product-price']");
    By sortByLowToHighText = By.xpath("//a[normalize-space()='Price Low - High']");
    By productRating = By.xpath("//div[@class='rating']//div//div//div[@style]");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");
    By productImage = By.xpath("//div[contains(@class,'product productid-16')]//a[contains(@class,'product-thumbnail next-previous-assigned')]");
    By addToCartFirst = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartMessage = By.xpath("//li[@class='info']");
    By cartFromSalePage = By.xpath("//div[@title='Your cart']");
    By viewCartFromSalePage = By.xpath("//span[normalize-space()='View cart']");

    public void verifyUserIsOnSalePage(){
        useVerifyResult("Sale",saleText,"wrong page");
    }

    public void clickOnSortByAToZAndVerify() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productList);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product :originalList) {
            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByAToZText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productList);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 :afterSortingList){
            afterSortingProductName.add(product1.getText());
        }
        Assert.assertEquals(originalProductNameList,afterSortingProductName,"products are now sorted");

    }

    public void clickOnSortByHighToLowAndVerify() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productPriceList);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price :originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$","")));
        }

        //System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList);
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByLowToHighText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productPriceList);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 :afterSortingList){
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$","")));
        }
        //System.out.println(afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList,afterSortingProductPrice,"products are not sorted");

    }


    public void clickOnSortByRatesAndVerify() throws InterruptedException{

        List<WebElement> originalList = driver.findElements(productRating);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating :originalList) {
           originalProductRating.add(rating.getAttribute("style").indexOf(3,6));
        }

        //System.out.println(driver.findElements(productRating).size());
        //System.out.println(useGetTextFromElement(productRating));

        Collections.sort(originalProductRating,Collections.reverseOrder());
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByRating);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productRating);
        List<Integer> afterSortingProductRating = new ArrayList<>(15);
        for (WebElement rating1 :afterSortingList){
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(3,6));
        }
        //System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating,afterSortingProductRating,"products are not sorted");

    }


    public void clickOnAddToCartButton() throws InterruptedException {
        useMouseHoverAction(productImage);
        Thread.sleep(2000);
        useClickOnElement(addToCartFirst);
    }

    public void verifyProductHasBeenAddedToCartMessage () throws InterruptedException {
        Thread.sleep(2000);
        useVerifyResult("Product has been added to your cart",addToCartMessage ,"product is not added to cart");
    }

    public void goToCartFromSalePage(){
        useClickOnElement(cartFromSalePage);
        useClickOnElement(viewCartFromSalePage);

    }


}
