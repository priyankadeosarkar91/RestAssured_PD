package tests;

public class Payload {
	public static String getJSONVal() {
		return("{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 16000,\n" +
                "    \"website\": \"www.testingshastra.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium\",\n" +
                "      \"price\": 5000,\n" +
                "      \"notes\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RestAPI\",\n" +
                "      \"price\": 1500,\n" +
                "      \"notes\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Java\",\n" +
                "      \"price\": 7500,\n" +
                "      \"notes\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Git\",\n" +
                "      \"price\": 1000,\n" +
                "      \"notes\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}");
	}

}
