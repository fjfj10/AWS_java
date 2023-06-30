package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public abstract class SmartDevice {
	private String deviceName;
	private Double displaySize;
	
	public abstract void connectedWiFi();

	}

