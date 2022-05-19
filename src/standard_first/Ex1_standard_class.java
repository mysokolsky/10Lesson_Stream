package standard_first;


// стандартное исполнение с написанием отдельного класса A.java
// и имплементацией интерфейса Cleaner.java


public class Ex1_standard_class {
    public static void main(String[] args) {
        A cleaner = new A();
        System.out.println(cleaner.clean("Иван"));
    }
}
