package Examples;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab003 {

    // Non BDD style get
    public static void main(String[] args) {
        RequestSpecification req=RestAssured.given();

        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/1843");
        req.when().get();
        req.then().log().all().statusCode(200);


    }
}
