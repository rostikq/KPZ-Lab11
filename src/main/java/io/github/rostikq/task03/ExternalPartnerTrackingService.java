package io.github.rostikq.task03;

class ExternalPartnerTrackingService implements TrackingService {
    private int paidRequestsCount = 0;

    @Override
    public String getTrackingStatus(String trackingNumber) {
        paidRequestsCount++;
        System.out.println("[12:10] [ExternalPartnerTrackingService] ПЛАТНИЙ ЗАПИТ ДО ПАРТНЕРА №" + paidRequestsCount + " для посилки " + trackingNumber);
        return "В дорозі (Оновлено партнером)";
    }

    public int getPaidRequestsCount() {
        return paidRequestsCount;
    }
}
