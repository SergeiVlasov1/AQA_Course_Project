[![Build status](https://ci.appveyor.com/api/projects/status/tutrf8r8y8wjs9yh/branch/master?svg=true)](https://ci.appveyor.com/project/SergeiVlasov1/aqa-course-project/branch/master)

# Курсовой проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»
## О проекте

Курсовой проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Описание приложения

### Бизнес часть

Приложение представляет из себя веб-сервис.

Приложение предлагает купить тур по определённой цене с помощью двух способов:
1. Обычная оплата по дебетовой карте
2. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

Приложение в собственной СУБД сохраняет информацию о том, каким способом был совершён платёж и успешно ли он был совершён.

### Документация

- [План автоматизации тестирования](https://github.com/SergeiVlasov1/AQA_Course_Project/tree/master/docs/TestPlan.md)
- [Отчет по итогам тестирования](https://github.com/SergeiVlasov1/AQA_Course_Project/blob/master/docs/Report.md)
- [Отчет по итогам автоматизации](https://github.com/SergeiVlasov1/AQA_Course_Project/blob/master/docs/Summary.md)

### Перед началом работы

1. Необходимо склонировать [репозиторий](https://github.com/SergeiVlasov1/AQA_Course_Project) с помощью команды `git clone` или воспользоваться VCS Git, встроенной в IntelliJ IDEA.
2. Установить [Docker](https://www.docker.com/), инструкция по установке по [ссылке](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md).
3. Открыть проект в Intellij IDEA, инструкция по установке по [ссылке](https://github.com/netology-code/javaqa-homeworks/blob/master/intro/idea.md).

### Запуск

***1. Запускаем docker-контейнер с СУБД MySQL и PostgreSQL, а также Node.js командой в терминале:***
```
docker-compose up -d
```
***2. Запускаем SUT***

Для этого открываем новую вкладку в терминале IDEA и вводим следующую команду:

- для СУБД MySQL:

```
java -jar artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app
```
- для СУБД PostgreSQL:
```
java -jar artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app
```

***3. Запускаем авто-тесты***

Для этого открываем еще одну вкладку в терминале и вводим следующую команду:

```
./gradlew clean test
```

***4. Генерируем отчет Allure по итогам тестирования***

Для запуска и просмотра отчета выполняем две команды по очереди:
```
./gradlew allureReport
```
```
./gradlew allureServe
```
Отчет открывается после прохождения тестов автоматически в браузере по умолчанию.
После просмотра отчета останавливаем действие allureServe комбинацией клавиш **Ctrl + C**.
## ***Завершение работы Sut***
Для завершения работы SUT, необходимо в терминале, где был запущен SUT, ввести команду:
```
 Ctrl+C
```
## ***Остановка и удаление контейнеров***
***1.*** Для остановки контейнеров в терминале IDEA вводим следующую команду:
```
docker-compose stop
``` 
***2.*** Для удаления контейнеров в терминале вводим команду:
```
docker-compose down
``` 
