<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <h1>📦 StackPractice</h1>
    <p>
        Автоматизированные UI-тесты на Java + Selenium + Cucumber + Allure. Репозиторий создан для практики, оттачивания навыков и изучения BDD-подхода.
    </p>
    <h2>📌 О проекте</h2>
    <p>
        StackPractice — это коллекция UI автотестов для веб-приложений. Проект основан на стекe технологий:
    </p>
    <ul>
        <li>Java 11</li>
        <li>Selenium WebDriver</li>
        <li>Cucumber 7 (BDD)</li>
        <li>JUnit 5</li>
        <li>Allure Framework</li>
        <li>Maven</li>
    </ul>
    <h2>📥 Как скачать проект</h2>
    <p>Склонируйте репозиторий к себе на локальную машину:</p>
    <pre><code>git clone https://github.com/FluffyTerror/StackPractice.git</code></pre>
    <p>Перейдите в директорию проекта:</p>
    <pre><code>cd StackPractice</code></pre>
    <h2>🛠️ Установка и сборка</h2>
    <p>Убедитесь, что у вас установлены:</p>
    <ul>
        <li>JDK 11 или выше</li>
        <li>Maven</li>
    </ul>
    <p>Установите зависимости и соберите проект:</p>
    <pre><code>mvn clean install</code></pre>
    <h2>🚀 Запуск тестов</h2>
    <p>Для запуска всех тестов:</p>
    <pre><code>mvn test</code></pre>
    <h2>📊 Генерация отчета Allure</h2>
    <p>После выполнения тестов, для генерации красивого отчета:</p>
    <pre><code>allure serve target/reports/allure-results</code></pre>
    </code></pre>
    <h2>⚙️ Конфигурация</h2>
    <p>В <code>pom.xml</code> настроены следующие плагины:</p>
    <ul>
        <li><strong>maven-surefire-plugin</strong> — запуск тестов, фильтрация по тегам</li>
        <li><strong>allure-maven</strong> — генерация Allure отчета</li>
    </ul>
    <ul>
        <li><a href="https://docs.qameta.io/allure/" target="_blank">Документация Allure</a></li>
        <li><a href="https://cucumber.io/docs/guides/10-minute-tutorial/" target="_blank">Документация Cucumber</a></li>
    </ul>
</body>
</html>
