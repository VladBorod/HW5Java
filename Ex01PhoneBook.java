
//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.
//java.lang.ClassCastException: java.util.Arrays$ArrayList cannot be cast to java.util.ArrayList из-за данной ошибки
// добавление дополнительного номера у меня не сработало!


import java.util.*;

public class Ex01PhoneBook {
    public static void main(String[] args) {
        Map<String, List<Long>> phoneBook = new HashMap<>();

        Scanner go = new Scanner(System.in);
        System.out.println("Введите функцию: \n" +
                "1. Внесение нового абонента. \n" +
                "2. Добавление нового номера абонента. \n" +
                "3. Поиск абонента по имени и фамилии. \n" +
                "4. Вывод телефонного справочника. \n" +
                "5. Удаление абонента. \n");

        int operation = 0;
        while (operation >= 0 && operation <= 5){
            operation = go.nextInt();
            switch (operation){
                case 1:
//                    Добавление абонента.
                    System.out.println(subscriberAdder(phoneBook));
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 2:
//                    Добавление номера для абонента.
                    System.out.println("Добавляем новый номер абонента: ");
                    subscriberNumberAdder(phoneBook);
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 3:
//                    Поиск абонента.
                    System.out.printf("Номер искомого абонента: ");
                    System.out.println(subscriberSearcher(phoneBook));
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 4:
//                    Вывод всего справочника.
                    System.out.println("Ваш справочник: ");
                    phoneBookOutput(phoneBook);
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 5:
                    System.out.println("Удаление абонента: ");
                    subscriberDeleter(phoneBook);
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                default:
                    System.out.println("Такой функции не предусмотрено, работа программы завершена.");
                    break;
            }
        }
        go.close();
    }
//Удаление пользователя.
    private static void subscriberDeleter(Map<String, List<Long>> dict) {
        Scanner fn = new Scanner(System.in);
        System.out.println("Введите имя и фамилию пользователя через пробел: ");
        String fullname = fn.nextLine().toUpperCase();
        if (dict.containsKey(fullname)){
            System.out.println("Пользователь удален!");
            dict.remove(fullname);
        }
    }
//Изменение номера телефона пользователя.
    private static String subscriberNumberAdder(Map<String, List<Long>> dict) {
        Scanner fn = new Scanner(System.in);
        System.out.println("Введите имя и фамилию пользователя через пробел: ");
        String fullname = fn.nextLine().toUpperCase();
        String someSub;
        if (dict.containsKey(fullname)) {
            someSub = String.valueOf(dict.get(fullname).toString());
            Scanner nn = new Scanner(System.in);

            System.out.println("Введите новый номер: ");
            List<Long> newNumber = new ArrayList<>();
                newNumber.add(Long.valueOf(nn.next()));
            dict.put(fullname,
                    newNumber);
        }else {
            someSub = "Такого абонента нет!";
        }
        return someSub;
    }
//Добавление пользователя.
    public static Map<String, List<Long>> subscriberAdder(Map dict){
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя и фамилию абонента: ");
        String fullName = in.nextLine().toUpperCase();

        Scanner nm = new Scanner(System.in);
        System.out.printf("Введите номер телефона абонента, если у абонента несколько номеров - введите их через пробел: ");
        List<Long> number = new ArrayList<>();
                number.add(Long.valueOf(nm.next()));

        dict.putIfAbsent(fullName, Arrays.asList(number));
        return dict;
    }
//Вывод всего справочника.
    public static void phoneBookOutput(Map<String, List<Long>> dict){

        System.out.println(dict);
    }
//Поиск пользователя.
    public static String subscriberSearcher(Map<String, List<Long>> dict) {

        Scanner fn = new Scanner(System.in);
        System.out.println("Введите имя и фамилию пользователя через пробел: ");
        String fullname = fn.nextLine().toUpperCase();
        String someSub;
        if (dict.containsKey(fullname)) {
            someSub = String.valueOf(dict.get(fullname).toString());
        }else {
            someSub = "Такого абонента нет!";
        }
        return someSub;
    }
}
