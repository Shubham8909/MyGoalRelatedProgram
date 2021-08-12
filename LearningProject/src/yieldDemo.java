
public class yieldDemo
{
	
	int xyz;
	public static void main(String[]args) throws InterruptedException
	{
		MyThread t = new MyThread();
		t.setName("T1");
		t.start();
		MyThread t1 = new MyThread();
		t1.setName("T2");
		t1.start();
		
		System.out.println(" in here");
		synchronized (t) {
			System.out.println(" t wait state in here");
			t.wait();
		}
		
		synchronized (t1) {
			System.out.println(" t1 wait state in here");
			t1.wait();
		}
		
	 
	}
}
// MyThread extending Thread
class MyThread extends Thread
{
	public void run()
	{
		
		synchronized (this) {
			
			System.out.println(" tread name -"+Thread.currentThread().getName());

			for (int i = 1; i <= 10; i++) {


				if (Thread.currentThread().getName().equalsIgnoreCase("T1")) {
					if (i % 2 != 0) {
						System.out.println("T1 -" + i);
						this.notify();
					}

				} else {
					if (i % 2 == 0) {
						System.out.println("T2 -" + i);
						this.notify();
					}

				}
			}
		}
	} 
}

// Driver Class

