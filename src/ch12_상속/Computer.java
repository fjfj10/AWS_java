package ch12_상속;
//computer에 Product를 합친다
public class Computer extends Product {
	private String type;

//	public Computer() {
//		super("", 10);    //super = this 부모주소를 먼저 생성한다
//		System.out.println("컴퓨터 객체 생성");
//	}
	
	public Computer(String model, int price, String type) {
		super(model, price);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}






	public void setType(String type) {
		this.type = type;
	}

	

}
