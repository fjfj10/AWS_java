package ch14_싱글톤;

import java.time.LocalDate;

public class Samsung {
	
	private static Samsung instance;    //변수명 instance 고정  1
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000;
	
	

	private Samsung() {    //생성자는 private으로 고정    2
		companyName = Samsung.class.getSimpleName().toUpperCase();
		//		companyName = "Samsung";
	}
	
	public static Samsung getInstance() {    // getInstance로 고정    3
		if(instance == null) {
			instance = new Samsung();
		}
		
		return instance;
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
	
	
}

