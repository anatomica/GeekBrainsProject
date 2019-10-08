package Theme1;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Work {
    public static void main ( String args []) {
        //2 - Создать переменные всех пройденных типов данных, и инициализировать их значения
        byte a;
        a = 10;
        short b;
        b = 1000;
        int c;
        c = 111000;
        int d;
        d = 10;
        float e;
        e = 123.0f;
        double f;
        f = 15.111111;
        boolean bool;
        bool = true;
        char g;
        g = 'S';
        long h;
        h = 1000L;

        //3 - Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат
        int sum = getSum (a, b, c, d);
        System.out.println(sum);

        //4 Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
        // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
        Three (a, b);

        //5 - Написать метод, которому в качестве параметра передается целое число, метод должен
        //напечатать в консоль положительное ли число передали, или отрицательное
        int argument = Four ("Введите любое целое число: ");

        //6 - Написать метод, которому в качестве параметра передается целое число, метод должен
        //вернуть true, если число отрицательное
        readArgument ("Введите любое целое число: ");

        //7 - Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        //метод должен вывести в консоль сообщение «Привет, указанное_имя!»
        String operation = readStringArgument("Введите Ваше имя: ");
        System.out.println("Привет, " + operation);

        //8 - Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль
        int years = Nine ("Введите любой год: ");

    }
    //3 - Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат
    static int getSum (int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //4 Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
    // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
    static void Three (int a, int b) {
        boolean bool;
        if (((a + b) <= 20) && ((a + b) >= 10))
            bool = true;
        else
            bool = false;
    }

    //5 - Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное
    static int Four (String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int x = userInput.nextInt();
        if (x >= 0)
            System.out.println("Вы ввели положительное число");
        else
            System.out.println("Вы ввели отрицательное число");
        return x;
    }

    //6 - Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное
    static boolean readArgument (String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int x = userInput.nextInt();
            if ((x < 0) && (!(x >= 0)))
                return true;
            else
                return false;
    }

    //7 - Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    static String readStringArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        String argument = userInput.nextLine();
        return argument;
    }

    //8 - Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль
    static int Nine (String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int year = userInput.nextInt();
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
            System.out.println("Данный год високосный");
        else
            System.out.println("Этот год не високосный");
        return year;

        // 1) void myMethod(int a, String b) {}
        // 2) void myMethod(String b, int a) {}
        // Это две разных сигнатуры одного метода
    }

}
