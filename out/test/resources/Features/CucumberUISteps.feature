# language: ru

Функционал: проверка UI

  Предыстория:
    Допустим открыта страница по адресу "https://www.bspb.ru/"

  @UI @Deposits
  Сценарий:Проверка открытия страницы вкладов
    Когда пользователь нажимает на раздел "Вклады"
    И пользователь выбирает подраздел вклада "Все вклады"
    Тогда страница вкладов открыта
    Когда пользователь выбирает страницу вклада Весна
    Тогда страница вклада Весна открыта

  @UI @Career
  Сценарий:Проверка открытия баннеров карьеры
    Когда пользователь прокручивает страницу до баннера карьеры
    И пользователь нажимает на карточку с карьерой
    Тогда страница карьеры открыта
    Когда пользователь прокручивает страницу баннера карьеры в IT
    И пользователь нажимает карточку с карьерой в IT
    Тогда страница карьеры в IT открыта

  @UI @Cards
  Сценарий:Открытие страницы дебетовых карт
    Когда пользователь нажимает на раздел "Карты"
    И выбран подраздел карт "Дебетовые карты"
    Тогда страница c картами открыта

    # переделать под таблицу
  @UI @Cards
  Сценарий:Проверка открытия страницы карты Яркая
    Когда пользователь открывает страницу с картами
    Когда выбрана страница с картой Яркая
    Тогда страница c картой Яркая открыта
    Когда пользователь прокручивает страницу до полей для заполнения
    И заполняет поля значениями
      | Поля     | Значения |
      | Фамилия  | Иванович |
      | Имя      | Иван     |
      | Отчество | Иванов   |
   # И поле фамилии заполнено "Иванович"
   # И поле имя заполнено "Иван"
   # И поле отчества заполнено "Иванов"
    Тогда значения в полях валидны


  @UI @Credits
  Сценарий:Открытие страницы кредита
    Когда пользователь нажимает на раздел "Кредит"
    И пользователь выбрал подраздел кредита "Кредит наличными"
    Тогда страница c кредитами открыта


# переделать под таблицу
  @UI @Credits
  Сценарий: Калькулятор кредита
    Когда пользователь открывает страницу с кредитами
    И пользователь прокручивает страницу до калькулятора кредита
    Тогда поле суммы заполнено числом 1500000 и поле длительности заполнено 13 и общая сумма кредита "147 192"

  @Check
  Сценарий: Проверка дочернего элемента баннера карьеры
    Когда пользователь прокручивает страницу до баннера карьеры
    Тогда дочерний элемент баннера содержит текст "Карьера в БСПБ - "

  @Check
  Сценарий: Проверка отображения элемента баннера карьеры
    Когда пользователь прокручивает страницу до баннера карьеры
    Тогда баннер отображен

  @UI
  Сценарий: Проверка отображения карточек "Рекомендуемое"
    Когда пользователь прокручивает страницу до карточек с рекомендуемыми продуктами
    Тогда все карточки отображены