package ch08_생성자;

public class Student {
	
	final String name;   //final 상수 = 무조건 초가화가 일어나야한다(name = 필드)
	int age;
	String address;
	
/*자바는 생성자가 하나라도 생기는 순간 
 * 생략되어 존재하던 NoArgsCostructor가 사라짐 
 * 따라서 NoArgsCostructor나 requireArgsCostructor중 하나를 사용해준다.	
 */
//	Student() { 
//		System.out.println("NoArgsCostructor");
//		System.out.println("학생 한명을 생성합니다.");
//	}
	
	Student(String name, int age, String address) {
		System.out.println("AllArgsCostructor");
		this.name = name;    //지역변수와 멤버(필드)의 이름이 같을경우 this.을 붙여 주소를 표현해준다.
		this.age = age;
		this.address = address;
	}
	
	Student(String name) {
		System.out.println("requireArgsCostructor");
		this.name = name;
	}
	
	
}
