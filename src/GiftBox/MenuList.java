package GiftBox;

import javax.swing.*;
import java.util.Map;
//класс создан как final и все переменные и методы в нем - статические
//Это нужно для того, что бы в этом классе описать всю логику работы программы
//не создавая экземпляров класса. Наследование запрещено т.к. это просто нелогично. Вся информация о
//логике находится сдесь и не должна передоваться куда-то
public final class MenuList {

    //сначала создаем всё меню
    static public Menu mainMenu = new Menu("mainMenu",
            "1. Добавить что-то в коробку",
            "2. Убрать что-то из коробки",
            "3. Посмотреть стоимость, вес и содержимое коробки",
            "4. Очистить коробку",
            "5. Купить собранную коробку",
            "6. Передумал собирать коробку. Уйти из магазина"
    );

    static public Menu addToBox = new Menu("addToBox",

            "1. Добавить конфету",
            "2. Добавить игрушку",
            "3. Назад"
    );

    static public Menu dropAtBox = new Menu("dropAtBox"

    );

    static public Menu clearBox = new Menu("clearBox",
            "1. Да, уверен.",
            "2. Нет. Вернуться назад"
    );

    static public Menu sureBuyBox = new Menu("sureBuyBox",
            "1. Да, уверен.",
            "2. Нет. Вернуться назад"
    );

    static public Menu candyList = new Menu("candyList"
    );

    //одним методом описываем результаты действий всех кнопок: переход в другие меню
    //или же вызов необходимых методов
    static public Menu menuSelect (Menu currentMenu, int x){
        if (currentMenu == mainMenu) {
            switch (x) {
                case 1:
                    return addToBox;
                case 2:
                    System.out.println("Простите, в данный момент функция недоступна. Воспользуйтесь полной очисткой коробки " +
                            "из главного меню");
                    return mainMenu;
                case 3:
                    Box.showInfoBox();
                    System.out.println();
                    return mainMenu;
                case 4:
                    return clearBox;
                case 5:
                    return sureBuyBox;
                case 6:
                    System.out.println("Жадина!! Беее >_>");
                    System.exit(0);
                    break;
            }
        }
        if (currentMenu == addToBox) {
            switch (x){
                case 1:
                    return candyList;
                case 2:
                    System.out.println("Извините, игрушки не предусмотренны в ранних версиях программы =)");
                    return mainMenu;
                case 3:
                    return mainMenu;
            }
        }

        if (currentMenu == clearBox){
            switch (x){
                case 1:
                    Box.clearContentBox();
                    return mainMenu;
                case 2:
                    return mainMenu;
            }
        }
        if (currentMenu == candyList){
            Box.setContent(x);
            return mainMenu;
        }
        if (currentMenu == sureBuyBox){
            switch (x){
                case 1:
                    System.out.println("Поздравляем с приобретением замечательного подарка!!! Удачи.");
                    System.exit(0);
                case 2:
                    return mainMenu;
            }
            Box.setContent(x);
            return mainMenu;
        }

        return mainMenu;
    }


}
