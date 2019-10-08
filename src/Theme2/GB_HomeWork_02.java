package Theme2;

import java.util.Arrays;
public class GB_HomeWork_02 {
    public static void main(String[] args) {
        Task_1();
        Task_2();
        Task_3();
        Task_4();
        Task_5();
        System.out.println(Task_6(new int[]{1, 1, 1, 2, 1}));
        System.out.println(Task_6(new int[]{2, 1, 1, 2, 1}));
        System.out.println(Task_6(new int[]{10, 10}));
        Task_7(new int[]{11,12,13,14,15},7);
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void Task_1() {
        System.out.println("Task 1");
        int[] array10 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println("Массив" + Arrays.toString(array10));
        for (int i = 0; i < array10.length; i++) {
            if (array10[i] == 0) array10[i] = 1;
            else array10[i] = 0;
        }
        System.out.println("Реверс " + Arrays.toString(array10) + "\n");
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void Task_2() {
        System.out.println("Task 2");
        int dataField = 0;
        int[] array20 = new int[8];
        for (int i = 0; i < array20.length; i++, dataField = dataField + 3) {
            array20[i] = dataField;
        }
        System.out.println("Массив +3 -" + Arrays.toString(array20) + "\n");
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;

    private static void Task_3() {
        System.out.println("Task 3");
        int[] array30 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("До - " + Arrays.toString(array30));
        System.out.println("- ");

        for (int i = 0; i < array30.length; i++) {
            if (array30[i] < 6) array30[i] = array30[i] * 2;
        }
        System.out.println("После - " + Arrays.toString(array30) + "\n");
    }


    // Дрова для принта квадратами

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    private static void Task_4() {
        System.out.println("Task 4");
        int[][] array40 = new int[5][5];
        for (int i = 0; i < array40.length; i++) {

            for (int j = 0, j2 = array40[i].length; j < array40[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) array40[i][j] = 1;
            }
        }
        printArr(array40);
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    private static void Task_5() {
        System.out.println("Task 5");
        //int [] array50 = {2,10,45,44,33,22,66,44};
        int[] array50 = new int[10];

        for (int i = 0; i < array50.length; i++) {
            array50[i] = (int) (Math.floor(Math.random() * (100 - 1)) + 1);
        }
        int max = array50[0];
        int maxfield = 0;
        int min = array50[0];
        int minfield = 0;
        for (int i = 0; i < array50.length; i++) {
            if (array50[i] > max) {
                max = array50[i];
                maxfield = (i);
            }
            if (array50[i] < min) {
                min = array50[i];
                minfield = (i);
            }
        }
        System.out.println("Массив для анализа -" + Arrays.toString(array50));
        System.out.println("MAX = " + max + "Ячейка = " + maxfield);
        System.out.println("MIN = " + min + "Ячейка = " + minfield);
    }
    //6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;

    private static boolean Task_6(int[] arr) {
        System.out.println("Task 6");

        for (int i = 0; i < arr.length + 1; i++) {
            int leftSideSum = 0;
            int rightSideSum = 0;

            for (int j = 0; j < i; j++) {
                leftSideSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSideSum += arr[j];
            }
            if (leftSideSum == rightSideSum) return true;
        }
        return false;

    }
    private static void Task_7(int[] arrParam, int n) {
        System.out.println("Task 7");
        //посмотрим матрицу до сдвмга
        for (int i : arrParam) System.out.print(i + " ");
        System.out.println("\r\n");

        if (n > 0) {
            for (int x = 0; x < n; x++) {
                int buf = arrParam[arrParam.length - 1];
                if (arrParam.length - 1 >= 0) System.arraycopy(arrParam, 0, arrParam, 1, arrParam.length - 1);
                arrParam[0] = buf;
                //смотрим матрицу после каждого сдвига
                for (int i : arrParam) System.out.print(i + " ");
                System.out.println();
            }
        }
        if (n < 0) {
            for (int x = 0; x > n; x--) {
                int buf = arrParam[0];
                System.arraycopy(arrParam, 1, arrParam, 0, arrParam.length - 1);
                arrParam[arrParam.length - 1] = buf;
                //смотрим матрицу после каждого сдвига
                for (int i : arrParam) System.out.print(i + " ");
                System.out.print("\r\n");
            }
        }
    }
}
