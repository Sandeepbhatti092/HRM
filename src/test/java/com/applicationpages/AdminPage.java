package com.applicationpages;

import com.applicationobjects.Admin_OR;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AdminPage extends GenericMethods {

    SoftAssert asrt = new SoftAssert();

    private static Admin_OR admin_or;

    private static AdminPage adminPage;

    private AdminPage() {
        System.out.println(" Creating Object for RegistrationPage");

    }

    public static AdminPage getInstance() {
        if (adminPage == null) {
            adminPage = new AdminPage();
            admin_or = PageFactory.initElements(driver, Admin_OR.class);
        }
        return adminPage;
    }
    @Step("Clicking on Admin Tab")
    //*********************** APPLICATION BEHAVIOUR*************************
public void clickAdminTab(){
        clickElement("Admin","Admin Tab",admin_or.adminTab);
}


}
