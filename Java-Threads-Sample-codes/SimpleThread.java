/* Sample code,
 * Just create, no arguments are passed 
 */ 

public class SimpleThread extends Thread {
    public void run() {
	System.out.println("Hello World, I am thread " +
			   Thread.currentThread().getId());
	/* Thread class provides a static function called 
	 * currentThread which returns the currently running thread. 
	 * from that you get the id
	 */
    }
}
