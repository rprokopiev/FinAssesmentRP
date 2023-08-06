import java.util.ArrayList;
import java.util.Scanner;

import Programm.ConsoleView;
import Units.BaseAnimal;

public class Main {
    public static ArrayList<BaseAnimal> animalList = new ArrayList<BaseAnimal>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsoleView.Start(scan, animalList);
        scan.close();
    }
}
