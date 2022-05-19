import standard_first.Cleaner;


// реализация программы с определением объекта cleaner с отсылкой
// на интерфейс Cleaner и с написанием анонимного класса в фигурных
// скобках сразу после синтаксиса объекта cleaner


public class Ex2_anon_class {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner() {
            @Override
            public int clean(String user) {
                return user.length();
            }
        };

        System.out.println(cleaner.clean("Вениамин"));
    }
}
