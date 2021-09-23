package com.example.BilltePreviewTest;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private BilltePreviewTestPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://biller.billte.ch/");

        mainPage = new BilltePreviewTestPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        mainPage.loginBtn.click();
        mainPage.usernameInput.sendKeys("ali.yassine@billte.ch");
        mainPage.passwordInput.sendKeys("yassine.a");
        mainPage.confirmLogin.click();
        mainPage.closePopup.click();
        mainPage.start.click();
        mainPage.template.click();
        mainPage.continueBtn.click();

        mainPage.previewBtn.click();
        Stopwatch s = Stopwatch.createStarted();

        //set waiting period
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //second page - wait for element to be available.
        WebElement element = driver.findElement(By.cssSelector("#app > div:nth-child(2) > section > div > div.column.is-10.keep-same-height > div > div.design-form.pb3 > div.modal.is-active"));

        // stop the timer
        s.stop();

        //reset waiting period
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        System.out.println("Elapsed Time: " + s.elapsed((TimeUnit.MILLISECONDS)) + " ms");

        Thread.sleep(2000);

        driver.close();

    }

    @Test
    public void test2() throws InterruptedException {
        mainPage.loginBtn.click();
        mainPage.usernameInput.sendKeys("ali.yassine@billte.ch");
        mainPage.passwordInput.sendKeys("yassine.a");
        mainPage.confirmLogin.click();
        mainPage.closePopup.click();
        mainPage.start.click();
        mainPage.template.click();
        mainPage.continueBtn.click();

        // fill form
        driver.findElement(By.id("autoSuggestProductInput100000")).sendKeys("j");
        driver.findElement(By.cssSelector(".autocomplete-result:nth-child(1)")).click();
        driver.findElement(By.cssSelector("span .autocomplete span")).click();
        driver.findElement(By.id("autoSuggestProductInput0")).sendKeys("a");
        driver.findElement(By.cssSelector("td:nth-child(3) .pure-material-textfield-outlined > span")).click();
        driver.findElement(By.cssSelector("td:nth-child(3) input")).sendKeys("1");

        mainPage.saveBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.urlContains("view-created-invoice"));

        //mainPage.previewBtn.click();
        Stopwatch s = Stopwatch.createStarted();

        //set waiting period
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //second page - wait for element to be available.
        boolean element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/section/div/div[2]/div/div[2]/div/div/div[2]/div/embed")).isDisplayed();
        System.out.println(element);
        // stop the timer
        s.stop();

        //reset waiting period
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        System.out.println("Elapsed Time: " + s.elapsed((TimeUnit.MILLISECONDS)) + " ms");

        Thread.sleep(2000);

        driver.close();

    }
}
