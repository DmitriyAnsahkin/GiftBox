//класс описывает основной тип данных в программе - "менюшки"
//Меню состоит из наименования самого меню и "плавающего" набора параметров
//которые задаются при создании экзепляра класса. Кол-во параметров каждом меню разное
//поэтому они записываются в ArrayList<String> options

package GiftBox;

import java.util.*;

public class Menu {
    String menuName;
    ArrayList<String> options = new ArrayList<String>();

    //единственный возможный контруктор, потому-что программа построена таким образом
    //что бы у меню обязательно было наименование, а пункты меню могут отсутствовать.
    Menu(String menuName, String... options) {
        for (int i = 0; i < options.length; i++) {
            this.options.add(options[i]);
            this.menuName = menuName;
        }
    }

    //печать меню
    void printMenu() {
        for (String option : this.options) {
            System.out.println(option);
        }
    }

    //метод считывания с клаиватуры с проверками корректности ввода данных и
    //и соответсвия предлагаемым вариантам на экране
    int navigation() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidOptions = false;
        int opt = 0;
        do {
            try {
                opt = scanner.nextInt();
                if (opt < 1 || opt > this.options.size()) {
                    isValidOptions = false;
                    System.out.println("Выберите пункт из предоставленного списка");
                } else isValidOptions = true;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неправильное значение");
                scanner.next();
            }
        } while (!isValidOptions);
        return opt;
    }
}


