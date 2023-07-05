 package ch24_쓰레드;

public class ThreadMain {
	
	public static void main(String[] args) {
//		스레드는 순서 상관 x  동시에 돌아간다
		Thread thread1 = new Thread(() ->{
			System.out.println("스레드 이름: " + Thread.currentThread().getName());          //currentThread: 현재 실행중안 스레드가 currentThread로 잡힘. 자기자신의 스레드 이름을 출력, 스레드를 구분할때 사용
			
			for(int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}                  //program에서 1000 = 1초
			}
		}, "1번 스레드");
		
		Thread thread2 = new Thread(() -> {
			System.out.println("스레드 이름: " + Thread.currentThread().getName());
			
			for(int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
			}	
		}, "2번 스레드");
		
		Thread thread3 = new Thread(new ThreadTest(), "3번 스레드");
		
		Thread thread4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("스레드 이름: " + Thread.currentThread().getName());
				System.out.println("4번 스레드 실행");
			}
		}, "4번 스레드");
		
		
		thread1.start();
//		try {
//			thread1.join();                                //join 사용: 스레드 1번의 동작이 끝날때까지 뒤 스레드 정지, 순서를 만들어준다
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		thread2.start();
//		thread3.start();
//		thread4.start();
	}
}
