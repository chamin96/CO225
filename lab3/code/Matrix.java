public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c;

    private static int rowA;
	private static int colB;

	private static int colA;
	private static int rowB;

	private static int s;
	private static int i;
	private static int j;
	private static int k;


    /* You might need other variables as well */


    public Matrix() { // need to change this, might need some information
    	start();
    }

    public void run(){
		s += a[i][k] * b[k][j];
    }

    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */

    rowA = a.length; 
	colB = b[0].length; 

	colA = a[0].length; 
	rowB = b.length;


	if(colA != rowB) { 
	    System.out.println("Cannnot multiply");
	    return null;
	}

	c = new int [rowA][colB];

		for(i=0; i<rowA; i++){
		    for(j=0; j<colB; j++) {
				for(s=0, k=0; k<colA; k++){
					t.start();
				    
				}
			c[i][j] = s;
		    }
	
		}	
	


	return c; 
    }

}