package GiftBox;

import javafx.scene.control.Menu;

//Собственно сам дочерний класс от Sweets
//Хотел еще сделать marmalade и т.д., но очень долго и так ковырялся. Думаю суть от этого не измениться =)

public class Candy extends Sweets {
    //у класса есть уникальный параметр: тип конфеты. Напободие шоколадная, леденец и т.д.
    //если бы Я сделал класс мармелада, у него бы была форма и цвет, например.
    String type;
    static int counter = 1;
    Candy(String name, String type, double price, double weight){
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
        sweetsList.add(this);
        MenuList.candyList.options.add(counter + ". " +this.name);
        counter ++;
    }


    @Override
    public void showInfo() {
        for (int i = 0; i < sweetsList.size(); i++) {
            System.out.println(i + ". " + "Название конфеты: " + name + ". Тип: " + type + ". Цена" +
                    price + ". Вес: " + weight);
        }
    }
}
