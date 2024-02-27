package org.Basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.files.Payload;
import org.files.ReUsableMethods;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Main {
    public static void main(String[] args) {
        /*
        validate if Add Place API is working as expected
        given - all input details
        when - submit the API: resource, http method
        then - validate the response
        */
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String placeID = js.getString("place_id");
        System.out.println(placeID);

        /*
        Add place -> Update Place with New Address -> Get Place to validate if New Address is present in response
        Update Place
        */
        String newAddress = "90 Trinh Dinh Cuu 2";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(String.format("""
                        {
                            "place_id": "%s",
                            "address": "%s",
                            "key": "qaclick123"
                        }""", placeID, newAddress))
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get Place
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        //Cucumber Junit, TestNG
        Assert.assertEquals(actualAddress, newAddress);


    }
}