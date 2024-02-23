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
}
