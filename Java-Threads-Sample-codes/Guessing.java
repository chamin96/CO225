import java.util.Random;// Random number generator 

class GuessSerial {
    static int guesses = 1000000;
    static int range = 1000000;
    public static void main(String [] args) {
	Random ran = new Random();
	int odd = 0; 
	for(int i=0; i < guesses; i++) 
	    if(ran.nextInt(range) % 2 != 0) odd++; 

	System.out.println("We have " + odd + " odd numbers out of " +
			   guesses);
    }
}


class GuessParallelBroken extends Thread {

    private int myguesses;
    public static int totalOdd = 0; 
    public static int guesses = 1000000;
    public static int range = 1000000;
    public GuessParallelBroken(int howmany) {
	myguesses = howmany;
    }

    public void run() {
	Random ran = new Random();
	int odd = 0; // local to thread 
	for(int i=0; i < this.myguesses; i++) 
	    if(ran.nextInt(range) % 2 != 0) {
		odd++;
		totalOdd++;
	    }

	System.out.println("We have " + odd + " odd numbers out of " +
			   guesses);
    }

    public static void main(String [] args) {
	/* Create 2 threads 
	 * each will guess 500,000
	 */
	GuessParallelBroken t1 = new GuessParallelBroken(guesses/2);
	GuessParallelBroken t2 = new GuessParallelBroken(guesses/2);

	totalOdd = 0;// No guesses so far;
	
	t1.start(); // start the threads
	t2.start();

	// Should not access totalOdd now, since I do not know
	// if the threads have finished the given work.	
	try { 
		t1.join();
		t2.join(); 
	    } catch (InterruptedException e) { 
		System.out.println("Not good");
	    }
	System.out.println("We have " + totalOdd + " odd numbers out of " +
			   guesses );
	
    }
}

class GuessParallel extends Thread {

    private int myguesses;
    public static int totalOdd = 0; 
    public static int guesses = 1000000;
    public static int range = 1000000;
    public GuessParallel(int howmany) {
	myguesses = howmany;
    }

    private static synchronized void increment_total() {
	totalOdd++;
    }
    private static synchronized void increment_total(int i) {
	// overload to give a value to increment 
	totalOdd += i; 
    }
    

    public void run() {
	Random ran = new Random();
	int odd = 0; // local to thread 
	for(int i=0; i < this.myguesses; i++) 
	    if(ran.nextInt(range) % 2 != 0) {
		odd++;
		increment_total(); 
	    }

	System.out.println("We have " + odd + " odd numbers out of " +
			   guesses);
    }

    public static void main(String [] args) {
	/* Create 2 threads 
	 * each will guess 500,000
	 */
	GuessParallel t1 = new GuessParallel(guesses/2);
	GuessParallel t2 = new GuessParallel(guesses/2);

	totalOdd = 0;// No guesses so far;
	
	t1.start(); // start the threads
	t2.start();

	// Should not access totalOdd now, since I do not know
	// if the threads have finished the given work.	
	try { 
		t1.join();
		t2.join(); 
	    } catch (InterruptedException e) { 
		System.out.println("Not good");
	    }
	System.out.println("We have " + totalOdd + " odd numbers out of " +
			   guesses );
	
    }
}
       
	
