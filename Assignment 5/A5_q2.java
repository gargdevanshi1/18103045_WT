public class A5_q2 extends Thread
{
    static int max_count = 0, num = 0;
    int start;
    public A5_q2(int start)
    {
        this.start = start;
    }

    public void run()
    {
        for(int i=this.start; i<this.start+10000; i++)
        {
            int count=0;
            for(int j=1; j<=i; j++)
            {
                if(i%j==0)
                {
                    count++;
                }
            }
            if(count>max_count)
            {
                synchronized(this)
                {
                    max_count = count;
                    num = i;
                }
            }
        }
    }

    public static void main(String[] args)
    {
	      // make 10 new threads
        A5_q2 t1 = new A5_q2(1);
		    A5_q2 t2 = new A5_q2(10001);
	      A5_q2 t3 = new A5_q2(20001);
        A5_q2 t4 = new A5_q2(30001);
	      A5_q2 t5 = new A5_q2(40001);
        A5_q2 t6 = new A5_q2(50001);
	      A5_q2 t7 = new A5_q2(60001);
        A5_q2 t8 = new A5_q2(70001);
		    A5_q2 t9 = new A5_q2(80001);
        A5_q2 t10 = new A5_q2(90001);

	      // start timer
        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
        	t1.join();
        	t2.join();
        	t3.join();
        	t4.join();
        	t5.join();
        	t6.join();
        	t7.join();
        	t8.join();
        	t9.join();
        	t10.join();
        }catch(Exception e){}

	      // end timer
        long end = System.currentTimeMillis();

        System.out.println("Max number of divisors: " + max_count);
		    System.out.println("Number with max number of divisors: " + num);
        System.out.println("Total time elapsed: " + (end-start)/1000.00 + " seconds");
    }

    
}
