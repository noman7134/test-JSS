package com.noman.statisticsapi;



import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {
    

	long countByDeviceType(String deviceType);
	
}
