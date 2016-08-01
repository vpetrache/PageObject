package com.endava.test;

import com.endava.pageObjects.HomePage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vpetrache on 8/1/2016.
 */
public class TestBaseClass {

    private static WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public static void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://endava.referrals.selectminds.com/");

   }

    @Before
    public void initPageObjects(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
}