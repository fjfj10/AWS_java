package ch10_배열;

public class Array01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[5];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;
		
//		int index = 0;
//                               배열의 갯수(길이)	
		for(int i = 0; i < numbers.length; i++ ) {
			System.out.println(numbers[i]);
		}
	
		int[] numbers2 = { 1, 2, 3, 4, 5 };    //배열은 만들고나면 늘릴수없다
		int[] numbers3 = new int [] { 6, 4, 8, 9, 10 };

		sum(numbers);
//		sum({ 1, 2, 3, 4, 5 }); 불가 
//		sum(new int [] { 6, 4, 8, 9, 10 }); 
	}

	public static void sum(int[] array) {
		int result = 0;
		for(int i = 0; i < array.length; i++) {
			result += array[i];
//		=  (result = result + array[i];)
		}
		System.out.println(result);
	}
	
}
