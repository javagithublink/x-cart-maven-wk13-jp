package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By hotDealsText = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']");
    By saleText = By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]");
    By bestSellersText = By.xpath("(//span[contains(text(),'Bestsellers')])[2]");


    public void selectMenu(String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li"));

        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }

    }


    public void clickOnShippingPage() throws InterruptedException {

        selectMenu("Shipping");

    }

    public void clickOnNewArrivalsPage() throws InterruptedException {

        selectMenu("New!");

    }

    public void clickOnComingSoonPage() throws InterruptedException {

        selectMenu("Coming soon");

    }

    public void clickOnContactUsPage() throws InterruptedException {

        selectMenu("Contact us");

    }

    public void clickOnSaleSubPage() throws InterruptedException {
        useMouseHoverAction(hotDealsText);
        useMouseHoverAndClickAction(saleText);
    }

    public void clickOnBestSellersSubPage() throws InterruptedException {
        useMouseHoverAction(hotDealsText);
        useMouseHoverAndClickAction(bestSellersText);
    }


}
