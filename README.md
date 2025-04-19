# Java-Gradle

gradle clean smoke env -Denv=dev

Для запуска тестов в определенном окружении и с определенным тегом

Добавил Allure report, исп. команду для создания отчета
gradle allureReport

Добавлена возможность запускать тесты с разными браузерами
В dev.properties добавил параметр browser {chrome, firefox}
В фабрике браузеров добавил метод getBrowser, который возвращает нужный браузер в зависимости от параметра browser