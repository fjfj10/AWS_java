package ch09_접근지정자.main;

public class Student2 {
	private String name;
	private int age;
	
	private void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
		test();
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//Getter
	public String getname() {
		return name;
	}
	
	public int getage() {
		return age;
	}
	
	
	
	
}
