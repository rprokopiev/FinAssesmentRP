package Programm;

import java.util.ArrayList;
import java.util.Scanner;

import Prompt.PromptInt;
import Units.BaseAnimal;

public class ConsoleView {

    public static void Start(Scanner scan, ArrayList<BaseAnimal> animalList) {
        int cnt = 0;
        Boolean flag = true;
        int tmp = 0;
        while (flag == true) {
            if (animalList.size() == 0) {
                System.out.println("Реестр пуст, добавьте как минимум одно животное\n");
                try (Counter count = new Counter()) {
                    Counter.add(animalList, scan);
                    cnt = cnt + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tmp = PromptInt.GetRequiredIntegerFromUser("Хотите продолжить? (1-да, 2-нет)", scan, 1, 2);
                if (tmp == 2)
                    flag = false;
            }
            Integer choice = Prompt.PromptInt.GetRequiredIntegerFromUser(
                    "Выберите дальнейшее действие:\n" +
                            "1 - добавить животное\n" +
                            "2 - показать команды животного\n" +
                            "3 - обучить животное\n" +
                            "4 - выход\n",
                    scan, 1, 5);
            if (choice == 1) {
                try (Counter count = new Counter()) {
                    Counter.add(animalList, scan);
                    cnt = cnt + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                System.out.println(getBaseAnimal(animalList, scan).getCommands());
                tmp = PromptInt.GetRequiredIntegerFromUser("Хотите продолжить? (1-да, 2-нет)", scan, 1, 2);
                if (tmp == 2)
                    flag = false;
            } else if (choice == 3) {
                getBaseAnimal(animalList, scan).setCommands();
                tmp = PromptInt.GetRequiredIntegerFromUser("Хотите продолжить? (1-да, 2-нет)", scan, 1, 2);
                if (tmp == 2)
                    flag = false;
            } else {
                System.out.println("Пока!");
                flag = false;
            }
        }
    }

    private static BaseAnimal getBaseAnimal(ArrayList<BaseAnimal> animalList, Scanner scan) {
        int j = 1;
        System.out.println();
        System.out.println("№ - Тип - Дата рождения - Кличка");
        for (BaseAnimal baseAnimal : animalList) {
            System.out.printf("%d - %s - %s - %s\n", j, baseAnimal.getTypeName(), baseAnimal.getBirthDate(), baseAnimal.getName());
            j = j + 1;
        }
        Integer choice2 = Prompt.PromptInt.GetRequiredIntegerFromUser(
                "Выберите животное", scan, 1, animalList.size());
        return animalList.get(choice2 - 1);
    }

}
