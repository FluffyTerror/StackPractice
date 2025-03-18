package org.FluffyTerror.utils;


import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ObjectUtils {
    /**
     * Общий метод для заполнения строковых значений для полей ввода
     *
     * @param element найденное поле
     * @param value значение вводимое в поле
     */
    public static void fillInputField(WebElement element, String value) {
            element.clear();
            element.sendKeys(value);// Вводим текст
    }

    /**
     * Общий метод для поиска полей ввода в классах
     *
     * @param pageClassName имя класса для которого ищем поле
     * @param fieldName имя поля которое ищем
     */
    public static WebElement getInputField(String pageClassName, String fieldName){
        try {
            Class<?> pageClass = Class.forName("org.FluffyTerror.pages." + pageClassName);
            Object PageInstance = pageClass.getDeclaredConstructor().newInstance(); //нужно, чтобы передать в field.get(), иначе не заработает
            Field field = pageClass.getDeclaredField(fieldName); // Ищем поле по имени в переданном классе
            field.setAccessible(true); // Делаем его доступным

            return (WebElement) field.get(PageInstance);// Получаем и возвращаем WebElement (Если передадим paeClass - получим IllegalAccessException)
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
