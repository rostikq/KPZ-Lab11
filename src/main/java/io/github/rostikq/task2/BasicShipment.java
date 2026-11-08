package io.github.rostikq.task2;

public class BasicShipment implements Shipment {
    private String destination;

    public BasicShipment(String destination) {
        this.destination = destination;
    }

    @Override
    public String getDescription() {
        return "Відправлення до с. " + destination;
    }

    @Override
    public double getCost() {
        return 100.0; // Базова вартість
    }
}