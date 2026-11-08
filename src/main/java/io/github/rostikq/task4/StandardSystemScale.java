package io.github.rostikq.task4;

public class StandardSystemScale implements SystemScale {
    private double kg;
    private double cm;

    public StandardSystemScale(double kg, double cm) {
        this.kg = kg;
        this.cm = cm;
    }

    @Override
    public double getWeightInKg() {
        System.out.println("[12:15] [StandardSystemScale] Зчитано вагу (стандартні ваги): " + kg + " кг");
        return kg;
    }

    @Override
    public double getLengthInCm() {
        System.out.println("[12:15] [StandardSystemScale] Зчитано довжину (стандартні ваги): " + cm + " см");
        return cm;
    }
}