package org.Basics;

import io.restassured.path.json.JsonPath;
import org.files.Payload;
import org.files.ReUsableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumOfCourses(){
        JsonPath js = ReUsableMethods.rawToJson(Payload.CoursePrice());
        int count = js.getInt("courses.size()");
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
