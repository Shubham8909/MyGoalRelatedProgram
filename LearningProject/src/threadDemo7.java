


public class threadDemo7 {
	public static void main(String[] args) throws InterruptedException {
		xiancheng1 x1=new xiancheng1();
		xiancheng2 x2=new xiancheng2();
		xiancheng3 x3=new xiancheng3();
		Thread thread1 = new Thread(x1);
		Thread thread2 = new Thread(x2);
		Thread thread3 = new Thread(x3);
		thread1.start(); 
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
	}

}

class xiancheng1 implements Runnable{

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Subthread 1=="+i);
		}
	}
	
}
class xiancheng2 implements Runnable{

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Subthread 2=="+i);
		}
	}
	
}
class xiancheng3 implements Runnable{

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Subthread 3=="+i);
		}
	}
	
}


