package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by vpetrache on 8/1/2016.
 */
public class JobListPage {

    @FindBy(xpath="//div[contains(@class,'jResultsActive')]//span[@class='total_results']")
    private WebElement totalResultsField;

    @FindBy(xpath = "//div[contains(@class,'jResultsActive')]//a[@class='job_link font_bold']")
    private List<WebElement> jobList;

    private WebDriver driver;

    public JobListPage(WebDriver driver){
        this.driver = driver;
    }

    public Integer getTotalJobs(){

       String totalResults = totalResultsField.getText();
        return Integer.parseInt(totalResults);
    }

    public Integer getDisplayedJobNumber(){

          return jobList.size();
    }

    public JobDetailsPage clickJob(String jobToClick){

        for(WebElement job : jobList){
            if(job.getText().equals(jobToClick)){
               job.click();
                //sare din bucla do, for...
                return PageFactory.initElements(driver, JobDetailsPage.class);
            }
        }

        fail("No jobs with name: " + jobToClick + " was found");
        return null;
            }


    //method for waiting
    public void waitForPage(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //all elements accepta list
        wait.until(ExpectedConditions.visibilityOfAllElements(jobList));
        wait.until(ExpectedConditions.textToBePresentInElement(totalResultsField, ""));
    }

}
