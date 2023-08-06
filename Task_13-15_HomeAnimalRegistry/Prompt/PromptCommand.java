package Prompt;

import java.util.ArrayList;
import java.util.Scanner;

// Добавление команд в список команд

public class PromptCommand {

    public static ArrayList<String> addCommand(ArrayList<String> list) {
        Scanner scanner = new Scanner(System.in);
        if (PromptInt.GetRequiredIntegerFromUser("Добавить команду? (1-да, 2-нет)", scanner, 1, 2) == 1){
            Boolean flag = false;
            while (flag == false) {
                System.out.println("Введите название команды");
                String commandName = scanner.nextLine();
                System.out.println(commandName);
                int i = PromptInt.GetRequiredIntegerFromUser(
                        "Команда верна? (1 - да, 2 - нет)", scanner, 1, 2);
                if (i == 1) {
                    list.add(commandName);
                    i = PromptInt.GetRequiredIntegerFromUser(
                            "Добавить ещё одну команду? (1 - да, 2 - нет)", scanner, 1, 2);
                    if (i == 2) {
                        flag = true;
                    }
                }
            }
        }
        return list;
    }
}
