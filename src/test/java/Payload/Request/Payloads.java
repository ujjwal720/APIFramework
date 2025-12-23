package Payload.Request;

public class Payloads {

    public static String createPetPayload(
            int petId,
            int categoryId,
            String categoryName,
            String petName,
            String photoUrl,
            int tagId,
            String tagName,
            String status
    ) {
        return "{\n" +
                "  \"id\": " + petId + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": " + categoryId + ",\n" +
                "    \"name\": \"" + categoryName + "\"\n" +
                "  },\n" +
                "  \"name\": \"" + petName + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"" + photoUrl + "\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + tagId + ",\n" +
                "      \"name\": \"" + tagName + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }





}
