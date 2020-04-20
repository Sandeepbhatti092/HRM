package com.applicationpages;

import com.applicationobjects.HomePageOR;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends GenericMethods {

    private static HomePageOR homePageOR;

    private static HomePage homePage;

    private HomePage(){
        System.out.println(" Creating Object for Homepage");

    }
    public static HomePage getInstance(){
        if (homePage==null){
            homePage=new HomePage();
            homePageOR= PageFactory.initElements(driver,HomePageOR.class);
        }
        return homePage;
    }

    // Write your application Behaviours

    @Step("Navigate to Register Page")
    public void navigate_To_Regsiter_Page(){

        boolean status=clickElement("Home", "Register", homePageOR.lnk_Register);
        if(status){
            getScreenshot();
        }else{
            getScreenshot();
            Assert.assertEquals(status,true,"Verification for registration page navigation");
        }

    }







}
