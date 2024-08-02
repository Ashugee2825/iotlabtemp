package iotlab;

public class TempDTO {

	
	String temp;
	String deviceId;
	
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public void display() {
		
		System.out.println("Device Id= "+this.getDeviceId());
		System.out.println("Temperature= "+this.getTemp());
		
	}
	
	
	
	
	
	
	
}
