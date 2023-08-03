package Prompt;
import java.util.Scanner;

public class PromptInt {
    // получить от пользователя Integer в заданом диапазоне
    public static Integer GetRequiredIntegerFromUser(String message, Scanner scan, int min, int max) {
        Integer input = GetIntegerFromUser(message, scan);
        while (input > max || input < min) {
            input = GetIntegerFromUser(message, scan);
        }
        return input;
    }

    // получить от пользователя Integer
    private static Integer GetIntegerFromUser(String message, Scanner scan) {
        System.out.println(message);
        String input = scan.nextLine();
        while (IsInteger(input) == false) {
            System.out.println(message);
            input = scan.nextLine();
        }
        return Integer.parseInt(input);
    }

    // проверка, если пользователь ввёл integer
    private static Boolean IsInteger(String st) {
        for (int i = 0; i < st.length(); i++) {
            char l = st.charAt(i);
            if (i == 0 && l == '0' && st.length() > 1) {
                return false;
            }
            if (!Character.isDigit(l)) {
                return false;
            }
        }
        return true;
    }

    
}
