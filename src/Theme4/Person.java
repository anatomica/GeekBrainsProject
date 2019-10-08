package Theme4;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int money;
    private int age;

    public Person (String name, String position, String email, String phoneNumber, int money, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.age = age;
    }

    public int getAge() {  // "геттер" для "age"
        return age;
    }

    public void printInfo() {
        System.out.println("Имя и фамилия: " + name + " Должность: " + position + " Email: " + email +
                " Номер телефона: " + phoneNumber + " Зарплата: " + money + " Возраст: " + age);
    }

}
