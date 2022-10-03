package hexlet.code.schemas;


public class NumberSchema {

    private static String validStatus = "Empty";

    private static int rangeFrom;

    private static int rangeTo;

    public static boolean isValid(Integer number) {

        switch (validStatus) {
            case "Empty":
                return number == null;
            case "Required":
                return number != null;
            case "Positive":
                return number > 0;
            case "Range":
                return rangeFrom <= number && number <= rangeTo;
            default:
                System.out.println("Invalid validation parameter");
        }
        return false;
    }

    public static void required() {
        validStatus = "Required";
    }

    public final NumberSchema positive() {
        validStatus = "Positive";
        return this;
    }

    public final void range(int from, int to) {
        rangeFrom = from;
        rangeTo = to;
        validStatus = "Range";
    }


}
