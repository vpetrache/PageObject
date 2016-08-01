package com.endava.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vpetrache on 8/1/2016.
 */
public class HomePage {

@FindBy(xpath = "//input[@id='keyword']")
    private WebElement searchBox;

@FindBy(xpath = "//div[@id='loc_placeholder']")
    private WebElement locationBox;

@FindBy(xpath = "//input[@value ='All locations']")
    private WebElement sendLocation;

@FindBy(xpath = "//span[contains(.,'Search')]")
    private WebElement searchButton;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public JobListPage SearchJob(String jobSearchText, Locations location) {

    searchBox.sendKeys(jobSearchText);
    locationBox.click();
    sendLocation.sendKeys(location.toString(), Keys.RETURN);
    searchButton.click();

    JobListPage jobListPage = PageFactory.initElements(driver, JobListPage.class);
        jobListPage.waitForPage();
        return jobListPage;
    }
}


