package com.applicationpages;

import com.applicationobjects.HomePageOR;
import com.genericmethods.GenericMethods;
import com.getconfigdetails.ReadConfigDeatils;
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
    @Step("Logging into system")
public void login(){
    ReadConfigDeatils property=new ReadConfigDeatils();
        String userName=property.getProperty("USERNAME");
    String passWord=property.getProperty("PASSWORD");

    sendData("Login Page","User Name", homePageOR.userName, userName);
    sendData("Login Page","Password", homePageOR.passWord, passWord);
    clickElement("Login","Submit", homePageOR.login);

}






}
