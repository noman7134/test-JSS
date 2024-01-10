package com.noman.statisticsapi;

public class DeviceTypeCountDto {
    private String deviceType;
    private long count;
    
    
	
    
    public DeviceTypeCountDto(String deviceType, long count) {
		super();
		this.deviceType = deviceType;
		this.count = count;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}


}
