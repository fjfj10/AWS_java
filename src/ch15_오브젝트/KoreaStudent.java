package ch15_오브젝트;

import java.util.Objects;

public class KoreaStudent {
	private String Studentcode;
	private String name;
	
	public KoreaStudent(String studentcode, String name) {
		super();
		this.Studentcode = studentcode;
		this.name = name;
	}
	
	/*
	 * @Override //@: 어노테이션 public boolean equals(Object obj) { //업캐스팅 KoreaStudent
	 * koreaStudent = (KoreaStudent) obj; //다운캐스팅 후 boolean equalsFlag =
	 * this.Studentcode.equals(koreaStudent.Studentcode) //값비교로 변경 ==> 재정의 &&
	 * this.name.equals(koreaStudent.name); return equalsFlag; }
	 */

	@Override
	public int hashCode() {    //hashCode는 주소값을 의미한다 
		return Objects.hash(Studentcode, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoreaStudent other = (KoreaStudent) obj;
		return Objects.equals(Studentcode, other.Studentcode) && Objects.equals(name, other.name);
	}

	public String getStudentcode() {
		return Studentcode;
	}
	
	public String getName() {
		return name;
	}



	public void showInfo() {
		System.out.println("학번: " + Studentcode);
		System.out.println("이름: " + name);
		System.out.println("===============================");
		
		
		
	}

	@Override    //showInfo 대신 
	public String toString() {
		return "KoreaStudent [Studentcode=" + Studentcode + ", name=" + name + "]";
	}
	
}
