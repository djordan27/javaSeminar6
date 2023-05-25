package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Урок 6. Хранение и обработка данных ч3: множество коллекций Set
 * Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
 * <p>
 * Создать множество ноутбуков.
 * <p>
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * <p>
 * “Введите цифру, соответствующую необходимому критерию:
 * <p>
 * 1 - ОЗУ
 * <p>
 * 2 - Объём ЖД
 * <p>
 * 3 - Операционная система
 * <p>
 * 4 - Цвет …
 * <p>
 * Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 * Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
 * ФИ -Филиппов Игорь, группа 3730
 */
public class App {
    public static void printMap(HashMap map) {
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(i + " laptop " + map.get(i));
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(myConfig.class);

        System.out.println("Hello World!");
        System.out.print("Введите количество отображаемых ноутбуков: ");

        int numOffLaptop = scanner.nextInt();
        HashMap map = new HashMap<>();
        for (int i = 1; i < numOffLaptop + 1; i++) {
            Laptop laptop = context.getBean("laptop", Laptop.class);
            map.put(i, laptop.getHashMap());
        }
        printMap(map);

        context.close();

        while (true) {
            System.out.println("You can choose notebook or write options\n please write 1 - choose or 2 - options");
            int userChoose = scanner.nextInt();
            if (userChoose == 1) {
                chooseLaptop(map);
                break;
            } else if (userChoose == 2) {
               map =  sortLaptop(map);

            } else {
                System.out.println("you entered an invalid value, please try again: ");
            }
        }
    }
    public static void chooseLaptop (HashMap<Integer,HashMap<String,Integer>> chooseMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please write the article number of the laptop: ");
        int articleNumberOfTheLaptop = scanner.nextInt();
        System.out.println("You choose laptop: ");
        System.out.println(chooseMap.get(articleNumberOfTheLaptop));
    }
    public static HashMap <Integer,HashMap<String,String>> sortMap
            (HashMap <Integer,HashMap<String,String>>map, String option, String value) {
        HashMap mySortMap = new HashMap<Integer,HashMap<String,String>>();
        int count = 1;
        for (int i = 1; i <= map.size(); i++) {
            if(option.equals("ram")||option.equals("hdd")) {
                int valueInt = parseInt(value);
                if (valueInt <= parseInt(map.get(i).get(option))) {
                    mySortMap.put(count, map.get(i));
                    count++;
                }
            } else if (option.equals("operating system")) {
                if(map.get(i).get("operating system").equals(value)) {
                    mySortMap.put(count, map.get(i));
                    count++;
                }
            } else if (option.equals("color")) {
                if(map.get(i).get("color").equals(value)) {
                    mySortMap.put(count, map.get(i));
                    count++;
                }
            }
        }

        return mySortMap;
    }
    public static HashMap<Integer,HashMap<String,String>> sortLaptop
            (HashMap<Integer,HashMap<String,String>> sortMapOfLaptop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number that matches the required criteria"
                + "\n1 - ram"
                + "\n2 - hdd"
                + "\n3 - operating system"
                + "\n4 - color");
        int userOption = scanner.nextInt();
        HashMap map = sortMapOfLaptop;
        String value;
        switch (userOption) {
            case 1:
                System.out.println("please write  minimum value of ram: ");
                value = scanner.next();
                map = sortMap(map, "ram", value);
                break;
            case 2:
                System.out.println("please write  minimum value of hdd: ");
                value = scanner.next();
                map = sortMap(map, "hdd", value);
                break;
            case 3:
                System.out.println("please write operating system: ");
                value = scanner.next();
                map = sortMap(map, "operating system", value);
                break;
            case 4:
                System.out.println("please write  color: ");
                value = scanner.next();
                map = sortMap(map, "color", value);
                break;


        }
        printMap(map);
        return map;
    }
}

