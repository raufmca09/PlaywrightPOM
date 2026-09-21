package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    Properties prop;

    public Page initBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();

        System.out.println("browser name is " + browserName);

        playwright = Playwright.create();

        switch(browserName) {

            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Something went wrong in browser name");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        page.navigate(prop.getProperty("url").trim());

        return page;
    }

    /**
     This method is used to intialize the properties
     **/

    public Properties initProperties(){
        try{
            FileInputStream fis = new FileInputStream("src/test/resource/config/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;

    }
}
