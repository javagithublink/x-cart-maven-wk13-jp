package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSellersPage extends Utility {

    By bestSellersText =  By.xpath("//h1[text()='Bestsellers']");
    By sortByDropDown = By.xpath("//span[@class='sort-by-value']");
    By productList = By.xpath("//h5[@class='product-name']");
    By sortByZtoAText = By.xpath("//a[normalize-space()='Name Z - A']");
    By productPriceList = By.xpath("//span[@class='price product-price']");
    By sortByHighToLowText = By.xpath("//a[normalize-space()='Price High - Low']");
    By productRating = By.xpath("//div[@class ='rating']//div//div//div[@style]");
    By sortByRating = By.xpath("//a[normalize-space()='Rates']");
    By sortByAtoZText = By.xpath("//a[normalize-space()='Name A - Z']");
    By productImage = By.cssSelector("img[alt='Avengers: Fabrikations Plush [Related Products]']");
    By addToCartFirst = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartMessage = By.xpath("//li[@class='info']");
    By cartFromBestSellersPage = By.xpath("//div[@title='Your cart']");
    By viewCartFromBestSellersPage = By.xpath("//span[normalize-space()='View cart']");

    public void verifyUserIsOnBestSellersPage() throws InterruptedException {
        Thread.sleep(3000);
        useVerifyResult("Bestsellers",bestSellersText,"wrong page");
    }

    public void clickOnSortByZtoAAndVerifyBestSellers() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productList);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product :originalList) {
            originalProductNameList.add(product.getText());
        }
        //Collections.sort(originalProductNameList,Collections.reverseOrder());
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByZtoAText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productList);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 :afterSortingList){
            afterSortingProductName.add(product1.getText());
        }
        Assert.assertEquals(originalProductNameList,afterSortingProductName,"products are now sorted");

    }


    public void clickOnSortByHighToLowAndVerifyBestSellers() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productPriceList);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price :originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$","")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList,Collections.reverseOrder());
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByHighToLowText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productPriceList);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 :afterSortingList){
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$","")));
        }
        System.out.println(afterSortingProductPrice);
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

    public void clickOnSortByAtoZAndVerifyBestSellers() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productList);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product :originalList) {
            originalProductNameList.add(product.getText());
        }
        //Collections.sort(originalProductNameList);
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER);
        useMouseHoverAction(sortByDropDown);
        useMouseHoverAndClickAction(sortByAtoZText);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(productList);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 :afterSortingList){
            afterSortingProductName.add(product1.getText());
        }
        Assert.assertEquals(originalProductNameList,afterSortingProductName,"products are now sorted");

    }

    public void clickOnAddToCartButton() throws InterruptedException {
        useMouseHoverAction(productImage);
        Thread.sleep(2000);
        useClickOnElement(addToCartFirst);
    }

    public void verifyProductHasBeenAddedToCartMessage () throws InterruptedException {
        Thread.sleep(1000);
        useVerifyResult("Product has been added to your cart",addToCartMessage ,"product is not added to cart");
    }

    public void goToCartFromBestSellersPage(){
        useClickOnElement(cartFromBestSellersPage);
        useClickOnElement(viewCartFromBestSellersPage);

    }

}
