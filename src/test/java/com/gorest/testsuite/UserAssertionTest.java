package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest
{
    static ValidatableResponse response;

    @BeforeClass
    public void inIt()
    {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2" ;
    }

    @Test
    public void usersAssert()
    {
        response =
                given()
                        .queryParam("page" ,1)
                        .queryParam("per_page" ,20)
                        .when()
                        .get("/users")
                        .then()
                        .statusCode(200);

//        1. Verify  if the total record is 20
          response.body("size()" ,equalTo(20));

//        2. Verify  if the name of id = 5914126 is equal to ” Chidambaram Talwar”
          response.body("[9].name" ,equalTo("Chidambaram Talwar"));

//        3. Check the single ‘Name’ in the Array list (Malati Gupta II)
          response.body("[14].name" , equalTo("Dr. Datta Embranthiri"));

//        4. Check the multiple ‘Names’ in the ArrayList (Usha Kaul Esq., Akshita Mishra, Chetanaanand Reddy )
          response.body("name", hasItems( "Arnesh Singh", "Asha Pandey", "Charuvrat Reddy"));

//        5. Verify the email of userid = 5914121 is equal “dr_embranthiri_datta@casper-gerlach.test”
        response.body("[14].email" ,equalTo("dr_embranthiri_datta@casper-gerlach.test"));

//        6. Verify the status is “Active” of user name is “Bhadrak Singh”
       response.body("[2].status" ,equalTo("active"));

//        7. Verify the Gender = male of user name is “Dhanalakshmi Pothuvaal”
          response.body("[15].gender" ,equalTo("male"));

    }
}
