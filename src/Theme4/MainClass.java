package Theme4;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cat cat = new Cat(200, 2, -1, 3, false, "Барсик");
        Dog dog = new Dog(500, 0.5, 10);
        Dog dog1 = new Dog(700, 1, 15);

        System.out.println("Кошка может пробежать: " + cat.getDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getDistanceRun() +
                " м. \nСобака2 может пробежать: " + dog1.getDistanceRun() + " м. \n");

        System.out.println("Введите дистанцию для бега:");
        int distance = scanner.nextInt();

        System.out.println("Кошка: run(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Собака: run(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("Собака2: run(" + distance + "). Результат: " + dog1.run(distance) + "\n");

        System.out.println("Кошка может прыгнуть: " + cat.getDistanceJump() +
                " м. \nСобака может прыгнуть: " + dog.getDistanceJump() + " м. \n");

        System.out.println("Введите высоту препятствия:");
        distance = scanner.nextInt();

        System.out.println("Кошка: jump(" + distance + "). Результат: " + cat.jump(distance));
        System.out.println("Собака: jump(" + distance + "). Результат: " + dog.jump(distance) + "\n");

        System.out.println("Кошка не умеет плавать. \n" +
                "Собака может проплыть: " + dog.getDistanceSwim() + " м. \n");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextInt();

        System.out.println("Кошка не умеет плавать. Результат: " + cat.swim(distance));
        System.out.println("Собака: swim(" + distance + "). Результат: " + dog.swim(distance) + "\n");
    }
}