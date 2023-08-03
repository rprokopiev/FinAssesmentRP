package Prompt;
import java.sql.Date;
import java.util.Scanner;

// получение даты рождения животного с ограниченим, исходя из максимальной продолжительности жизни животных.

public class PromptDate {

    static Integer minYear = 1980; // максимальная продолжительноть жизни
    static Integer maxYear = 2023;

    public static Date getDateFromUser(Scanner scan) {
        Date result;
        String year = "";
        String month = "";
        String day = "";
        Boolean flag = false;
        while (flag == false) {
            year = Integer.toString(PromptInt.GetRequiredIntegerFromUser(
                    String.format("Введите год рождения (%s-%s)", minYear, maxYear), scan, minYear, maxYear));
            month = Integer.toString(PromptInt.GetRequiredIntegerFromUser(
                    "Введите месяц рождения (1-12)", scan, 1, 12));
            day = Integer.toString(PromptInt.GetRequiredIntegerFromUser(
                    "Введите день рождения (1-31)", scan, 1, 31));
            System.out.println(Date.valueOf(year + "-" + month + "-" + day));
            int i = PromptInt.GetRequiredIntegerFromUser("Дата верна? (1 - да, 2 - нет)", scan, 1, 2);
            if (i == 1) {
                flag = true;
            }
        }
        result = Date.valueOf(year + "-" + month + "-" + day);
        return result;
    }
}
