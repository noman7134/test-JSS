package com.noman.deviceregistrationapi;



import com.noman.deviceregistrationapi.Device;
import com.noman.deviceregistrationapi.DeviceRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Device")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerDevice(@RequestBody Device device) {
        try {
        	Optional<Device> existingDevice = deviceRepository.findByUserKeyAndDeviceType(device.getUserKey(), device.getDeviceType());

            if (existingDevice.isPresent()) {
                return ResponseEntity.badRequest().body("Device already registered");
            }
            deviceRepository.save(device);
            return ResponseEntity.ok().body("Device registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error in device registration");
        }
    }
}
