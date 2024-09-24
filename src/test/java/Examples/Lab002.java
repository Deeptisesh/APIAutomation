package Examples;

import io.restassured.RestAssured;

public class Lab002 {
    //BDD Style get
    public static void main(String[] args) {
        System.out.println("RestAssured Demo");
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/1").when().get().then().log().all().statusCode(200);


    }
}
