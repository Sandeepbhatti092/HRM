package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOR {

    @FindBy(xpath = "//a[text()='Register']")
   public WebElement lnk_Register;

    @FindBy(xpath = "//a[text()='Log in']")
   public  WebElement lnk_Login;

    @FindBy(xpath = "//span[text()='Wishlist']/parent::a")
   public WebElement lnk_WishList;


}
