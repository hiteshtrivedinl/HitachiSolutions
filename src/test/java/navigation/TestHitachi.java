package navigation;

import commonLiberary.ExtendedMethods;
import commonLiberary.HitachiPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHitachi {

    WebDriver driver;
    HitachiPage hp;
    ExtendedMethods em;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        hp = new HitachiPage(driver);
        em = new ExtendedMethods(driver);
        driver.get(" https://global.hitachi-solutions.com/");
    }

    @Test(priority = 1, description = "Testing the navigation")
    public void navigationTest() {
        String title = driver.getTitle();
        System.out.println("Title :" + title);
    }

    @Test(priority = 2, description = "Search with Keyword : Technology")
    public void searchKeyword() {
        em.checkVisibility(hp.searchBox);
        em.clickOn(hp.searchBox);
        em.write(hp.searchKeyword, "Technology");
        em.hitEnter(hp.searchKeyword);
    }

    @Test(priority = 3, description = "Count the results containing technology")
    public void countResults() throws InterruptedException {
        em.waitForSeconds(2);
        int count = em.getCountOfElement(hp.searchResult);
        System.out.println("Count of results : " + count);
        Assert.assertEquals(13, count);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
