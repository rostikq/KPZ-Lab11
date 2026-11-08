package io.github.rostikq.task4;

public class NewPartnerScaleDevice {
    public double readWeightInPounds() {
        System.out.println("[12:15] [NewPartnerScaleDevice] Зчитано вагу у фунтах: 22.0 lbs");
        return 22.0; // Наприклад, ~10 кг
    }

    public double readLengthInInches() {
        System.out.println("[12:15] [NewPartnerScaleDevice] Зчитано габарити в дюймах: 39.37 inches");
        return 39.37; // Наприклад, ~100 см
    }
}
