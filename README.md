# Java-Gradle

gradle clean test – запуск всех тестов с очисткой временных файлов
gradle test --tests SomeTestClass – запуск тестов определенного класса
gradle test --tests *SomeTestMethod – запуск конкретного метода

Фильтрация тестов
• includeTags 'smoke' – запуск тестов с тегом smoke
• excludeTags 'defect' – исключение тестов с тегом defect