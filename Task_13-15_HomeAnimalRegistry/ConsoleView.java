import java.util.ArrayList;
import java.util.Scanner;

import Prompt.PromptCommand;
import Prompt.PromptDate;
import Prompt.PromptString;
import Units.BaseAnimal;
import Units.Cat;

public class ConsoleView {
    public static ArrayList<BaseAnimal> animalList = new ArrayList<BaseAnimal>();
    public static ArrayList<String> comList = new ArrayList<String>();

    public static void main(String[] args) {
        comList = PromptCommand.addCommand(comList);
        Scanner scan = new Scanner(System.in);
        BaseAnimal a = new Cat(comList, PromptDate.getDateFromUser(scan), PromptString.GetStringFromUser(scan, "Do It"));
        System.out.println(a.getCommands());

    }

    private static void Display(Scanner scan, ArrayList<BaseAnimal> animalList) {
        Integer choice = Prompt.PromptInt.GetRequiredIntegerFromUser(
                "Выберите дальнейшее действие:\n" +
                        "1 - добавить животное\n" +
                        "2 - показать команды животного\n" +
                        "3 - обучить животное\n" +
                        "4 - выход\n",
                scan, 1, 5);
        if (choice == 1) {
            /*
             * добавление:
             * заправшиваем все данные (имя, дата рождения)
             * заправшиваем команды
             * предалаем выбор типа из таблицы с классами,
             * присваиваем ИД по порядку из реестра
             * из полученных данных содаём экз. класса,
             * создание котрого заполняет реестр строчкой
             */
        } else if (choice == 2) {
            System.out.println(getBaseAnimal(animalList, scan).getCommands());
        } else if (choice == 3) {
            getBaseAnimal(animalList, scan).setCommands();
        } else {
            System.out.println("Пока!");
        }
    }

    private static BaseAnimal getBaseAnimal(ArrayList<BaseAnimal> animalList, Scanner scan) {
        int i = 1;
        Integer choice2 = Prompt.PromptInt.GetRequiredIntegerFromUser(
                "Выберите животное", scan, 1, animalList.size());
        for (BaseAnimal baseAnimal : animalList) {
            System.out.println(i + " - " + baseAnimal.getName()
                    + " - " + baseAnimal.getTypeName());
            i = i + 1;
        }
        return animalList.get(choice2 - 1);
    }

}
