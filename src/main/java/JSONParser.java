import java.util.ArrayList;

public class JSONParser {

    public static String toJSON(ArrayList<Results> collection) {
        StringBuilder json = new StringBuilder();
        json.append("[\n");
        if (collection.size() != 0) {
            for (int i = 0; i < collection.size(); i++) {
                if (i != collection.size() - 1) {
                    json.append(toJSON(collection.get(i))).append(",\n");
                } else {
                    json.append(toJSON(collection.get(i))).append("\n");
                }
            }
        } else {
            json.append("   {\n" +
                    "       \"result\": \"none\",\n" +
                    "       \"message\": \"\"\n" +
                    "}\n");
        }
        json.append("]");
        return json.toString();
    }

    public static String toJSON(Results results) {
        return "    {\n" +
                "       \"x\": \"" + results.getX() + "\",\n" +
                "       \"y\": \"" + results.getY() + "\",\n" +
                "       \"r\": \"" + results.getR() + "\",\n" +
                "       \"result\": \"" + results.isInArea() + "\",\n" +
                "       \"date\": \"" + results.getCreationDate() + "\",\n" +
                "       \"state\": \"" + results.isError() + "\",\n" +
                "       \"message\": \"" + results.getMessage() + "\"\n" +
                "   }";
    }
}
