package util;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManagerUtils {

    public static boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
