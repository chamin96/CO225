public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 

    /* You might need other variables as well */
    private Thread t;


    public Matrix() { // need to change this, might need some information 
    }

    public static int [][] run(int [][] a, int [][] b) 
    { 
    	int x = a.length; 
		int y = b[0].length; 
	
		int z1 = a[0].length; 
		int z2 = b.length; 
	
		if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    return null;
		}
		
    	int [][] c = new int [x][y]; 
		int i, j, k, s; 
        try
        { 
		for(i=0; i<x; i++){
		    for(j=0; j<y; j++) {
				for(s=0, k=0; k<z1; k++){
			    	s += a[i][k] * b[k][j];
					c[i][j] = s;
				}
		    }
	
		return c; 
    	}

  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 

    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */


	int n = 8; // Number of threads 
    for (int i=0; i<8; i++) 
    { 
        Matrix object = new Matrix(); 
        object.start(a,b); 
    }


	




}