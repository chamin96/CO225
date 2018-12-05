class RunnableClass implements Runnable {

    private String name;
    public static int howmanytimes = 5;

    public RunnableClass(String name) {
	this.name = name;
    }
    public void run() {
	int i;
	for(i=0; i < howmanytimes; i ++)
	    System.out.println(this.name + " says hi, running as thread "+
			       Thread.currentThread().getId());
    }
}
    
public class RunnableEx {
    public static void main(String [] args) {
	/* now lets create some threads */
	Thread t0 = new Thread(new RunnableClass("Sam"));
	Thread t1 = new Thread(new RunnableClass("Ann"));

	RunnableClass.howmanytimes = 10; 
	t0.start();
	t1.start();
    }
}
