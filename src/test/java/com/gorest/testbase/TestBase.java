package com.gorest.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void inIt() {

        RestAssured.baseURI = "https://gorest.co.in";               // RestAssured is a class
                                                                   // RestAssured.baseURI = PropertyReader.getInstance().getProperty("baseURI");

          RestAssured.basePath = "/public/v2" ;                                                      //Create property reader class as before
    }

}
