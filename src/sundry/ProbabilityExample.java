package sundry;

import java.util.Random;

public class ProbabilityExample {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		double[] probabilities = {0.2, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
		
		int result = getRandomNumberWithProbability(numbers, probabilities);
		System.out.println("Random number with probability: " + result);
	}
	
	public static int getRandomNumberWithProbability(int[] numbers, double[] probabilities) {
		if(numbers.length != probabilities.length) {
			throw new IllegalArgumentException("The length of numbers and probabilities arrays should be the same.");
		}
		
		double randomValue = new Random().nextDouble();
		double cumulativeProbability = 0.0;
		
		for(int i = 0; i < numbers.length; i++) {
			cumulativeProbability += probabilities[i];
			if(randomValue < cumulativeProbability) {
				return numbers[i];
			}
		}
		//If no number is returned before this point, return the last number.
		return numbers[numbers.length - 1];	
	}
// 문자열일때
//	public static void main(String[] args) {
//		String[] strings = {"Apple","Banana", "Cherry", "Date", ""Fig};
//		double[] probabilities = {0.3, 0.2, 0.1, 0.2, 0.2};
//		
//		String result = getRandomNumberWithProbability(strings, probabilities);
//		System.out.println("Random number with probability: " + result);
//	}
//	
//	public static String getRandomNumberWithProbability(String[] strings, double[] probabilities) {
//		if(strings.length != probabilities.length) {
//			throw new IllegalArgumentException("The length of strings and probabilities arrays should be the same.");
//		}
//		
//		double randomValue = new Random().nextDouble();
//		double cumulativeProbability = 0.0;
//		
//		for(int i = 0; i < strings.length; i++) {
//			cumulativeProbability += probabilities[i];
//			if(randomValue < cumulativeProbability) {
//				return strings[i];
//			}
//		}
//		//If no string is returned before this point, return the last string.
//		return strings[strings.length - 1];	
//	}
}
