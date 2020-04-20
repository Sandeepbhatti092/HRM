package com.applicationpages;

import com.applicationobjects.HomePageOR;
import com.applicationobjects.RegistrationPage_OR;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPage extends GenericMethods {

    SoftAssert asrt = new SoftAssert();

    private static RegistrationPage_OR registrationPage_or;

    private static RegistrationPage registrationPage;

    private RegistrationPage() {
        System.out.println(" Creating Object for RegistrationPage");

    }

    public static RegistrationPage getInstance() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage();
            registrationPage_or = PageFactory.initElements(driver, RegistrationPage_OR.class);
        }
        return registrationPage;
    }

    //*********************** APPLICATION BEHAVIOUR*************************
    @Step("Fill registartion form")
    public void fillRegistartionForm() {
        String gender = getData("Gender", 1);
        String firstname = getData("FirstName", 1);
        String lastname = getData("LastName", 1);
        String day = getData("Day", 1);
        String month = getData("Month", 1);
        String year = getData("Year", 1);
        String email = getData("Email", 1);
        String[] arr=email.split("@");
        //abc@gnail.com
        SimpleDateFormat sdf=new SimpleDateFormat("HHmmSSSS");
        Date d=new Date();
        email=arr[0]+ sdf.format(d).toString()+"@"+arr[1];


        String password = getData("Password", 1);
        String cnfpassword = getData("ConfirmPassword", 1);
        boolean status;
        if (gender.toLowerCase().equals("male")) {
            status = clickElement("Registration", "Gender Male", registrationPage_or.rdo_Gender_Male);
            asrt.assertEquals(status, true, "Unable to click gender as male");
        } else {
            status = clickElement("Registration", "Gender Male", registrationPage_or.rdo_Gender_FeMale);
            asrt.assertEquals(status, true, "Unable to click gender as female");
        }

        //Send data to first name
        status = sendData("Registration", "First Name", registrationPage_or.edi_FirstName, firstname);
        asrt.assertEquals(status, true, "Unable to enter data for the field first name");
//Send data to last name
        status = sendData("Registration", "First Name", registrationPage_or.edi_LastName, lastname);
        asrt.assertEquals(status, true, "Unable to enter data for the field last name");
//select day
        status = selectDropDownByText("Registration", "Day", registrationPage_or.drp_Day, day);
        asrt.assertEquals(status, true, "Unable to select dropdown Day");

        status = selectDropDownByText("Registration", "Month", registrationPage_or.drp_Month, month);
        asrt.assertEquals(status, true, "Unable to select dropdown Month");

        status = selectDropDownByText("Registration", "Year", registrationPage_or.drp_Year, year);
        asrt.assertEquals(status, true, "Unable to select dropdown Year");

        status = sendData("Registration", "Email", registrationPage_or.edi_Email, email);
        asrt.assertEquals(status, true, "Unable to enter data for the field Email");

        status = sendData("Registration", "Password", registrationPage_or.edi_Password, password);
        asrt.assertEquals(status, true, "Unable to enter data for the field password");

        status = sendData("Registration", "Confirm Password", registrationPage_or.edi_CnfPassword, cnfpassword);
        asrt.assertEquals(status, true, "Unable to enter data for the field Confirm Password");
        getScreenshot();
        clickElement("Registration","Register",registrationPage_or.btn_Register);

        elementDisplayed("Registration","Successfull Message",registrationPage_or.txt_SuccessfullRegister,35);
        getScreenshot();
        asrt.assertAll();

    }




}
