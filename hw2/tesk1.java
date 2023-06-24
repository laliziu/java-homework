package Homework.hw2;

import java.util.HashMap;
import java.util.Map;

public class tesk1 {
    /*
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 *
 * Параметры для фильтрации:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".
 */

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moscow");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> map) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue() != null) {
                s.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
            }
        }
        s.delete(s.toString().length() - 5, s.toString().length());
        return s.toString();

    }

}
