package Test;

class Calculator{	
	
	public static void add(int num1, int num2) {
			System.out.println(num1 + num2);
	}

	public static void sub(int num1, int num2) {
			System.out.println(num1 - num2);
	}
	
	

}
public class CalculatorMain {
	public static void main(String[] args) {
		Calculator.add(10, 20);
		Calculator.sub(200, 100);
	}
}
//답
//public class Calculator {
//
//    public int add(int num1, int num2) {
//
//        return num1 + num2;
//
//    }
//
// 
//
//    public int add(int num1, int num2) {
//
//        return num1 - num2;
//
//    }
//
//}
//
// 
//
//public class Main{
//
//    public static void main(String[] args) {
//
//        Calculator calculator = new Calculator();
//
//        System.out.println( calculator.add(10, 20) );
//
//        System.out.println( calculator.sub(200, 100) );
//
//    }
//
//}