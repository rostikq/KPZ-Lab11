package io.github.rostikq.task4;

public class ScaleAdapter implements SystemScale {
    private NewPartnerScaleDevice externalScale;

    public ScaleAdapter(NewPartnerScaleDevice externalScale) {
        this.externalScale = externalScale;
    }

    @Override
    public double getWeightInKg() {
        double pounds = externalScale.readWeightInPounds();
        double kg = pounds * 0.453592; // Переведення фунтів у кілограми
        System.out.println("[12:15] [ScaleAdapter] Переведено фунти у кілограми: " + kg + " кг");
        return kg;
    }

    @Override
    public double getLengthInCm() {
        double inches = externalScale.readLengthInInches();
        double cm = inches * 2.54; // Переведення дюймів у сантиметри
        System.out.println("[12:15] [ScaleAdapter] Переведено дюйми у сантиметри: " + cm + " см");
        return cm;
    }
}