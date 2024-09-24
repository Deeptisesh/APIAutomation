package Examples.Examples21092024.TestNGExamples.CRUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;



public class Test012_AsserjAssertion {

    // we need to add Assertj dependency in pom.xml
    @Test
    public void test_post() {
        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;
        Integer bookingID;

        String payload_post = "{\n" +
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
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload_post);

        response = requestSpecification.when().post();

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        //bookingID=response.jsonPath().getString("bookingid");
        bookingID = validatableResponse.extract().path("bookingid");
        System.out.println(bookingID);

       assertThat(bookingID).isNotNull().isNotZero();

    }

}
