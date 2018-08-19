package Annotations_Training.Example1_Including_Analyzer;

import java.util.ArrayList;

public class PasswordCheckUtils {

    @UseCase(id = 1, description = "Check for numeric")
    public boolean isOneNumericExists(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 2)
    public String encryptPassword(String password) {
        StringBuilder stringBuilder= new StringBuilder(password);
        stringBuilder = stringBuilder.reverse();
        return stringBuilder.toString();
    }

    @UseCase(id = 3, description = "Password should repeat previously used")
    public boolean isPasswordPreviouslyUsed(ArrayList<String> prevPassword, String password) {
        return prevPassword.contains(password);
    }

    @UseCase(id = 4, description = "Is password long enough(min is 8 chars)")
    public boolean isPassLongEnough(String password) {
        int passLength = password.length();
        return (passLength>=8);
    }
}
