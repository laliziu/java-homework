package Homework.hw6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
public static void main(String[] args) throws Exception {

            MenuMain();

        }

        private static void MenuMain() {
            Scanner inputData = new Scanner(System.in);
            shop shop = new shop();
            shop.insertRandom(100);
            int inputAction = -1;
            int countingFilter = 1;
            Map<String, shop> filterLogs = new HashMap<>();

            System.out.println("Добро пожаловать!");
            while (true) {
                ActionsMenu();
                System.out.printf("Выберите действие: ");
                switch (inputAction = inputData.nextInt()) {
                    case 1:
                        System.out.println(shop);
                        break;
                    case 2:
                        shop.printMarkdownTable();
                        break;
                    case 3:
                        shop filtered = new shop();
                        filtered.notebookArrayList = shop.filter();
                        filterLogs.put(Integer.toString(countingFilter++),filtered);
                        System.out.println(filtered);
                        break;
                    case 4:
                        if (filterLogs.size() != 0) {
                            System.out.println(logsJournal(filterLogs));
                        } else {
                            Message("Журнал пуст - не произвели ни одной фильтрации.");
                        }
                        break;
                    case 5:
                        if (filterLogs.size() != 0) {
                            shop againFiltered = logsJournal(filterLogs);
                            String keyToPutMap = "";

                            // ищем ключ прошлой фильтрации для замены отфильтрованых ноутбуков на повторно фильтрованными ноутбуками
                            for (String key : filterLogs.keySet()) {
                                if (filterLogs.get(key).equals(againFiltered)) {
                                    keyToPutMap = key;
                                }
                            }

                            System.out.println("Было выбранно:");
                            System.out.println(againFiltered);

                            againFiltered.notebookArrayList = againFiltered.filter();
                            System.out.println(againFiltered);
                            filterLogs.put(keyToPutMap, againFiltered);

                        } else {
                            Message("Журнал пуст - не произвели ни одной фильтрации.");
                        }
                        break;
                    case 6:
                        if (filterLogs.size() != 0) {
                            logsJournal(filterLogs).printMarkdownTable();
                        } else {
                            Message("Журнал пуст - не произвели ни одной фильтрации.");
                        }
                        break;
                    case 7:
                        inputData.close();
                        System.exit(0);
                    default:
                        System.out.println("Ошибка!");
                        break;
                }
            }

        }

        private static shop logsJournal(Map<String, shop> filterLogs) {
            Scanner inputData = new Scanner(System.in);

            System.out.println("Доступные прошлые поиски по номера:");
            System.out.println(filterLogs.keySet());
            System.out.println("");


            System.out.printf("Выберите номер - ");
            String inputLogNum = inputData.next();
            return filterLogs.get(inputLogNum);
        }

        private static void ActionsMenu() {
            Message("1. Вывести все ноутбуки\n"+
                    "2. Вывести все в формате Markdown таблицы\n"+
                    "3. Отфильтровать по критериям\n"+
                    "4. Журнал прошлых поисков\n"+
                    "5. Отфильтровать прошлый поиск\n"+
                    "6. Вывести прошлый поиск\n   в формате Markdown таблицы\n"+
                    "7. Выход");
        }

        private static String repeat(int count, String with) {
            return new String(new char[count]).replace("\0", with);
        }

        private static void Message(String text) {
            System.out.println(text);
        }

}
