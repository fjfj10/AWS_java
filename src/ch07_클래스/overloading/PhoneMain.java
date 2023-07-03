package ch07_클래스.overloading;

public class PhoneMain {
	public static void main(String[] args) {
		Phone phone = new Phone();
		
		phone.send("안녕");
		phone.send("010-2218-8093", "안녕");
		
	}
}
