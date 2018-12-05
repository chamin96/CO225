public class Matrix extends Thread { 

    public static int [][] A; 
    public static int [][] B; 
    public static int [][] c; 

	/* You might need other variables as well */
	public static int x,y,z1,z2;
	public static int i,j,k,s;

	public Matrix() { // need to change this, might need some information
		start();
		try{
			join();
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
    }

	public void run(){
		for(s=0, k=0; k<z1; k++){
			s += A[i][k] * B[k][j];
		}
		   
	}
    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */

	A=a;
	B=b;


	x = a.length; 
	y = b[0].length; 

	z1 = a[0].length; 
	z2 = b.length; 

	if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    return null;
	}

	int [][] c = new int [x][y];

	for(i=0; i<x; i++){
	    for(j=0; j<y; j++){
			new Matrix();
			

			c[i][j] = s;
		}
	}

	return c; 
    }

}