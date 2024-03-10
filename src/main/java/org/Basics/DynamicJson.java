package org.Basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.files.Payload;
import org.files.ReUsableMethods;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "BooksData", dataProviderClass = ReUsableMethods.class)
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().header("Content-Type", "application/json")
                .body(Payload.AddBook(isbn, aisle))
                .when().post("Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.get("ID");
        System.out.println(response);
        System.out.println(id);
        //delete book
    }
}
