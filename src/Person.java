public class Person {
    private final String name;
    private int age;
    private final Gender gender;
    private boolean highedu;

    public Person(String name, Gender gender, int age, boolean highedu) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.highedu = highedu;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isHighedu() {
        return highedu;
    }

    @Override
    public String toString() {
        return  name + ", " + age + ", " + gender + ", в/о : " + (highedu ? "есть" : "нет");
    }
}
