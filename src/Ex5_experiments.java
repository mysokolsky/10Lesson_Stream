//Реализовать задачу вывода на экран только чётных чисел массива
// при помощи лямбды в качестве функции над входным целым числом


public class Ex5_experiments {

    public static void main(String[] args) {

        //есть массив целых чисел
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};

        // объект func является функцией, принимающей на входе
        // целое число и выводящей это число(чётное) на экран, если остаток от деления на 2 = 0
        Solver func = (int el) -> {
            if (el % 2==0) {
                System.out.println(el);
            }
            return 0;
        };

        //вызов главного метода
        map(array,func);

    }

    //метод, в котором над каждым элементом num массива array происходит выполнение функции func
    public static void map(Integer[] massiv, Solver f){
        for (int num: massiv) {
            f.solve(num);

        }



    }




}
