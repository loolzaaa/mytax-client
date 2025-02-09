# API клиент для сервиса "Мой налог"

Данный клиент позволяет автоматизировать процесс отправки чеков
при осуществлении деятельности самозанятого. Для использования
клиента необходимо иметь учетную запись в сервисе "Мой налог",
вход в которую осуществляется по ИНН/паролю, иные способы аутентификации
не поддерживаются. Формирование чеков возможно как в синхронном,
так и в асинхронном режиме.

## Установка

### Maven

```xml
<dependency>
  <groupId>ru.loolzaaa.nalog.mytax</groupId>
  <artifactId>mytax-client</artifactId>
  <version>0.0.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'ru.loolzaaa.nalog.mytax:mytax-client:0.0.1'
```

## Использование

При создании экземпляра клиента можно задать префикс для идентификации
устройства/приложения, с которого будут осуществляться обращения к API.
Если такой необходимости нет, то префикс можно не задавать.
Примеры генерации идентификаторов:

- С префиксом `test_`: `test_dfSD36BsFs9dGh2B`
- Без префикса: `hsnG5Hd8fdh7uc4HHd3Nv`

Перед инициализацией клиента необходимо задать ИНН и пароль,
сохранив из в безопасном месте. В примерах ниже будут использованы
переменные окружения.

Для отправки чеков в налоговую необходимо создать перечень с оказанными
услугами, задав для каждой наименование, количество и стоимость.

После создания перечня остается отправить чек в синхронном или
асинхронном режиме, получив квитанцию с данными.

```java
import ru.loolzaaa.nalog.mytax.client.MyTaxClient;
import ru.loolzaaa.nalog.mytax.client.dto.AuthenticationDTO;
import ru.loolzaaa.nalog.mytax.client.pojo.Receipt;
import ru.loolzaaa.nalog.mytax.client.pojo.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyTaxClientTest {
    public static void main(String[] args) {
        final String username = System.getenv("MYTAX_INN"); // ИНН
        final String password = System.getenv("MYTAX_PASS"); // Пароль

        //MyTaxClient myTaxClient = new MyTaxClient(); // Без префикса
        MyTaxClient myTaxClient = new MyTaxClient("test_"); // С префиксом

        // В результате инициализации возвращается объект с данными
        // о пользователе
        AuthenticationDTO.Profile profile = myTaxClient.init(username, password);
        System.out.println(profile.getDisplayName()); // ИВАНОВ ИВАН ИВАНОВИЧ

        // Создание перечня оказанных услуг
        List<Service> services = List.of(
                new Service("Услуга 1", 2, 230.20),
                new Service("Услуга 2", 1, 500.00)
        );

        // В результате отправки чека будет сформирован объект,
        // который позволяет получить информацию по итоговой
        // квитанции
        Receipt receipt = myTaxClient.addIncome(services);
        System.out.println(receipt.jsonUrl()); // Данные квитанции в JSON формате
        System.out.println(receipt.printUrl()); // Данные квитанции для печати

        // Отправка чека возможна в асинхронном режиме
        // В результате отправки будет возвращен Future объект,
        // который позволяет получить результат позже
        CompletableFuture<Receipt> receiptFuture = myTaxClient.addIncomeAsync(services);
        receiptFuture.thenAccept(resultReceipt -> {
            // После отправки в данном случае можно сохранить данные
            // о квитанции в БД или осуществить иные действия
        });
    }
}
```