package commonLiberary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//This class has all the extended methods to be used throughout the automation process

public class ExtendedMethods {

    WebDriver driver;

    public ExtendedMethods(WebDriver driver) {

        this.driver = driver;

    }

    //To check visibility of the element before interaction

    public void checkVisibility(By we) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(we));
    }

    //To get count of elements

    public int getCountOfElement(By we) {
        return driver.findElements(we).size();
    }

    //To get text from the element (used innerHTML because of span tag)

    public String getText(By we) {
        return driver.findElement(we).getAttribute("innerHTML").trim();
    }

    //To wait for the certain time

    public void waitForSeconds(int mills) throws InterruptedException {
        Thread.sleep(mills * 1000L);
    }

    //To cover mouse operations

    public void mouseOver(By we) {
        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(we)).perform();
    }

    //To cover clicks

    public void clickOn(By we) {
        driver.findElement(we).click();
    }

    //To write data
    public void write(By we, String text) {
        driver.findElement(we).sendKeys(text);
    }

    //To hit enter

    public void hitEnter(By we) {
        driver.findElement(we).sendKeys(Keys.ENTER);
    }


}
