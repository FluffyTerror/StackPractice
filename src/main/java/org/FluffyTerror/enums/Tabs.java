package org.FluffyTerror.enums;


import java.util.Arrays;

public enum Tabs {
    ALL_DEPOSITS("Все вклады") {
        public void selectMenu() {
            System.out.printf("Выбрано меню %s%n", name);
        }
    },
    CREDIT_CASH("Кредит наличными") {
        public void selectMenu() {
            System.out.printf("Выбрано меню %s%n", name);
        }
    },
    DEBIT_CARDS("Дебетовые карты") {
        public void selectMenu() {
            System.out.printf("Выбрано меню %s%n", name);
        }
    };


    final String name;

    Tabs(String name) {
        this.name = name;
    }

    public void selectMenu() {
        throw new RuntimeException("Для меню " + this.name + " не определен метод выбора");
    }

    public static Tabs extractValue(String initial)  {
        return Arrays.stream(Tabs.values())
                .filter(tab -> tab.name.equalsIgnoreCase(initial)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Не существует поля %s", initial)));
    }

}
