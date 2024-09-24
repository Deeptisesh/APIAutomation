package Examples.Examples21092024.TestNGExamples.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {
    //Create a token
    //Create a booking
    // Perform a put request
    //Verify put is updated
    //delete the ID
    //Verify id is deleted with get request

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingID;

    @BeforeTest
    public String getToken(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse =response.then();
        validatableResponse.statusCode(200);

       token=response.jsonPath().getString("token");

        return token;


    }
    @BeforeTest
    public String getBookingID(){

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

        bookingID=response.jsonPath().getString("bookingid");

        return bookingID;
    }
    @Test
    public void test_updateBooking_PUT(){
//        getToken();
//        getBookingID();
        String payload_put="{\n" +
                "    \"firstname\" : \"hames\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 121,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload_put).log().all();

        response=requestSpecification.when().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);




    }
    @Test
    public void test_updateBooking_GET(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);

        response=requestSpecification.when().get();

       String firstname= response.jsonPath().getString("firstname");
        Assert.assertEquals(firstname,"hames");
        System.out.println(bookingID);
        System.out.println(firstname);

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);



    }
    @Test
    public void test_deleteBooking_DELETE(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        response=requestSpecification.when().delete();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);




    }
    @Test
    public void test_DeleteBooking_GET(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);

        response=requestSpecification.when().get();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(404);


    }


}
