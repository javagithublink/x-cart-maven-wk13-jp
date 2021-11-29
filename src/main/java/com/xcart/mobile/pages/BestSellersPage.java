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
        Collections.sort(originalProductNameList,Collections.reverseOrder());
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

}
