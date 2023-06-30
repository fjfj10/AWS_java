package ch17_추상;

import lombok.ToString;

@ToString(callSuper = true)
public class Pad extends SmartDevice{

	private boolean avilabilityPen;

	public Pad(String deviceName, Double displaySize, boolean avilabilityPen) {
		super(deviceName, displaySize);
		this.avilabilityPen = avilabilityPen;
	}
	@Override
	public void connectedWiFi() {
		System.out.println("패드의 와이파이에 연결합니다.");	
	
	
}
}