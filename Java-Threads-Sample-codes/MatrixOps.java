/* Example of using threads
 * This implements matrix operations 
 * Only addition is given, you can do the rest 
 */

public class MatrixOps extends Thread {

        private static int [][] a; // two source c = a+b
    private static int [][] b; 
    private static int [][] c; // result 

    private int myRow; 

    public Matrix(int row) { 
	this.myRow = row;
    }

    public void run() { 
	for(int i=0; i < a[this.myRow].length; i++)
	     Matrix.c[this.myRow][i] = 
		 Matrix.a[this.myRow][i] + Matrix.b[this.myRow][i];
    }

    public static boolean add(int [][]aMat, int [][]bMat, int [][]resMat) { 
	int size = aMat.length; 

	Matrix.a = aMat; 
	Matrix.b = bMat; 
	Matrix.c = resMat;

	Matrix [] threads = new Matrix[size]; 
	
	for(int i=0; i < size; i++) {
	    threads[i] = new Matrix(i); 
	    threads[i].start();
	}

	for(int i=0; i < size; i++) { 
	    try { 
		threads[i].join();
	    } catch (InterruptedException e) { 
		System.out.println("Not good");
	    }
	}

	return true;
    }
}
