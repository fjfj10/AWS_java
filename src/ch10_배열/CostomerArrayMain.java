package ch10_배열;

public class CostomerArrayMain {

	public static void main(String[] args) {
		Customer[] customers = new Customer[10];
		
//		Customer customer1 = new Customer("김준일", "Gold");
//		Customer customer2 = new Customer("이동헌", "Silver");
//		Customer customer3 = new Customer("문근해", "vip");
		
		customers[0] = new Customer("김준일", "Gold");
		customers[1] = new Customer("이동헌", "Silver");
		customers[2] = new Customer("문근해", "vip");
		
		for(int i = 0; i < customers.length; i++) {
			if(customers[i] != null) {
				
				continue;
			}
//			System.out.println(customers[i]);
				customers[i].showInfo();
		}
		
//		customer1.showInfo();
//		customer2.showInfo();
//		customer3.showInfo();
	
	}

}
