package GiftBox;

import java.util.ArrayList;

//класс описывает общую концепцую сладостей
//у них у всех должно быть имя, цена и вес. Так для удобства хранения всех
//сущевствующих сладостей независимо от дальнейшего "размножения" подклассов
//создан ArrayList<Sweets> sweetsList в который будут добавляться Все сладости при создании
//экзепляров класса

public class Sweets implements ShowInfo {
    static public ArrayList<Sweets> sweetsList = new ArrayList<>();
    protected double price = 0;
    protected double weight = 0;
    protected String name = null;

    @Override
    public void showInfo() {
        for (int i = 0; i < sweetsList.size(); i++) {
            System.out.println(i + ". Наименование: " + name);
        }
    }

}
