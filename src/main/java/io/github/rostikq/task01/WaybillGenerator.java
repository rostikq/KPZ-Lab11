package io.github.rostikq.task01;

class WaybillGenerator {
    public String generateWaybill() {
        String number = "WB-" + System.currentTimeMillis() % 100000;
        System.out.println("[12:00] [WaybillGenerator] Згенеровано накладну: " + number);
        return number;
    }
}
