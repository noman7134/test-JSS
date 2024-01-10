package com.noman.statisticsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Log")
public class StatisticsController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DeviceRepository deviceRepository;

    @Value("${DEVICE_REGISTRATION_URL}")
    private String serviceUrl;

    @PostMapping("/auth")
    public ResponseEntity<ApiResponse> logAuth(@RequestBody Device authLogDto) {
        try {
            
            ResponseEntity<String> response = restTemplate.postForEntity(
                serviceUrl,
                authLogDto, 
                String.class
            );
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(new ApiResponse(200, "success"));
            } else {
                return ResponseEntity.badRequest().body(new ApiResponse(400, "bad_request"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(400, "bad_request"));
        }
    }
    
    @GetMapping("/auth/statistics")
    public ResponseEntity<DeviceTypeCountDto> getDeviceStatistics(@RequestParam String deviceType) {
        try {
            long count = deviceRepository.countByDeviceType(deviceType);
            DeviceTypeCountDto response = new DeviceTypeCountDto(deviceType, count);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.ok(new DeviceTypeCountDto(deviceType, -1));
        }
    }
}
