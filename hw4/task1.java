package Homework.hw4;
/*
 *
Даны два Deque, представляющие два целых числа.
Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
1) 123 * 345 = 42 435
Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа
 */



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Deque<Integer> digits_1 = create_random_deque();
        Deque<Integer> digits_2 = create_random_deque();

        String number_1 = string_from_deque(digits_1);
        String number_2 = string_from_deque(digits_2);

        int result_multi = Integer.parseInt(number_1) * Integer.parseInt(number_2);
        int result_summ = Integer.parseInt(number_1) + Integer.parseInt(number_2);
        System.out.printf("Multi: %,d\nSum: %,d\n", result_multi, result_summ);

        LinkedList<String> result_multi_ll = modif_string_to_ll(result_multi);
        LinkedList<String> result_summ_ll = modif_string_to_ll(result_summ);
    }

    public static LinkedList<String> modif_string_to_ll(int number) {
        List<String> num_list = Arrays.asList(Integer.toString(number).split(""));
        LinkedList<String> my_l_list = new LinkedList<>(num_list);
        System.out.printf("Result: %s\n", my_l_list);
        return my_l_list;
    }

    public static String string_from_deque(Deque<Integer> deque_num) {
        StringBuilder sb = new StringBuilder();
        for (int i = deque_num.size(); i > 0; i--) {
            // sb.append(String.format("%d", deque_num.pollLast()));
            sb.append(deque_num.pollLast().toString());
        }
        System.out.printf("The num: %,d\n", Integer.parseInt(sb.toString()));
        return sb.toString();
    }

    public static Deque<Integer> create_random_deque() {
        Random rnd = new Random();
        Deque<Integer> digits = new ArrayDeque<Integer>();
        for (int index = 0; index <= rnd.nextInt(9) ; index++) {
            digits.add(rnd.nextInt(9));
        }
        System.out.printf("Num in deque: %s\n", digits);
        return digits;
    }
}
