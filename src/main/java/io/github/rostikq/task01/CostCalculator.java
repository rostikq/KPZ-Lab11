package io.github.rostikq.task01;

class CostCalculator {
    public double calculate(double weight) {
        double cost = weight * 50.0;
        System.out.println("[12:00] [CostCalculator] Розраховано вартість: " + cost + " грн.");
        return cost;
    }
}
