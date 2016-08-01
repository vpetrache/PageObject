package com.endava.test;

import com.endava.pageObjects.JobDetailsPage;
import com.endava.pageObjects.JobListPage;
import com.endava.pageObjects.Locations;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vpetrache on 8/1/2016.
 */

public class jobSearchTest extends TestBaseClass{

    @Test
    public void searchExistingLocation(){
       JobListPage jobListPage =  homePage.SearchJob("Testing", Locations.BUCHAREST);
        Integer totalJobs  = jobListPage.getTotalJobs();
        System.out.println("Total Jobs: " + totalJobs);
        Assert.assertTrue(totalJobs > 0);

        Integer displayedJobs = jobListPage.getDisplayedJobNumber();
        System.out.println("Displayed jobs on page: " + displayedJobs);

        Assert.assertEquals(new Integer(10), displayedJobs);


        JobDetailsPage jobDetailsPage = jobListPage.clickJob("Automation Tester (Java)");

        System.out.println("Total views: " + jobDetailsPage.getTotalViews());


    }
}