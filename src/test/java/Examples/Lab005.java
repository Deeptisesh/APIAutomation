package Examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Lab005 {
    public static void main(String[] args) {
        //BBD style Post

        String payload="{\n" +
                "    \"firstname\" : \"sim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post()
                .then().statusCode(200);
    }
}
