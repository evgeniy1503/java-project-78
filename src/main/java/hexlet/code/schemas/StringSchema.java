package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {

    private static List<String> substrings = new ArrayList<>();
    private static String validStatus = "Empty";
    private static int minLength;




    public static boolean isValid(String text) {

        switch (validStatus) {
            case "Empty":
                return text == null || text.equals("");

            case "Required":
                return !text.isEmpty();

            case "Contains":
                for (String str : substrings) {
                    if (!text.contains(str)) {
                        return false;
                    }
                }
                return true;

            case "Length":
                return text.length() >= minLength;

            default:
                System.out.println("Invalid validation parameter");
        }
        return false;
    }


    public static void required() {
        validStatus = "Required";
    }

    public final StringSchema contains(String str) {
        validStatus = "Contains";
        substrings.add(str);
        return this;
    }

    public final void minLength(int number) {
        validStatus = "Length";
        minLength = number;
    }

}

