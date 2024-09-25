package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем зубчатый массив для хранения температуры в течение года
        int[][] temperatures = new int[12][];
        Random random = new Random();

        // Определяем количество дней в каждом месяце
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Заполняем массив случайными температурами в зависимости от времени года
        for (int month = 0; month < 12; month++) {
            temperatures[month] = new int[daysInMonth[month]]; // Создаем массив для каждого месяца
            for (int day = 0; day < daysInMonth[month]; day++) {
                // Задаем диапазон температур в зависимости от месяца
                if (month >= 2 && month <= 4) { // Весна (март-май)
                    temperatures[month][day] = random.nextInt(15) + 5; // от 5 до 20
                } else if (month >= 5 && month <= 7) { // Лето (июнь-август)
                    temperatures[month][day] = random.nextInt(20) + 15; // от 15 до 35
                } else if (month >= 8 && month <= 10) { // Осень (сентябрь-ноябрь)
                    temperatures[month][day] = random.nextInt(15) + 5; // от 5 до 20
                } else { // Зима (декабрь-февраль)
                    temperatures[month][day] = random.nextInt(30) - 15; // от -15 до 15
                }
            }
        }

        // Ввод данных пользователя для получения температуры на указанную дату
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (1-12): ");
        int monthInput = scanner.nextInt() - 1;
        System.out.print("Введите день (1-" + daysInMonth[monthInput] + "): ");
        int dayInput = scanner.nextInt() - 1;

        // Вывод температуры на указанную дату
        System.out.println("Температура на " + (monthInput + 1) + "/" + (dayInput + 1) + ": " + temperatures[monthInput][dayInput] + "°C");

        // Поиск самых теплых и холодных дней
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;
        String minDate = "", maxDate = "";

        for (int month = 0; month < 12; month++) {
            for (int day = 0; day < temperatures[month].length; day++) {
                if (temperatures[month][day] < minTemp) {
                    minTemp = temperatures[month][day];
                    minDate = (month + 1) + "/" + (day + 1);
                }
                if (temperatures[month][day] > maxTemp) {
                    maxTemp = temperatures[month][day];
                    maxDate = (month + 1) + "/" + (day + 1);
                }
            }
        }

        // Вывод самых холодных и теплых дней
        System.out.println("Самый холодный день: " + minDate + " с температурой " + minTemp + "°C");
        System.out.println("Самый теплый день: " + maxDate + " с температурой " + maxTemp + "°C");

        // Вычисление средней температуры по каждому месяцу
        System.out.println("Средняя температура по месяцам:");
        for (int month = 0; month < 12; month++) {
            int sum = 0;
            for (int day = 0; day < temperatures[month].length; day++) {
                sum += temperatures[month][day];
            }
            double average = (double) sum / temperatures[month].length;
            System.out.println("Месяц " + (month + 1) + ": " + average + "°C");
        }
    }
}