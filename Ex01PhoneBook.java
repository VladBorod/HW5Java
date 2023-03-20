
//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.


import java.util.*;
import java.util.HashMap;

public class Ex01PhoneBook {
    public static void main(String[] args) {
        Map<Person, List<Phone>> phoneBook = new HashMap<>();
//        Map<Person, List<Phone>> newPhoneBook = new HashMap<>();

        Scanner go = new Scanner(System.in);
        System.out.println("Введите функцию: \n" +
                "1. Внесение нового абонента. \n" +
                "2. Добавление нового номера абонента. \n" +
                "3. Поиск абонента по имени и фамилии. \n" +
                "4. Вывод телефонного справочника. \n" +
                "5. Удаление абонента. \n");

        int operation = 0;
        while (operation >= 0 && operation < 5){
            operation = go.nextInt();
            switch (operation){
                case 1:
//                    Добавление абонента.
                    subscriberAdder(phoneBook);
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
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 3:
//                    Поиск абонента.
                    subscriberSearcher(phoneBook);
//                    System.out.println("Ищем абонента по имени и фамилии: ");
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 4:
//                    Вывод всего справочника.
                    phoneBookOutput(phoneBook);
//                    System.out.println(phoneBookOutput(phoneBook));
                    System.out.println("Введите функцию: \n" +
                            "1. Внесение нового абонента. \n" +
                            "2. Добавление нового номера абонента. \n" +
                            "3. Поиск абонента по имени и фамилии. \n" +
                            "4. Вывод телефонного справочника. \n" +
                            "5. Удаление абонента. \n");
                    break;
                case 5:
                    System.out.println("Удаление абонента: ");
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
    public static Map<Person, List<Phone>> subscriberAdder(Map dict){
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите имя абонента: ");
        String name = in.nextLine().toUpperCase();
        Scanner lin = new Scanner(System.in);
        System.out.printf("Введите фамилию абонента: ");
        String lastName = lin.nextLine().toUpperCase();
        Scanner nm = new Scanner(System.in);
        System.out.printf("Введите номер телефона абонента, если у абонента несколько номеров - введите их через пробел: ");
        long number = nm.nextLong();

        dict.putIfAbsent(new Person(name, lastName), Arrays.asList(new Phone(number)));
        return dict;
    }
    public static Map<Person, List<Phone>> phoneBookOutput(Map<Person, List<Phone>> dict){

        dict.entrySet().forEach(
                entry -> entry.getValue().forEach(
                        phone -> {
                            Person person = entry.getKey();
                        System.out.println(person.name + "  " + person.lastName + "   " + phone.numberPhone);
                        }
                )
        );
        return dict;
    }
    public static Map<Person, List<Phone>> subscriberSearcher(Map<Person, List<Phone>> dict){
        Map<Person, List<Phone>> newPhoneBook = new HashMap<>();

        Scanner fn = new Scanner(System.in);
        System.out.println("Введите имя пользователя: ");
        String name = fn.nextLine().toUpperCase();
        Scanner fln = new Scanner(System.in);
        System.out.println("Введите фамилию пользователя: ");
        String lastName = fln.nextLine().toUpperCase();

//        newPhoneBook.put(new Person(name, lastName), new ArrayList<>(1));

        for (Map.Entry<Person, List<Phone>> i:dict.entrySet()) {
            if (newPhoneBook.containsKey(i.getKey())) {
                System.out.println(i.getKey());
                System.out.println(i.getValue());
            }
//        Person s;
//        for (Person id:dict.keySet()) {
//            if (id.containsKey(newPhoneBook.keySet())) {
//                return true;
//            }
//            return id.containsKey(newPhoneBook.keySet());
//        }
//        a = newPhoneBook.keySet();

            return dict;
        }
        return dict;
    }

}
class Phone{
    public long numberPhone;

    public Phone(long numberPhone){
        this.numberPhone = numberPhone;
    }

}
class Person{
    public String name;
    public String lastName;

    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {return String.format("%d %s", lastName, name);
    }

    @Override
    public boolean equals(Object s) {
        var t = (Person) s;
        return name == t.name && lastName == t.lastName;
    }
}
