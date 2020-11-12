public class A5_q1 extends Thread {

	public void run() {
		for(int i=1;i<=100;i++) 
		{
			System.out.println(i);
			if (i%10 == 0) {
				System.out.println("Next 10 done");
			}
			try {
				Thread.sleep(1000);
			}
			catch(Exception e){}
		}
	}
	
	public static void main(String[] args) {

		A5_q1 newthread = new A5_q1();
		newthread.start();
	}
	
}
