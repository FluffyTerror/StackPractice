package org.FluffyTerror.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsManager {

    /**
     * Переменна для хранения данных считанных из файла properties и переданных пользователем
     * Т.е. Переменная для хранения пользовательских properties
     *
     * @see Properties - реализован на основе {@link java.util.Hashtable}
     */
    private final Properties properties = new Properties();


    /**
     * Переменна для хранения объекта PropsManager
     */
    private static PropsManager INSTANCE = null;


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     * Происходит загрузка содержимого файла application.properties в переменную {@link #properties}
     */
    private PropsManager() {
        loadApplicationProperties();
    }


    /**
     * Метод ленивой инициализации PropsManager
     *
     * @return PropsManager - возвращает PropsManager
     */
    public static PropsManager getPropsManager() {
        if (INSTANCE == null) {
            INSTANCE = new PropsManager();
        }
        return INSTANCE;
    }


    /**
     * Метод подгружает содержимого файла application.properties в переменную {@link #properties}
     * <p>
     * <p>
     * Либо из файла переданного пользователем через настройку -DpropFile={nameFile}
     */
    private void loadApplicationProperties() {
        String filePath = "src/main/resources/" + System.getProperty("propFile", "application") + ".properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод возвращает значения записанное в ключе в переменной {@link #properties}, если нет переменной вернет null
     *
     * @param key - ключ, значения которого хотите получить
     * @return String - строка со значением ключа
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
