package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {

    private static List<String> substrings = new ArrayList<>();
    private static boolean contains = false;
    private static boolean isEmpty = true;





    public static boolean isValid(String text) {

        if (isEmpty && (text == null || text.equals(""))) {
            return true;
        }

        if (!isEmpty && !text.isEmpty() && !contains) {
            return true;
        }
        if (contains) {
            for (String str : substrings) {
                if (!text.contains(str)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }


    public static void required() {
        isEmpty = false;
    }

    public final StringSchema contains(String str) {
        contains = true;
        substrings.add(str);
        return this;
    }

}

