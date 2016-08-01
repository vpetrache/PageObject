package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vpetrache on 8/1/2016.
 */
public class JobDetailsPage {

    @FindBy(xpath = "//dd[@class='job_total_views']/span[@class='field_value']")
    private WebElement totalViewsNumber;

    public Integer getTotalViews(){

        String totalViews = totalViewsNumber.getText();
        return Integer.parseInt(totalViews);
    }
}
