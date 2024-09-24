package Examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab006 {
    public static void main(String[] args) {
        String bookingid="1034";
        String payload="{\n" +
                "    \"firstname\" : \"patrick\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        String auth="63aa45536cdf471  ";

        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.accept(ContentType.JSON);
        r.cookie("Token",auth);
        r.body(payload);

        Response response=r.when().put();

        ValidatableResponse vr=response.then().statusCode(200);

    }
}
