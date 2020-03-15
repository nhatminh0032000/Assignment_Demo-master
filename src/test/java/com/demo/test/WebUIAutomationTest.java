package com.demo.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class WebUIAutomationTest extends BaseTest{
    String userName = "admin@test.com";
    String password = "test123";
    String endPoint = "https://my-json-server.typicode.com/typicode/demo/posts/1";
//requests are submitted and approved in 2019
    @Test
    public void Requests_Total_Submitted_Approve_in_2019() throws InterruptedException {
        getLoginpage().LoginWith(userName, password);
        int number = getParentPortalPage().getApproved();
        System.out.println("Request Status = Approved && Date Submitted = 2019 is " + number);

        Reporter.log("</br>Test Cases: verify how many requests are submitted and approved in 2019 (Request Status = Approved && Date Submitted = 2019).");
        Reporter.log("</br></br>Step 1: Login to site ");
        Reporter.log("</br>Step 2: Open Students listing page");
        Reporter.log("</br>Step 3: Get total of requests which are submitted and approved in 2019");
        Reporter.log("</br></br>ACTUAL RESULT: </br> SUM(Approved Requests && Date Submitted = 2019) :  " + number);
    }
}
