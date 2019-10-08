package Theme4;
import java.util.Scanner;

public class MainClassCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cat[] catArray = new Cat[3]; // Массив котов
        catArray[0] = new Cat(200, 2, -1, 5, false, "Барсик");
        catArray[1] = new Cat(200, 2, -1, 6, false, "Пушистик");
        catArray[2] = new Cat(200, 2, -1, 7, false, "Рыжик");

        for (Cat value : catArray) {
            System.out.println("Кот " + value.Name + " может съесть еды: " + value.getFoodEat() + " ед.");
        }

        new Bowlful (0, 20); //Миска (Объем и содержание)

        System.out.println("\nВ миске сейчас еды: " + Bowlful.Food + " ед.");
        System.out.println("Максимальный объем миски: " + Bowlful.MaxVolume + " ед.");
        System.out.println("\nВведите коллическтво еды которое вы хотите добавить в миску: ");
        Bowlful.addFoodToBowlful(); // Вызов метода заполнения миски

        // Основной диалог (кормление котов)
        for (Cat cat : catArray) {
            int count = 0;
            int countEating = 0;
            while (true) {
                if (Bowlful.Food >= cat.getFoodEat() && (count == 0)) {
                    count++;
                    System.out.println("\nВы хотите покормить кота " + cat.Name + "? Введите: Да ИЛИ Нет ");
                    String Answer = scanner.next();
                    if (Answer.equals("Да") || Answer.equals("ДА") || Answer.equals("да")) {
                        Bowlful.Food = Bowlful.Food - cat.getFoodEat();
                        cat.Satiety = true;
                        countEating++;
                        System.out.println("\nКот съел " + cat.getFoodEat() + " ед." +
                                "\nВ миске осталось еды: " + Bowlful.Food + " ед.");
                    }
                }
                if (Bowlful.Food >= cat.getFoodEat() && (count == 1)) {
                    count++;
                    System.out.println("\nХотите еще покормить " + cat.Name + "? Введите: Да ИЛИ Нет ");
                    String Answer1 = scanner.next();
                    if (Answer1.equals("Да") || Answer1.equals("ДА") || Answer1.equals("да")) {
                        Bowlful.Food = Bowlful.Food - cat.getFoodEat();
                        cat.Satiety = true;
                        countEating++;
                        System.out.println("\nКот еще съел " + cat.getFoodEat() + " ед." +
                                "\nВ миске осталось еды: " + Bowlful.Food + " ед.");
                    }
                }
                if (Bowlful.Food < cat.getFoodEat()) {
                    System.out.println("\nВ миске осталось еды меньше, чем хочет кот!");
                    System.out.println("\nВведите коллическтво еды которое вы хотите добавить в миску: ");
                    Bowlful.addFoodToBowlful();
                }
                if (count == 2 && countEating == 0) {
                    catArray[0].Satiety = false;
                    System.out.println("\nОчень жаль, кот остался голодным! Сытость кота: " + cat.Satiety);
                    break;
                }
                if (count == 2 && countEating == 1) {
                    System.out.println("\nСытость кота: " + cat.Satiety);
                    break;
                }
                if (count == 2 && countEating == 2) {
                    System.out.println("\nКот больше съесть не может! Сытость кота: " + cat.Satiety);
                    break;
                }
            }
        }
    }
}