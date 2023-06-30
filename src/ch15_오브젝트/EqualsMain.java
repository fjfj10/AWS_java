package ch15_오브젝트;

public class EqualsMain {
	public static void main(String[] args) {
		KoreaStudent koreaStudent1 = new KoreaStudent("20230001", "변정민");
		KoreaStudent koreaStudent2 = new KoreaStudent("20230002", "정가영");
		KoreaStudent koreaStudent3 = new KoreaStudent("20230003", "정혜성");
		KoreaStudent koreaStudent4 = new KoreaStudent("20230001", "변정민");
		
		System.out.println(koreaStudent1 == koreaStudent4);     //메모리비교
		System.out.println(koreaStudent1.getStudentcode() == koreaStudent4.getStudentcode()
				&& koreaStudent1.getName() == koreaStudent4.getName());      //데이터(값)비교
		
		System.out.println(koreaStudent1.equals(koreaStudent4));
		System.out.println(koreaStudent1.equals(koreaStudent2));
		
	}
	
	
}
