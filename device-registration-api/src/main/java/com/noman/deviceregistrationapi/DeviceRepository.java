package com.noman.deviceregistrationapi;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {
    

	long countByDeviceType(String deviceType);
	Optional<Device> findByUserKeyAndDeviceType(String userKey, String deviceType);
}
