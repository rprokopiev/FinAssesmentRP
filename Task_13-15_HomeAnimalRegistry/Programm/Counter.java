package Programm;

import java.util.ArrayList;
import java.util.Scanner;

import Prompt.PromptCommand;
import Prompt.PromptDate;
import Prompt.PromptInt;
import Prompt.PromptString;
import Units.BaseAnimal;
import Units.Camel;
import Units.Cat;
import Units.Dog;
import Units.Donkey;
import Units.Hamster;
import Units.Horse;

public class Counter implements AutoCloseable {
    
    private static int count;

    public static void add(ArrayList<BaseAnimal> list, Scanner scan) {
        count = 0;
        Boolean flag = true;
        int tmp = 0;
        while (flag == true) {
            ArrayList<String> comList = new ArrayList<String>();
            Integer i = PromptInt.GetRequiredIntegerFromUser("Выбор животного:\n" +
                    "1 - Кошка, 2 - Собака, 3 - Хомяк\n" +
                    "4 - Лошадь, 5 - Верблюд, 6 - Осёл.\n", scan, 1, 6);
            if (i == 1) {
                list.add(new Cat(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            } else if (i == 2) {
                list.add(new Dog(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            } else if (i == 3) {
                list.add(new Hamster(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            } else if (i == 4) {
                list.add(new Horse(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            } else if (i == 5) {
                list.add(new Camel(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            } else {
                list.add(new Donkey(PromptCommand.addCommand(comList),
                        PromptDate.getDateFromUser(scan),
                        PromptString.GetStringFromUser(scan, "Введите Кличку")));
            }
            tmp = PromptInt.GetRequiredIntegerFromUser("Добавить другое животное? (1-да, 2-нет)", scan, 1, 2);
            if (tmp == 2)
                flag = false;
            count = count + 1;
        }

    }

    @Override
    public void close() throws Exception {
        System.out.printf("%d добавлено\n", count);
    }
}
