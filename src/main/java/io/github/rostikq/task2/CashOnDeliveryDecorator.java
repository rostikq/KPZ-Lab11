package io.github.rostikq.task2;

public class CashOnDeliveryDecorator extends ShipmentDecorator {
    public CashOnDeliveryDecorator(Shipment shipment) { super(shipment); }
    @Override
    public String getDescription() { return wrappedShipment.getDescription() + " + Накладений платіж"; }
    @Override
    public double getCost() {
        System.out.println("[12:05] [CashOnDeliveryDecorator] Додано комісію за накладений платіж: +40 грн");
        return wrappedShipment.getCost() + 40.0;
    }
}