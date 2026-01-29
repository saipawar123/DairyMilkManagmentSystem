package src;
public class Utils {
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    public static boolean isValidMobile(String mobile) {
        return mobile.matches("\\d{10}");
    }
    public static double calculateRate(double fat) {
        return fat * 10;
    }
}