package com.crm.qa.util;

import com.crm.qa.base.TestBase;

//the class first was created to manage timeouts as variables and not define them in code
//instead of this class you can define this variables in properties file and use them /like url, user . password/
public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 50;

    //switch frame method.use when needed.
    public void switchFrame(){
        driver.switchTo().frame("write the frame name here");

    }
}
