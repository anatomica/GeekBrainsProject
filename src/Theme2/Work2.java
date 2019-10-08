package Theme2;

import java.util.Scanner;
public class Work2 {
    public static void main(String[] args) {

        System.out.println("\nTask 1");
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0 ; i < array.length ; i ++) {
            if (array[i] == 1)
                array[i] = 0;
            else array[i] = 1;
            System.out.print (array[i] + " ");
        }
        System.out.println();

        System.out.println("\nTask 2");
        // 2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array2 = new int[8];
        int x = -3;
        for (int i = 0 ; i < array2.length ; i ++) {
            x = x + 3;
            array2[i] = x;
            System.out.print (array2[i] + " ");
        }
        System.out.println();

        System.out.println("\nTask 3");
        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        // пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int o: array3) {
            if (o < 6)
                System.out.print ((o * 2) + " ");
        }
        System.out.println();

        System.out.println("\nTask 4");
        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int [][] array4 = new int [5][5];
        for (int i = 0 ; i < array4.length ; i ++) {
            for (int j = 0; j < array4.length ; j++) {
                if (array4[i] == array4[j])
                    array4[i][j] = 1;
            }
        }
        printArr(array4);

        System.out.println("\nTask 5");
        // 5. Задать одномерный массив и найти в нем минимальный
        // и максимальный элементы (без помощи интернета);
        int [] array5 = {12, 5, 26, 77, 15, 32, 3, 87};
        int max = array5[0];
        int min = array5[0];
        for (int o: array5) {
            if (o > max)
                max = o;
            for (int u: array5) {
                if (u < min)
                    min = u;
            }
        }
        System.out.print ("Максимальное число из массива: " + max + "\n");
        System.out.print ("Минимальное число из массива: " + min + "\n");

        System.out.println("\nTask 6");
        // 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
        // checkBalance ([2, 1, 1, 2, 1]) → false,
        // checkBalance ([10, || 10]) → true, граница показана символами ||,
        // эти символы в массив не входят;
        System.out.println(checkBalance(new int[] { 1, 1, 1, 2, 1 }));
        System.out.println(checkBalance(new int[] { 2, 1, 1, 2, 1 }));
        System.out.println(checkBalance(new int[] { 10, 10 }));

        System.out.println("\nTask 7");
        // 7. *Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным или отрицательным), при этом метод
        // должен сместить все элементы массива на n позиций.
        // Нельзя пользоваться вспомогательными массивами.
        int argument = readArgument("Введите число для сдвига: ");
        modifyArray (new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, argument);

    }

    static int readArgument(String userText) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int argument = userInput.nextInt();
        return argument;
    }

    private static void printArr (int[][] arr) {
        for (int i = 0 ; i < arr.length ; i ++) {
            for (int j = 0; j < arr.length ; j++) {
                System.out.print (arr[i][j] + "\t");
            }
            System.out.println ();
        }
    }

    private static boolean checkBalance (int[] arr) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < arr.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    private static void modifyArray (int[] arr, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int gett = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = gett;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                int gett = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = gett;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println ();
    }

}