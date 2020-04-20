package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage_OR {

    @FindBy(xpath = "//input[@id='gender-male']")
    public WebElement rdo_Gender_Male;
    @FindBy(xpath = "//input[@id='gender-female']")
    public WebElement rdo_Gender_FeMale;
    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement edi_FirstName;
    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement edi_LastName;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement drp_Day;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement drp_Month;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement drp_Year;
    @FindBy(xpath = "//input[@name='Email']")
    public WebElement edi_Email;
    @FindBy(xpath = "//input[@name='Password']")
    public WebElement edi_Password;
    @FindBy(xpath = "//input[@name='ConfirmPassword']")
    public WebElement edi_CnfPassword;
    @FindBy(xpath = "//input[@name='register-button']")
    public WebElement btn_Register;
    @FindBy(xpath = "//div[text()='Your registration completed']")
    public WebElement txt_SuccessfullRegister;

}
