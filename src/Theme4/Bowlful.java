package Theme4;
import java.util.Scanner;

class Bowlful extends Cat {
    static int Food;
    static int MaxVolume;

    Bowlful(int _Food, int _MaxVolume) {
        Food = _Food;
        MaxVolume = _MaxVolume;
    }

    // Метод заполнения миски
    static void addFoodToBowlful() {
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
        while (true) {
            if (Bowlful.verifyAddFood(howMany)) {
                Food = howMany + Food;
                System.out.println("\nВ миске стало еды: " + Food + " ед.");
                break;
            } else {
                System.out.println("\nВы пытаетесь положить либо больше предела, либо отнять у миски то чего нет)");
                System.out.println("Введите, пожалуйста, заново: ");
                howMany = scanner.nextInt();
            }
        }
    }

    // Проверка на заполнение миски
    private static boolean verifyAddFood(int howMany) {
        boolean result = false;
        if (howMany > 0 && howMany <= MaxVolume && (howMany + Food <= MaxVolume)) {
            result = true;
        }
        return result;
    }
}

