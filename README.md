# Java-Gradle

gradle clean test – запуск всех тестов с очисткой временных файлов
gradle test --tests SomeTestClass – запуск тестов определенного класса
gradle test --tests *SomeTestMethod – запуск конкретного метода

Фильтрация тестов
• includeTags 'smoke' – запуск тестов с тегом smoke
• excludeTags 'defect' – исключение тестов с тегом defect

gradle clean smoke запуск тестов с тегом smoke (можно использовать несколько тегов)

Через передачу имени проперти файла можно указать окружение
Например (dev, prod, test)

gradle clean env -Denv=test

Через передачу имени проперти файла можно указать окружение и использовать значения через библиотеку owner
Например (dev, prod, test)
Запуск теста через owner, только метода testOwner с проперти test
Можно использовать другие методы devOwner, prodOwner с проперти dev, prod
gradle clean test --tests "OwnerTest.testOwner" -Denv=test