//        Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//        Написать программу, которая найдёт и выведет повторяющиеся имена
//        с количеством повторений. Отсортировать по убыванию популярности.

import java.util.*;
import java.util.stream.Collectors;

public class Ex02PeopleList {
    public static void main(String[] args) {
        Map<String, String> mainList = new HashMap<>();
        mainList.put("Иванов", "Иван");
        mainList.put("Петрова", "Светлана");
        mainList.put("Белова", "Кристина");
        mainList.put("Мусина", "Анна");
        mainList.put("Крутова", "Анна");
        mainList.put("Юрин", "Иван");
        mainList.put("Лыков", "Петр");
        mainList.put("Чернов", "Павел");
        mainList.put("Чернышов", "Петр");
        mainList.put("Федорова", "Мария");
        mainList.put("Светлова", "Марина");
        mainList.put("Савина", "Мария");
        mainList.put("Рыкова", "Мария");
        mainList.put("Лугова", "Марина");
        mainList.put("Владимирова", "Анна");
        mainList.put("Мечников", "Иван");
        mainList.put("Петин", "Петр");
        mainList.put("Ежов", "Иван");
//Создаем список.
        List<String> names = new ArrayList<>();
//Добавляем значения в список.
        for (String i:mainList.values()) {
            names.add(i);
        }
//Создаем новый словарь.
        Map<String, Integer> mp = new HashMap<>();
//Имена - ключи, подсчет уникальных ключей.
        Set<String> unique = new HashSet<>(names);
        for (String key : unique) {
            mp.put(key, Collections.frequency(names, key));
        }
//Скомунижжено, однако, элегантно!
        mp.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
