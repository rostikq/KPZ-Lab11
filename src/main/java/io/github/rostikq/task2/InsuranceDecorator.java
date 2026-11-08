package io.github.rostikq.task2;

class InsuranceDecorator extends ShipmentDecorator {
    public InsuranceDecorator(Shipment shipment) { super(shipment); }
    @Override
    public String getDescription() { return wrappedShipment.getDescription() + " + Страхування"; }
    @Override
    public double getCost() {
        System.out.println("[12:05] [InsuranceDecorator] Додано вартість страхування: +50 грн");
        return wrappedShipment.getCost() + 50.0;
    }
}
