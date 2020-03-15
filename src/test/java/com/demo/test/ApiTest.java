package com.demo.test;

import com.demo.automation.DataModel.DemoDataModel;
import com.demo.automation.Keywords.ApiKeywords;
import com.demo.automation.Keywords.IApiKeywords;
import com.demo.automation.Utulities.printToTxt;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ApiTest  {

    protected IApiKeywords apiKeywords =  new ApiKeywords();

    String endPoint = "https://my-json-server.typicode.com/typicode/demo/posts/1";
    String expectedResult = "Post 1";

    @Test
    public void Verify_API_GET_Posts() throws InterruptedException, IOException {
        HttpUriRequest request = RequestBuilder.get(endPoint).build();
        String jsonReponses = apiKeywords.makeRestRequest(request);
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        DemoDataModel dataModel = objectMapper.readValue(jsonReponses,DemoDataModel.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dataModel.getId(), 1);

        Reporter.log("</br>Test Case: Verify that the Posts api returns correct data. </br>");
        Reporter.log("</br>Step 1: Request " + endPoint);
        Reporter.log("</br>step 2: Check that data returned matches the expected result");
        Reporter.log("</br>ACTUAL RESULT: Data returned is : " + dataModel.getTitle());
        Reporter.log("</br>EXPECTED RESULT: " + expectedResult +"</br>");

        softAssert.assertEquals(dataModel.getTitle(),expectedResult, "This post is incorrect===> ");
        softAssert.assertAll();




//        String getTitle = dataModel.getTitle();
      //  printToTxt.WriteToFile("post1","result.txt");
    }
}
