package com.xcart.mobile.utility;

import com.xcart.mobile.drivermanager.DriverManager;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Utility extends DriverManager {


    /**
     * This method will click on element
     *
     * @param by
     */

    public void useClickOnElement(By by) {
        WebElement logIn = driver.findElement(by);
        logIn.click();
    }

    /**
     * This method will get text from element
     *
     * @param by
     * @return
     */
    public String useGetTextFromElement(By by) {
        return driver.findElement(by).getText();

       /* WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = text.getText();
        return actualMessage;*/
    }

    /**
     * This method will write/send text on element
     *
     * @param by
     * @param text
     */

    public void useSendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will switch to and accept alert
     */

    public void useAcceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will switch to and dismiss/cancel alert
     */

    public void useDismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get and return text from alert
     *
     * @return
     */

    public String useGetTextAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will select value from dropdown using selectByVisibleText() method
     *
     * @param by
     * @param text
     */

    public void useSelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    /**
     * This method will select value from dropdown using selectByValue() method
     *
     * @param by
     * @param text
     */

    public void useSelectByValueFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    /**
     * This method will select index value for dropdown text using selectByIndex() method
     *
     * @param by
     * @param index
     */

    public void useSelectByIndexFromDropDown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * This method will perform mouse drag and drop action
     *
     * @param drag
     * @param drop
     */

    public void useDragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);

        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);

        actions.dragAndDrop(draggable, droppable).build().perform();

    }

    /**
     * This method will perform mouse slider action based on x and y value
     *
     * @param by
     * @param x
     * @param y
     */
    public void useSliderAction(By by, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(by);
        actions.dragAndDropBy(slider, x, y).build().perform();
    }

    /**
     * This method will perform mouse right click action
     *
     * @param by
     */
    public void useMouseRightClickAction(By by) {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick().build().perform();
    }

    /**
     * This method will perform mouse hover action
     *
     * @param by
     */

    public void useMouseHoverAction(By by) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).build().perform();
    }

    /**
     * This method will perform mouse hover and click action
     *
     * @param by
     */

    public void useMouseHoverAndClickAction(By by) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).click().build().perform();

        //new Actions(driver).moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * This method will verify expected and actual result using Assert class methods.
     *
     * @param by
     * @param expected
     * @param errorMessage
     */
    public void useVerifyResult(String expected, By by, String errorMessage) {
        String actual = useGetTextFromElement(by);
        Assert.assertEquals(expected, actual, errorMessage);
    }


    /**
     * This method will generate unique email address everytime
     *
     * @return
     */

    public String useGetUniqueEmailAddress() {

        RandomString ranstr = new RandomString(10);
        String randomString = ranstr.nextString();
        return randomString + "@gmail.com";
    }

    /**
     * This method will sort data as per requirement
     *
     * @param by
     */

    public void useDataSorting(By by) {
        List<WebElement> name = driver.findElements(by);
        String[] before = new String[name.size()];
        for (int i = 0; i < name.size(); i++) {
            before[i] = name.get(i).getText().trim();
        }
        Arrays.sort(before);
        WebElement sort = driver.findElement(by);
        sort.click();
        name = driver.findElements(by);
        String[] after = new String[name.size()];

        for (int i = 0; i < name.size(); i++) {
            after[i] = name.get(i).getText().trim();

            Assert.assertEquals(before, after, "products are not sorted");
        }
    }

/*
        public void useDataSorting(By original,By sortBy,String text) throws InterruptedException {

            // Mouse hover on computer menu and click on Desktop
            //useMouseHoverAction(By.xpath("//div[@class='header-menu']//ul[1]//a[contains(text(),\"Computers\")]"));
            //clickOnElement(By.xpath("//div[@class='header-menu']//ul[1]//a[contains(text(),'Computers')]//parent::li//ul//a[contains(text(), 'Desktops')]"));

            List<WebElement> originalList = driver.findElements(original);
            List<String> originalProductNameList = new ArrayList<>();
            for (WebElement product :originalList) {
                originalProductNameList.add(product.getText());
            }

            //Collections.sort(originalProductNameList);
            //Collections.sort(originalProductNameList,Collections.reverseOrder()); // for Z to A
            System.out.println(originalList);


            //Sort by position "Name: A to Z"
            useSelectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");

            // Sort by position "Name: Z to A"
            //useWaitUntilVisibilityOfElementLocated(By.id("products-orderby"),10);
            Thread.sleep(3000);

            List<WebElement> afterSortingList = driver.findElements(By.xpath("//h2[@class='product-title']"));
            List<String> afterSortingProductName = new ArrayList<>();
            for (WebElement product1 :afterSortingList){
                afterSortingProductName.add(product1.getText());
            }
            System.out.println(afterSortingProductName);



            Assert.assertEquals(originalProductNameList, afterSortingProductName,"Product not sorted");



        }


 */

}