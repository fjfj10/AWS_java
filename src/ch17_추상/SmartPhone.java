package ch17_추상;

import lombok.ToString;

@ToString(callSuper = true)
public class SmartPhone extends SmartDevice implements Button{
	
	private String phoneNumber;
	
	public SmartPhone(String deviceName, double dispalySize, String phoneNumber) {
		super(deviceName, dispalySize);
		this.phoneNumber = phoneNumber;
		
	}
	@Override
	public void connectedWiFi() {
		System.out.println("스마트폰의 와이파이에 연결합니다.");

	}
	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void VolumUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void VolumDown() {
		// TODO Auto-generated method stub
		
	}
}
