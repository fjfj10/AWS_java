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
