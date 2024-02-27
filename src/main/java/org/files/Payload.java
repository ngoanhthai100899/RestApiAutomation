package org.files;

public class Payload {
    public static String AddPlace() {
        return """
                {
                    "location": {
                        "lat": -38.383494,
                        "lng": 33.427362
                    },
                    "accuracy": 50,
                    "name": "Thai",
                    "phone_number": "(+91) 983 893 3937",
                    "address": "90 Trinh Dinh Cuu",
                    "types": [
                        "shoe park",
                        "shop"
                    ],
                    "website": "https://google.com",
                    "language": "French-IN"
                }""";
    }

    public static String CoursePrice() {
        return """
                {
                  "dashboard": {
                    "purchaseAmount": 1162,
                    "website": "rahulshettyacademy.com"
                  },
                  "courses": [
                    {
                      "title": "Selenium Python",
                      "price": 50,
                      "copies": 6
                    },
                    {
                      "title": "Cypress",
                      "price": 40,
                      "copies": 4
                    },
                    {
                      "title": "RPA",
                      "price": 45,
                      "copies": 10
                    },
                    {
                      "title": "Appium",
                      "price": 36,
                      "copies": 7
                    }
                  ]
                }""";
    }

    public static String AddBook(String isbn, String aisle) {
        return String.format("""
                {
                    "name": "Kamasutra",
                    "isbn": "%s",
                    "aisle": "%s",
                    "author": "John foer"
                }""", isbn, aisle);
    }
}
