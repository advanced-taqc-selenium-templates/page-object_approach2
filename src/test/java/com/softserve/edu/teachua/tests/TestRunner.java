package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.pages.menu.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(RunnerExtension.class)
public abstract class TestRunner {

    private static final String BASE_URL = "http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/";
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static final String LOCALSTORAGE_REMOVE_ITEM = "window.localStorage.removeItem('%s');";
    private static final Path ARTIFACTS_DIR = Path.of("target", "test-artifacts");
    protected static boolean isTestSuccessful = false;
    protected static WebDriver driver;
    protected static JavascriptExecutor js;

    protected static void presentationSleep() {
        presentationSleep(1);
    }

    protected static void presentationSleep(int seconds) {
        int delay = Integer.getInteger("presentation.delay.seconds", 0);
        if (delay <= 0 || seconds <= 0) {
            return;
        }
        try {
            Thread.sleep(seconds * delay * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void takeScreenShot(String currentTime) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Path path = ARTIFACTS_DIR.resolve(currentTime + "_screenshot.png");
        try {
            Files.write(path, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takePageSource(String currentTime) {
        Path path = ARTIFACTS_DIR.resolve(currentTime + "_source.html");
        try {
            Files.writeString(path, driver.getPageSource());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    @AfterAll
    public static void afterAll() {
        presentationSleep();
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        presentationSleep();
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        if (!isTestSuccessful) {
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
            try {
                Files.createDirectories(ARTIFACTS_DIR);
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIME_TEMPLATE));
                takeScreenShot(currentTime);
                takePageSource(currentTime);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().deleteAllCookies();
        js.executeScript(String.format(LOCALSTORAGE_REMOVE_ITEM, "accessToken"));
        js.executeScript(String.format(LOCALSTORAGE_REMOVE_ITEM, "refreshToken"));
        presentationSleep();
    }

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }

}
