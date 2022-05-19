
//потренироваться использовать стримы.
//
//        взять строковый и числовые наборы данных и применить к ним максимально возможное количество нетерминальных операций
//
//        Выполнить преобразования результата из стрима в списки




import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams_10 {



    public static void main(String[] args) {


        List<Person> persons = getPersons();

        intro(persons);
        toEducate(persons);
        toWar(persons);
        averageYear(persons);
        sameNames(persons);
        children(persons);



    }


    private static void intro(List<Person> persons){
        System.out.println("\nЕсть предприятие, на котором заведена база данных сотрудников и их детей:\n");
        persons.forEach(System.out::println);

        System.out.println("\nСделаем выборку из базы по нескольким параметрам.\n");

    }

    private static void toEducate(List<Person> persons) {
        System.out.println("\nСписок мужчин предприятия старше 22 лет без высшего образования," +
                "\nотсортированных сначала по возрасту, потом по имени, которых планируется" +
                "\nотправить на двухгодичное обучение с учётом того, чтобы после обучения" +
                "\nим было не более 50 лет:\n");
        List<Person> toEducate = persons.stream()
                .filter(person -> person.getGender()== Gender.МУЖЧИНА
                        && person.getAge() > 22
                        && person.getAge()+2<=50
                        && !person.isHighedu())
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName))
                .toList();

        toEducate.forEach(System.out::println);
    }


    private static void toWar(List<Person> persons) {
        System.out.println("\nСписок всех военногодных мужчин предприятия:\n");
        List<Person> toWar = persons.stream()
                .filter(person -> person.getGender().equals(Gender.МУЖЧИНА)
                        && person.getAge()>=18
                        && person.getAge()<50)
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName))
                .toList();

        toWar.forEach(System.out::println);

    }

    private static void averageYear(List<Person> persons) {
        System.out.println("\nСредний возраст сотрудника предприятия:\n");

        int averageYear =
                (int)(Double.parseDouble(
                        persons.stream()
                                .filter(person -> person.getAge()>=18)
                                .mapToInt(Person::getAge)
                                .average()
                                .toString()
                                .replaceAll("[^0-9.]","")
                ));

        System.out.println(averageYear + " лет");

    }

    private static void sameNames(List<Person> persons) {
        System.out.println("\nПовторяющиеся имена сотрудников и их детей:\n");

        persons.stream()
                .collect(Collectors.groupingBy(Person::getName,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())
//                                .thenComparing(Map.Entry.comparingByKey())    // не удалось отсортировать по имени
                )
                .forEach(name -> {System.out.print(name.getKey() + ": "
                        + name.getValue() + " человек");

                    String addStr = "";

                    if (name.getValue()>1 && name.getValue()<5) {addStr = "a";}

                    System.out.println(addStr);
                });

    }

    private static void children(List<Person> persons) {
        System.out.println("\nДети сотрудников. Сначала мальчики, потом девочки. \nУпорядочены по возрасту и именам:\n");
        List<Person> children =
                persons.stream()
                        .filter(person -> person.getAge()<=18)
                        .sorted(Comparator.comparing(Person::getGender)
                                .thenComparing(Person::getAge)
                                .thenComparing(Person::getName))
                        .peek(entry -> System.out.println(entry.getName() +", "+ entry.getAge() + " лет" ))
                        .collect(Collectors.toList());


    }


    private static List<Person> getPersons(){
        return List.of(

                new Person("Николай", Gender.МУЖЧИНА,27,true),
                new Person("Регина",Gender.ЖЕНЩИНА,23,true),
                new Person("Денис",Gender.МУЖЧИНА,27,false),
                new Person("Александра", Gender.ЖЕНЩИНА,56,false),
                new Person("Давид",Gender.МУЖЧИНА,63,true),
                new Person("Валентина",Gender.ЖЕНЩИНА,19,false),
                new Person("Ира",Gender.ЖЕНЩИНА,4,false),
                new Person("Пётр",Gender.МУЖЧИНА,37,true),
                new Person("Вера",Gender.ЖЕНЩИНА,14, false),
                new Person("Роман",Gender.МУЖЧИНА,28,false),
                new Person("Родамир",Gender.МУЖЧИНА,43,true),
                new Person("Марина",Gender.ЖЕНЩИНА,35,true),
                new Person("Александра",Gender.ЖЕНЩИНА,37,true),
                new Person("Пётр",Gender.МУЖЧИНА,54,false),
                new Person("Николай",Gender.МУЖЧИНА,25,true),
                new Person("Наталья",Gender.ЖЕНЩИНА,17,false),
                new Person("Альберт",Gender.МУЖЧИНА,19,false),
                new Person("Роман",Gender.МУЖЧИНА,30,true),
                new Person("Екатерина",Gender.ЖЕНЩИНА,72,true),
                new Person("Вадим",Gender.МУЖЧИНА,9,false),
                new Person("Дарья",Gender.ЖЕНЩИНА,6,false),
                new Person("Рудольф",Gender.МУЖЧИНА,11,false),
                new Person("Роман",Gender.МУЖЧИНА,19,false)

        );
    }
}
