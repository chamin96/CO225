class Main {
	public static int size=500;
	public static int [][] a = new int[size][size];

    
    public static int [][] b = {{1, 1},
				{1, 1},
				{1, 1}};


	public static void matrixGen(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				a[i][j]=(int)(Math.random()*1000);
			}
		}
	}

    public static void print_matrix(int [][] a) {
	for(int i=0; i < a.length; i++) {
	    for(int j=0; j< a[i].length; j++) 
		System.out.print(a[i][j] + " "); 
	    System.out.println();
	}
    }
    

    public static void main(String [] args) {

		matrixGen();
    	try{
    		int [][] x = Matrix.multiply(a, a); 
			print_matrix(x); // see if the multipication is correct
    	}
    	catch(NullPointerException e){
    		System.out.println(e);
    	}

	 	

    }
}