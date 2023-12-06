package Homework.hw5;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
Пример ввода:
Иванов 234234
Иванов 32523
Иванов 5687
Иванов: 234234, 32523, 5687

Варианты Map:
Map<String, ArrayList>
Map<String, String>

Пример меню:
1. Добавить контакт
2. Вывести всех
3. Выход */

public class task1 {
    public static void main(String[] args) throws IOException {

        mainMenu();

    }

    public static void mainMenu() throws IOException {
        Map<String, String> phonebookMAP = fileToHashMap();
        Scanner input_data = new Scanner(System.in);
        while (true) {
            System.out.printf("1. Добавить контакт\n" +
                    "2. Вывести всех\n" +
                    "3. Выход\n" +
                    "Выберите действие: ");
            String action_input = input_data.nextLine();
            switch (action_input) {
                case "1":
                    System.out.printf("Введите Фамилию и телефон: ");
                    String contact_input = input_data.nextLine();
                    addContact(phonebookMAP, contact_input);
                    break;
                case "2":
                    printHashMapSorted(phonebookMAP);
                    break;
                case "3":
                    input_data.close();
                    System.exit(0);
                default:
                    System.out.println("\nОшибка! Неверный ввод.\n");

            }
        }
    }

    public static Map<String, String> fileToHashMap() throws IOException {
        String pathDir = System.getProperty("user.dir");
        String pathFileName = pathDir.concat("\\Task1.txt");
        File phonebookFile = new File(pathFileName);

        if (phonebookFile.createNewFile()) {
            System.out.println("Создание новой телефонной книги!");
        }

        BufferedReader buffReader = new BufferedReader(new FileReader(phonebookFile));
        String str;

        Map<String, String> phonebookMAP = new HashMap<>();

        while ((str = buffReader.readLine()) != null) {
            phonebookMAP.put(str.split(":")[0].trim(), str.split(":")[1].trim());
        }
        buffReader.close();
        return phonebookMAP;
    }

    public static void printHashMap(Map<String, String> hashmap) {
        for (var contact : hashmap.entrySet()) {
            System.out.printf("%s: %s\n", contact.getKey(), contact.getValue());
        }
    }

    public static void printHashMapSorted(Map<String, String> hashmap) {
        String[] contactByPhones = new String[hashmap.size()];
        int index = 0;
        int countPhonesI = 0;
        int countPhonesJ = 0;
        String temp = "";
        for (var contact : hashmap.entrySet()) {
            contactByPhones[index++] = String.format("%s: %s", contact.getKey().trim(), contact.getValue().trim());
        }
        for (int i = 0; i < contactByPhones.length; i++) {
            countPhonesI = contactByPhones[i].split(":")[1].split(",").length;
            for (int j = i + 1; j < contactByPhones.length; j++) {
                countPhonesJ = contactByPhones[j].split(":")[1].split(",").length;
                if (countPhonesJ > countPhonesI) {
                    temp = contactByPhones[j];
                    contactByPhones[j] = contactByPhones[i];
                    contactByPhones[i] = temp;
                }
            }
            System.out.println(contactByPhones[i]);
        }
    }

    public static void addContact(Map<String, String> phonebook, String contactToAdd) throws IOException {
        String pathDir = System.getProperty("user.dir");
        String pathFileName = pathDir.concat("\\Task1.txt");
        File phonebookFile = new File(pathFileName);

        FileWriter fileWr = new FileWriter(phonebookFile, false);

        String[] contact = contactToAdd.split(" ");
        String name = contact[0].trim();
        String phonenumber = contact[1].trim();

        boolean isNameExist = phonebook.containsKey(name);
        boolean isPhoneExist = false;
        if (isNameExist) {
            if (!phonebook.get(name).isEmpty() && !phonebook.get(name).equals(" ")) {
                String phonesLine = phonebook.get(name);
                String[] phones = phonesLine.replaceAll(",", "").split(" ");

                for (String number : phones) {
                    if (number.equalsIgnoreCase(phonenumber)) {
                        isPhoneExist = true;
                    }
                }

                if (!isPhoneExist) {
                    System.out.println(repeat(80, "="));
                    System.out.printf("К существующему контакту %s\nC номерами телефонов %s\nДобавлен номер %s\n", name, phonesLine, phonenumber);
                    phonebook.put(name, phonesLine.concat(String.format(", %s", phonenumber)));
                } else {
                    System.out.printf("Введенный контакт %s, с номером %s уже существует\n", name, phonenumber);
                }
            } else {
                System.out.printf("У контакта %s отсутствовали номера телефонов\nДобавлен номер %s\n", name, phonenumber);
                phonebook.put(name, phonenumber);
            }
        } else {
            System.out.println(repeat(80, "="));
            System.out.printf("Добавлен новый контакт %s: %s\n", name, phonenumber);
            phonebook.put(name, phonenumber);
        }
        for (var contactLine : phonebook.entrySet()) {
            fileWr.write(String.format("%s: %s\n", contactLine.getKey().trim(), contactLine.getValue().trim()));
        }
        fileWr.flush();
        fileWr.close();
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
}
