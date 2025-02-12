package com.genericmethods;

import com.annoatations.Annotations;
import com.getconfigdetails.ReadConfigDeatils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GenericMethods extends Annotations {

    public static WebDriver driver;

    /**

     * @return boolean
     * @discription This method is used to launch the browser specified by the user
     */
    @Step("Launching the browser")
    public boolean launchBrowser(){
        boolean status=true;
        ReadConfigDeatils property=new ReadConfigDeatils();
        try
        {
            switch (property.getProperty("BROWSER").toLowerCase())
            {
                case "chrome":
                   // WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

            }
            //maximize the browser
            driver.manage().window().maximize();
            driver.get(property.getProperty(property.getProperty("EXECUTE_ENVIRONMENT")+"_APP_URL"));
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            getScreenshot();

        }catch(Exception e)
        {
            status=false;
        }
        return status;

    }

    /**
     *
     * @param pageName
     * @param elementName
     * @param element
     * @return boolean
     */
    @Step("Click the element {1} on the page {0}")
    public boolean clickElement(String pageName, String elementName, WebElement element){
        boolean status=true;
        try{
            Actions acc=new Actions(driver);
            acc.moveToElement(element).click(element).build().perform();

        }catch(Exception e){
            status=false;
        }
        return status;
    }

    /**
     *
     * @param pageName
     * @param elementName
     * @param element
     * @return
     */
    @Step("Enter the data for the element {1} on the page {0}")
    public boolean sendData(String pageName, String elementName, WebElement element,String data){
        boolean status=true;
        try{
            Actions acc=new Actions(driver);
            acc.moveToElement(element).click(element).build().perform();
            element.clear();
            element.sendKeys(data);
        }catch(Exception e){
            status=false;
        }
        return status;
    }

    /**
     *
     * @param pageName
     * @param elementName
     * @param element
     * @param data
     * @return
     */
    @Step("Select the dropdown {1} with the value{3} on the page {0}")
    public boolean selectDropDownByText(String pageName, String elementName, WebElement element,String data){
        boolean status=true;
        try{
            Select select=new Select(element);
            select.selectByVisibleText(data);
        }catch(Exception e){
            status=false;
        }
        return status;
    }

    /**
     *
     * @param pageName
     * @param elementName
     * @param element
     * @param data
     * @return
     */
    @Step("Select the dropdown {1} with the value{3} on the page {0}")
    public boolean selectDropDownByValue(String pageName, String elementName, WebElement element,String data){
        boolean status=true;
        try{
            Select select=new Select(element);
            select.selectByValue(data);
        }catch(Exception e){
            status=false;
        }
        return status;
    }

    /**
     *
     * @param pageName
     * @param elementName
     * @param element
     * @param data
     * @return
     */
    @Step("Select the dropdown {1} with the value{3} on the page {0}")
    public boolean selectDropDownByIndex(String pageName, String elementName, WebElement element,int data){
        boolean status=true;
        try{
            Select select=new Select(element);
            select.selectByIndex(data);
        }catch(Exception e){
            status=false;
        }
        return status;
    }

    public boolean waitForEementToBeClickable(String pageName, String elementName,WebElement element,int sec){
        boolean status=true;
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean waitForElementToDisplay(String pageName, String elementName,WebElement element,int sec){
        boolean status=true;
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.visibilityOf(element));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Step("Verify the Element {1} is displayed on the page {0}")
    public boolean elementDisplayed(String pageName, String elementName,WebElement element,int sec){
        boolean status=true;
        try{
           waitForElementToDisplay(pageName,elementName,element,sec);
           if(element.isDisplayed())
           {
               System.out.println("Element is Displayed on the page");
           }else {
               System.out.println("Element is not Displayed on the page");
                          }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }





    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        TakesScreenshot sht=(TakesScreenshot)driver;
        return sht.getScreenshotAs(OutputType.BYTES);
    }












}
