package io.github.rostikq.task2;

public class PackagingDecorator extends ShipmentDecorator {
    public PackagingDecorator(Shipment shipment) { super(shipment); }
    @Override
    public String getDescription() { return wrappedShipment.getDescription() + " + Пакування"; }
    @Override
    public double getCost() {
        System.out.println("[12:05] [PackagingDecorator] Додано вартість пакування: +30 грн");
        return wrappedShipment.getCost() + 30.0;
    }
}
