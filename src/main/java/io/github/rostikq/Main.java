package io.github.rostikq;

import io.github.rostikq.task01.ShipmentFacade;
import io.github.rostikq.task03.ExternalPartnerTrackingService;
import io.github.rostikq.task03.TrackingServiceProxy;
import io.github.rostikq.task2.*;
import io.github.rostikq.task4.NewPartnerScaleDevice;
import io.github.rostikq.task4.ScaleAdapter;
import io.github.rostikq.task4.StandardSystemScale;
import io.github.rostikq.task4.SystemScale;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ВАРІАНТУ 3: СЛУЖБА ДОСТАВКИ «ПОСИЛКА+» ===\n");

        // --- Завдання 1 ---
        System.out.println("--- ЗАВДАННЯ 1: Оформлення відправлення (Facade) ---");
        ShipmentFacade facade = new ShipmentFacade();
        facade.completeShipment("вул. Головна, 10, Чернівці", 3.5, "+380501112233");

        // Окреме використання підсистеми
        double isolatedCost = facade.getCostCalculator().calculate(2.0);
        System.out.println("[12:01] [Main] Окремо розрахована вартість для 2 кг: " + isolatedCost + " грн.\n");


        // --- Завдання 2 ---
        System.out.println("--- ЗАВДАННЯ 2: Додаткові послуги до відправлення (Decorator) ---");
        // 1. Звичайне відправлення
        Shipment shipment1 = new BasicShipment("Київ");
        System.out.println("Опис: " + shipment1.getDescription() + " | Вартість: " + shipment1.getCost() + " грн.");

        // 2. Додавання страхування, пакування та накладеного платежу
        Shipment shipment2 = new BasicShipment("Львів");
        shipment2 = new InsuranceDecorator(shipment2);
        shipment2 = new PackagingDecorator(shipment2);
        shipment2 = new CashOnDeliveryDecorator(shipment2);
        System.out.println("Підсумок 1 -> Опис: " + shipment2.getDescription() + " | Вартість: " + shipment2.getCost() + " грн.\n");


        // --- Завдання 3 ---
        System.out.println("--- ЗАВДАННЯ 3: Звернення до системи трекінгу партнера (Proxy) ---");
        ExternalPartnerTrackingService realService = new ExternalPartnerTrackingService();
        TrackingServiceProxy proxy = new TrackingServiceProxy(realService);

        String trackingNum = "PKG-987654";
        // 1. Перший запит
        System.out.println("Статус 1: " + proxy.getTrackingStatus(trackingNum));

        // 2. Наступні 3 запити
        System.out.println("Статус 2: " + proxy.getTrackingStatus(trackingNum));
        System.out.println("Статус 3: " + proxy.getTrackingStatus(trackingNum));
        System.out.println("Статус 4: " + proxy.getTrackingStatus(trackingNum));

        System.out.println("Загальна кількість платних запитів до сервісу партнера: " + proxy.getPaidRequestsCount() + "\n");


        // --- Завдання 4 ---
        System.out.println("--- ЗАВДАННЯ 4: Підключення ваг партнера (Adapter) ---");
        // Підключення старих ваг
        SystemScale oldScale = new StandardSystemScale(5.0, 50.0);
        System.out.println("Відділення 1 (Старі ваги) -> Вага: " + oldScale.getWeightInKg() + " кг, Довжина: " + oldScale.getLengthInCm() + " см");

        // Підключення нових ваг
        NewPartnerScaleDevice newDevice = new NewPartnerScaleDevice();
        SystemScale adaptedScale = new ScaleAdapter(newDevice);
        System.out.println("Відділення 2 (Нові ваги через адаптер) -> Вага: " + adaptedScale.getWeightInKg() + " кг, Довжина: " + adaptedScale.getLengthInCm() + " см");

        System.out.println("\n=== УСІ СЦЕНАРІЇ УСПІШНО ВИКОНАНО ===");
    }
}
