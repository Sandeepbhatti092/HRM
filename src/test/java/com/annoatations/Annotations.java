package com.annoatations;

import com.genericmethods.GenericMethods;
import com.getconfigdetails.ReadConfigDeatils;
import com.readtestdata.ReadJsonData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Annotations extends ReadJsonData{

    @BeforeSuite
    public void beforeSuite(){
        ReadConfigDeatils readConfigDeatils=new ReadConfigDeatils();
        readConfigDeatils.loadProperties();

        ReadJsonData readJsonData=new ReadJsonData();
        readJsonData.loadJsonFile();
    }
    @BeforeMethod
    public void beforeMethod(Method m){
        testCase=m.getName().toString();
    }

    @AfterSuite
    public void afterSuite()
    {
        GenericMethods.driver.close();
        GenericMethods.driver.quit();
    }
}
