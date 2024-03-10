package org.files;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;

import java.util.Random;

public class ReUsableMethods {
    public static JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);
        return js;
    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        Random random = new Random();
        return new Object[][]
                {
                        {generateRandomString(random, 5), random.nextInt(1000) + ""},
                        {generateRandomString(random, 6), random.nextInt(1000) + ""},
                        {generateRandomString(random, 7), random.nextInt(1000) + ""}
                };
    }

    private String generateRandomString(Random random, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}
