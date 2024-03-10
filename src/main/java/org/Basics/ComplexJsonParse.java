package org.Basics;

import io.restassured.path.json.JsonPath;
import org.files.Payload;
import org.files.ReUsableMethods;
import org.testng.Assert;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = ReUsableMethods.rawToJson(Payload.CoursePrice());
        System.out.println("//Print number of courses returned by API");
        int count = js.getInt("courses.size()");
        System.out.println(count);

        System.out.println("//Print purchase amount");
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        System.out.println("//Print title of the first course");
        String title = js.getString("courses[2].title");
        System.out.println(title);

        System.out.println("//Print all courses titles and their respective prices");
        for (int i = 0; i < count; i++) {
            String title2 = js.get("courses[" + i + "].title");
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int respectivePrice = price * copies;
            System.out.println("Course: " + title2 + " has price = " + respectivePrice);
        }

        System.out.println("//Print number of copies sold by RPA course");
        for (int i = 0; i < count; i++) {
            String title3 = js.getString("courses[" + i + "].title");
            if (title3.equalsIgnoreCase("RPA")) {
                int rpaCopies = js.getInt("courses[" + i + "].copies");
                System.out.println(rpaCopies);
                break;
            }
        }

        int sum = 0;
        System.out.println("//Verify if Sum of all course prices matches with purchaseAmount");
        for (int i = 0; i < count; i++) {
            int price2 = js.getInt("courses[" + i + "].price");
            int copies2 = js.getInt("courses[" + i + "].copies");
            int respectivePrice2 = price2 * copies2;
            sum = sum + respectivePrice2;
        }
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);
    }
}
