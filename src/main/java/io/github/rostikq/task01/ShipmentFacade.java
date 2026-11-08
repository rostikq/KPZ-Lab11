package io.github.rostikq.task01;

public class ShipmentFacade {
    private AddressChecker addressChecker = new AddressChecker();
    private CostCalculator costCalculator = new CostCalculator();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private WaybillGenerator waybillGenerator = new WaybillGenerator();
    private RoutePlanner routePlanner = new RoutePlanner();
    private Notifier notifier = new Notifier();

    public void completeShipment(String address, double weight, String phone) {
        System.out.println("[12:00] [ShipmentFacade] Початок комплексного оформлення відправлення...");
        addressChecker.checkAddress(address);
        double cost = costCalculator.calculate(weight);
        paymentProcessor.processPayment(cost);
        waybillGenerator.generateWaybill();
        routePlanner.planRoute(address);
        notifier.notifyReceiver(phone);
        System.out.println("[12:00] [ShipmentFacade] Відправлення успішно оформлено однією операцією!\n");
    }

    public CostCalculator getCostCalculator() {
        return costCalculator;
    }
}
