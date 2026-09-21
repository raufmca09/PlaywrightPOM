package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test
    public void homePageTitelTest(){
        Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest(){
        Assert.assertEquals(homePage.getHomePageUrl(),prop.getProperty("url"));
    }

    @Test(dataProvider = "getProductData")
    public void searchTest(String productName){
        Assert.assertEquals(homePage.doSearch(productName), "Search - "+productName);
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][] {
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

}
