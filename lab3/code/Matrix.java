public class Matrix extends Thread { 

    public static int [][] A; 
    public static int [][] B; 
    public static int [][] c; 

	public static int x,y,z1,z2;
	public static int i,j,k,s;

	//constructor
	public Matrix() {
		start();
		try{
			join();		//join
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
    }

	public void run(){
		for(s=0, k=0; k<z1; k++){
			s += A[i][k] * B[k][j];		//caclulate sum of products
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
			new Matrix();	//create threads
			c[i][j] = s;
		}
	}
	return c; 
    }

}

/*
1. Each element in the two matrices are multiplied and summed up to get the final answer. 
   This repeating procedure can be parallelize and each thread can be used to do the operation.
2. Basic operation is to go through row wise in the fisrt matrix and column wise in the second matrix and
   to get the sum of their product.
   This operation is handled by a thread.
3. each thread calculates one element in the final matrix which means that a thread is used to multiply elements 
   in the given matrices and get their summation.
4. join() method is used to synchronize
*/