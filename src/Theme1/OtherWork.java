package Theme1;

public class OtherWork {
        //1. Класс Main
        public static void main(String[] args) {
            fieldInit();

            System.out.println("a * (b + (c / d)) = " + formula2(1,2,3,4));
            System.out.println(boolOpertation1(10, 11));
            checkNumSide(5);
            System.out.println(plusNumTrue(3));
            helloString("Customer");
            checkLeapYear(2017);
        }

        //2. Перечисление типов данных с значениями;
        private static void fieldInit () {
            System.out.println("Task 1. Field Init: ");
            boolean b = true;
            byte bt = 1;
            char c = 'x';
            short s = 12;
            int i = 113;
            long l = 123456L;
            float f = 789.0f;
            double d = 100.100;
            System.out.println("Field boolean = " + b);
            System.out.println("Field byte = " + bt);
            System.out.println("Field char = [" + c + "]");
            System.out.println("Field short = " + s);
            System.out.println("Field int = " + i);
            System.out.println("Field long = " + l);
            System.out.println("Field float = " + f);
            System.out.println("Field double = " + d);
        }

        //3. Вычислить выражение a * (b + (c / d)) и вернуть результат,

        private static int formula2 (int a, int b, int c, int d) {
            System.out.println("\nTask 2");
            return a * (b + (c / d));
        }

        //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
        //в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        private static boolean boolOpertation1(int a, int b) {
            System.out.println("\nTask 3");
            int sum = a + b;
            if (sum > 10 && sum < 20) return true;
            else return false;
        }

        //5. Определить знак числа. Ноль - положительный.
        private static void checkNumSide(int a) {
            System.out.println("\nTask 4");
            if (a >= 0) System.out.println("Positive number " + a);
            else System.out.println("Negative number" + a);
        }

        //6. Написать метод, которому в качестве параметра передается целое число, метод должен
        //вернуть true, если число отрицательное;
        private static boolean plusNumTrue(int a) {
            System.out.println("\nTask 5");
            if (a < 0) return true;
            return false;
        }

        //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        private static void helloString(String name) {
            System.out.println("\nTask 6");
            System.out.println("Hello, " + name + "!");
        }

        //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение
        //в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
        //– високосный.
        private static void checkLeapYear(int year) {
            System.out.println("\nTask 7");

            if (year % 100 != 0 && year % 4 == 0 || year % 400 ==0) {
                System.out.println(year + " leap year");

            } else System.out.println(year + " regular year");

        }
}