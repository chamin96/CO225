import java.io.*;
import java.util.*;

public class CSVreader{
	public static void main(String[] args) {
		File file = new File("contacts.csv");
		BufferedReader br=null;

		ArrayList<String> contactList = new ArrayList<String>();


		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		String st;
		try{
			while((st=br.readLine()) != null){
				contactList.add(st);
				//System.out.println(st);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(br != null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}

		Iterator iter = contactList.iterator();

		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
}