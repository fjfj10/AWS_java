package ch14_싱글톤;

public class Samsung {
	private String companyName;
	private int autoIncrementSerialNumber;
	
	

	public Samsung() {
		super();
		this.companyName = "Samsung";
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

