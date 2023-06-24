package Homework.hw3;

import java.util.ArrayList;
import java.util.Random;

public class task4 {
    // 4) Найти среднее ариф. значение
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            mylist.add(rnd.nextInt(100));

        }
        System.out.println(mylist);
        double summ = 0;
        double result = 0;
        for (int i = 0; i < mylist.size(); i++) {
            summ += mylist.get(i);
        }
        result = summ / mylist.size();
        System.out.println(result);
    }
}
