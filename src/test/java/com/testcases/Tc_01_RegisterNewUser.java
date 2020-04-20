package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.RegistrationPage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class Tc_01_RegisterNewUser extends GenericMethods {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Registration of new user")
    public void Tc_01_RegisterNewUser(){
        launchBrowser();
        HomePage homePage=HomePage.getInstance();
        homePage.navigate_To_Regsiter_Page();

        RegistrationPage registrationPage=RegistrationPage.getInstance();
        registrationPage.fillRegistartionForm();


    }
}
