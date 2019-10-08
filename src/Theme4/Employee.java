package Theme4;

public class Employee {
    private String name;
    private String position;
    private String email;
    private long phoneNumber;
    private int money;
    private int age;

    public Employee() {
        this.name = "Максим Фомин";
        this.position = "Врач";
        this.email = "maks@mail.ru";
        this.phoneNumber = 9261112233L;
        this.money = 90000;
        this.age = 36;
    }

    public void printInfo() {
        System.out.println("Имя и фамилия: " + name + " Должность: " + position + " Email: " + email +
                " Номер телефона: " + phoneNumber + " Зарплата: " + money + " Возраст: " + age);
    }
}
