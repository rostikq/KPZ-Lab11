package io.github.rostikq.task03;

import java.util.HashMap;
import java.util.Map;

class TrackingServiceProxy implements TrackingService {
    private ExternalPartnerTrackingService realService;
    private Map<String, CachedStatus> cache = new HashMap<>();
    private static final long CACHE_TTL_MS = 3000;

    private static class CachedStatus {
        String status;
        long timestamp;
        CachedStatus(String status, long timestamp) {
            this.status = status;
            this.timestamp = timestamp;
        }
    }

    public TrackingServiceProxy(ExternalPartnerTrackingService realService) {
        this.realService = realService;
    }

    @Override
    public String getTrackingStatus(String trackingNumber) {
        long currentTime = System.currentTimeMillis();
        if (cache.containsKey(trackingNumber)) {
            CachedStatus cached = cache.get(trackingNumber);
            if ((currentTime - cached.timestamp) < CACHE_TTL_MS) {
                System.out.println("[12:10] [TrackingServiceProxy] Статус з кешу для " + trackingNumber);
                return cached.status;
            }
        }
        
        String status = realService.getTrackingStatus(trackingNumber);
        cache.put(trackingNumber, new CachedStatus(status, currentTime));
        return status;
    }

    public int getPaidRequestsCount() {
        return realService.getPaidRequestsCount();
    }
}
