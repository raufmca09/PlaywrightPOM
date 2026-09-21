package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    //1. String locators

    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchText = "div#content h1";

    //2. Constructor

    public HomePage(Page page){
        this.page = page;
    }

    //3. Page methods

    //get home page title
    public String getHomePageTitle(){
        return page.title();
    }

    //get url
    public String getHomePageUrl(){
        return page.url();
    }

    //perform search
    public String  doSearch(String productName){
        page.fill(search, productName);
        page.click(searchIcon);
        return page.textContent(searchText);
    }


}
