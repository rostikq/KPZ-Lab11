package io.github.rostikq.task2;

abstract class ShipmentDecorator implements Shipment {
    protected Shipment wrappedShipment;

    public ShipmentDecorator(Shipment shipment) {
        this.wrappedShipment = shipment;
    }

    @Override
    public String getDescription() {
        return wrappedShipment.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedShipment.getCost();
    }
}