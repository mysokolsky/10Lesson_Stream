
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1_stream {
    public static void main(String[] args) {


        // ТЕРМИНАЛЬНЫЕ МЕТОДЫ потоков (завершают поток конечным результатом
        //                              и после их невозможно применить другой метод)


        IntStream intStream = IntStream.range(0,100);   // range - метод IntStream, последовательно наполняющий
        // поток целыми числами от начального до конечного-1 с шагом 1
        System.out.println(intStream.reduce((x,y) -> x+y)); // reduce - метод последовательного сложения элементов,
        // когда x следующий принимает значение x+y текущее


        Stream<Integer> intList = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(intList.count()); // считает, сколько всего элементов в потоке


        Stream<String> stringStream = Stream.of("Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь");
        System.out.println(stringStream.findFirst()); // findFirst возвращает первый элемент потока

        IntStream intStream1 = IntStream.range(0,10);       // Поток от 0 до 9. цифра 10 в поток не включается!!
        System.out.println(intStream1.allMatch(x -> x<=9)); // allMatch проверяет каждый элемент потока удовлетворяет
        // выражению справа от лямбды или нет


        Stream<Character> charStream = Stream.of('а','б','в','г','д');       // Поток символов от а до д.
        System.out.println(charStream.anyMatch(x -> x=='о'));   // anyMatch проверяет, хотя бы один элемент потока удовлетворяет
        // выражению справа от лямбды или нет

        IntStream intStream2 = IntStream.of(17,-13,31,1,-599,23,431,37,33); // поток заданных целых чисел.
        System.out.println(intStream2.noneMatch(x -> x % 2 == 0));      // noneMatch проверяет, что ни один элемент потока не удовлетворяет
        // выражению справа от лямбды (остаток от деления на 2 = 0)

        Stream<String> stringStream2 = Stream.of("зима", "весна", "лето", "осень");
        List<String> stringList= stringStream2.toList(); // метод toList() конвертирует поток в список
        stringList.forEach(System.out::println);         // метод вывода каждого элемента списка

        // метод collect преобразует поток в список:
        ArrayList<Integer> numbersInteger = new ArrayList<>(Stream.of(0,10,20,30).collect(Collectors.toList()));
        System.out.println(numbersInteger);

        Stream<Character> charStream2 = Stream.of('а','б','в','г','д','б','г');
        charStream2.collect(Collectors.toSet()).forEach(System.out::println);  // преобразуем поток в множество, где буквы не повторяются!

        Stream<Integer> intStream3 = Stream.of(17,-13,31,1,99,23,431,37,33);
        Optional<Integer> minInt = intStream3.min(Integer::compare); // Optional - это контейнер для объекта из потока,
        System.out.println(minInt);                                  // куда сохраняется минимальный элемент (метод min)


        Stream<Integer> intStream4 = Stream.of(317,67,31,1,-99,23);
        Optional<Integer> maxInt = intStream4.max(Integer::compare); // куда сохраняется максимальный элемент (метод max)
        System.out.println(maxInt);
//        intStream4.forEach(System.out::println.toString());

        // ПРОМЕЖУТОЧНЫЕ МЕТОДЫ ПОТОКОВ

//        IntStream numbers = IntStream.of(17,-13,31,-1,-599,23,431,37,33,31,-1);
        IntStream numbers = IntStream.range(-100,200);
//        System.out.println(
        numbers                       // для потока numbers

//                           .sorted()                      // сортирует все элементы потока от меньшего к большему
//                           .distinct()                    // пропускает только уникальные, не повторяющиеся элементы потока
//                           .dropWhile(x-> x < -50)           // метод отсекает элементы потока, которые <-50 до тех пор, пока не встретился любой элемент >= -50.
                // Тогда фильтр отключается и все остальные элементы пропускаются дальше
//                           .takeWhile(x -> x < 50)         // пропускает элементы потока, которые < 50 до тех пор, пока не встретился любой элемент >= 50.

//                           .filter (x-> x>-5 && x<6 )     // пропускаем дальше только элементы со значением -5 < x < 6
//                           .map(x->x*x)                 // возводим в квадрат каждый элемент
//                           .skip(4)                     // пропускаем дальше все кроме первых четырех элементов потока
//                           .limit(3)                    // пропускаем дальше только первые 3 элемента потока
//                           .reduce((x,y) -> x+y)        // считаем сумму попарных элементов. Это терминальная операция, завершающая поток
                .forEach(System.out::println); // Терминальная операция вывода каждого значения на экран
//        );


        Stream<String> strStream = Stream.of("Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь");
        Stream<String> strStream2 = Stream.of("зима", "весна", "лето", "осень");
        Stream<String> streamSum = Stream.concat(strStream,strStream2);  // объединение двух потоков в один
        streamSum.forEach(el -> System.out.println(el));


    }
}
