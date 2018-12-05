/* find the maximum of a large array 
 * some helper functions and parallel implementation
 */

import java.util.Random;// Random number generator

class Help {

    public static int range = 100000; // range for values 
    public static int [] generate_array(int size) {
	Random ran = new Random();
	int data[] = new int[size];

	for(int i=0; i < size; i++)
	    data[i] = ran.nextInt(range);

	return data;
    }

    public static int findMaxSerial(int [] data) {
	int max = data[0];// assume array is not null
	for(int i=1; i < data.length; i++)
	    if(max < data[i]) max = data[i];
	return max;
    }
}

public class FindMax extends Thread {

    private static int [] data;
    private static int partition_size;
    private static int [] local_maximas;
    
    private int myId;

    public FindMax(int myId) { this.myId = myId; }

    public void run() {
	int start = myId * partition_size;
	int localMax = data[start];
	for(int i=start+1; i < partition_size* (myId + 1); i++)
	    if(localMax < data[i]) localMax = data[i];
	System.out.println("My max " + localMax); 
	local_maximas[myId] = localMax;
    }

    public static int findMax (int [] data) {

	int thr = 2; // how many threads to create
	
	local_maximas = new int[thr]; // threads will put their answer to this
	Thread [] threads = new Thread[thr];
	
	FindMax.partition_size = data.length/thr;
	FindMax.data = data; 

	for(int i=0; i < thr; i++) {
	    threads[i] = new FindMax(i);
	    threads[i].start();
	}
	
	try {
	    for(int i=0; i < thr; i++)
		threads[i].join();  
	    } catch (InterruptedException e) { 
		System.out.println("Not good");
	    }

	int global_max = local_maximas[0]; 
	for(int i=1; i < thr; i++)
	    if(global_max < local_maximas[i]) global_max = local_maximas[i];
	return global_max;
    }
}

class TestFindMax {
    public static void main(String [] args) { 
	int [] data = Help.generate_array(100);
	int max = FindMax.findMax(data); 
	System.out.println("Max value= " + max +
			   " from serial = " + Help.findMaxSerial(data));

	// better way
	// make sure the serial version gives the same answer
	// will only be enabled when you type java -ea 
	assert Help.findMaxSerial(data) == max : "Something wrong";	
    }
}
			 

	
	    
	
