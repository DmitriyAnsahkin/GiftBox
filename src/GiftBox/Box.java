//класс описывает подарочную коробку, в которой лежат сладости
//так коробка только одна, дальнейшее расширение функционала в области работы
//с подарочными коробками !!!нет и не будет!!!
//этот класс сделан final что бы нельзя было создать подкласс, все объекты статические
//для того что бы не надо было даже создавать экзепляр класса для работы с коробкой
package GiftBox;

import java.util.*;

final public class Box {
    static private double price = 0;
    static private double weight = 0;
    static private Map<Sweets, Integer> content = new HashMap<>();

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Box.price += price;
    }

    public static double getWeight() {
        return weight;
    }

    public static void setWeight(double weight) {
        Box.weight += weight;
    }

    public static Map<Sweets, Integer> getContent() {
        return content;
    }

    public static void setContent(int x) {
        Sweets sweet = Sweets.sweetsList.get(x - 1);
        Integer count = content.get(sweet);
        if (count == null) {
            count = 0;
        }
        content.put(sweet, ++count);
        setPrice(Sweets.sweetsList.get(x - 1).price);
        setWeight(Sweets.sweetsList.get(x - 1).weight);
    }

    public static void showInfoBox() {
        if (content.isEmpty()) {
            System.out.println("Вы еще ничего не положили в коробку");
        } else {


            for (Map.Entry<Sweets, Integer> sweetsIntegerEntry : content.entrySet()) {
                System.out.println(sweetsIntegerEntry.getKey().name + ". " +
                        sweetsIntegerEntry.getValue() + " шт.");
            }
            System.out.println("Общая сумма подарка: " + price);
            System.out.println("Общий вес подарка: " + weight);
        }

    }

    public static void clearContentBox() {
        content.clear();
        price = 0;
        weight = 0;
    }

}
