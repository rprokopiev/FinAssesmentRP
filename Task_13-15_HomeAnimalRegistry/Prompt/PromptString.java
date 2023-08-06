// Получить строковое значение от пользователя

package Prompt;

import java.util.Scanner;

public class PromptString {

    public static String GetStringFromUser(Scanner scan, String message){
        System.out.println(message);
        String input = scan.nextLine();
        return input;
    }
}
