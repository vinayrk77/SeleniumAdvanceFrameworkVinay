package com.vinaythetestingacademy.test.pageFactory_TestVWO;

import com.vinaythetestingacademy.base.CommonToAllTest;
import com.vinaythetestingacademy.driver.DriverManager;
import com.vinaythetestingacademy.pages.PageFactory.VWO.LoginPage_PF;
import com.vinaythetestingacademy.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;


public class TestVWOLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);


    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        LoginPage_PF loginPage_PF = new LoginPage_PF(DriverManager.getDriver());
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        logger.info("Error msg I got "+ error_msg);
        logger.info("Finished the Testcases Page Factory");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

}
