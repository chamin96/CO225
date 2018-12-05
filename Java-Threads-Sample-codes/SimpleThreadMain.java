/* use the SimpleThread class to create a thread 
 */

public class SimpleThreadMain {

    public static void main(String [] args ) {
	/* so the main thread is running in some thread 
	 * print the thread id 
	 */
	System.out.println("Hi, I am main. My thread id " +
			   Thread.currentThread().getId());

	SimpleThread t = new SimpleThread();
	t.run(); // when you do this the same thread on which
	// main was running will execute the run function.

	System.out.println("Main: Starting the thread");
	t.start();

	System.out.println("Main exiting"); 
    }
}
