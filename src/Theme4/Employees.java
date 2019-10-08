package Theme4;

public class Employees {
    public static void main(String[] args) {
        // Объявляем массив объектов
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000, 30);
        persArray[1] = new Person("Ivanov1 Ivan1", "Engineer", " ivivan1@mailbox.com ", "892312312", 30000, 50);
        persArray[2] = new Person("Ivanov2 Ivan2", "Engineer", " ivivan2@mailbox.com ", "892312312", 30000, 20);
        persArray[3] = new Person("Ivanov3 Ivan3", "Engineer", " ivivan3@mailbox.com ", "892312312", 30000, 55);
        persArray[4] = new Person("Ivanov4 Ivan4", "Engineer", " ivivan4@mailbox.com ", "892312312", 30000, 45);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printInfo();
            }
        }
    }
}
