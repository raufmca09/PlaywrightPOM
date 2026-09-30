package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest(){
        loginPage = homePage.navigateToLogin();
        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPasswordLinkExist(){
      //  loginPage = homePage.navigateToLogin(); This line can relogin and check this
        Assert.assertTrue(loginPage.isForgotLinkExist());
    }

    @Test(priority = 3)
    public void isLoggedIn(){
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }



}
