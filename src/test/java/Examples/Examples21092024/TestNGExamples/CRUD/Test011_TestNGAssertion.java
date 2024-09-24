package Examples.Examples21092024.TestNGExamples.CRUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test011_TestNGAssertion {
    @Test
    public void test_post(){
        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;
        Integer bookingID;

        String payload_post="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "    \n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload_post);

        response=requestSpecification.when().post();

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        //bookingID=response.jsonPath().getString("bookingid");
        bookingID=validatableResponse.extract().path("bookingid");
        System.out.println(bookingID);
        // Hard Assert

        //Assert.assertEquals("booking.firstname","jim");
        Assert.assertNotNull(bookingID);

//        //SoftAssert
//        SoftAssert softAssert=new SoftAssert();
//        softAssert.assertEquals("","jim");
//        softAssert.assertAll();

        //return bookingID;

        // TestNG Assertion
    }
}
