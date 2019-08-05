package utils;

public abstract class IStringUtils {
    public static boolean isEmpty(String str) {
        return (null == str || 0 == str.length());
    }
}
