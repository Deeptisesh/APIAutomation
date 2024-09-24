package Examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class Lab004 {

    // Non BDD style Post
    public static void main(String[] args) {
        String payload  = "{\n" +
                "    \"firstname\" : \"Sim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);
        Response response=r.when().post();
        ValidatableResponse vr= response.then();
        vr.statusCode(200);

        vr.statusLine("HTTP/1.1 200 OK");
         vr.body("booking.firstname", equalTo("Sim"));
         vr.body("booking.lastname", equalTo("Brown"));

         vr.body("booking.firstname",hasToString("Sim"));
         //vr.body("booking",equalToObject("<{firstname=Sim, lastname=Brown, totalprice=111, depositpaid=true, bookingdates={checkin=2018-01-01, checkout=2019-01-01}, additionalneeds=Breakfast}>"));



    }
}
