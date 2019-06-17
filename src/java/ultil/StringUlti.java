package ultil;
public class StringUlti {
    public static String[] getDateParts(String date)
    {
        return date.split("-");
    }
    public static String getString(String value)
    {
        return value == null ? "" : value;
    }
    public static String getString(Object value)
    {
        return value == null ? "" : String.valueOf(value);
    }
}
