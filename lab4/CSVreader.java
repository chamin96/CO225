import java.io.*;
import java.util.*;

class Contacts{
	String fName,lName,phone,email;

	public Contacts(String fName, String lName, String phone, String email){
		this.phone=phone;
		this.fName=fName;
		this.lName=lName;
		this.email=email;
	}
}

public class CSVreader{

	public static void main(String[] args) {
		File file = new File("contacts.csv");
		BufferedReader br=null;

		Map<Integer,Contacts> contactList = new Hashtable<Integer,Contacts>();


		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		//read CSV file
		String str;
		int index=1;
		try{
			while((str=br.readLine()) != null){
				String temp = str;
				String[] data=temp.split(",");
				Contacts c = new Contacts(data[0],data[1],data[2],data[3]);

				//adding to the Hashtable
				contactList.put(index, c);
				index++;
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

		//create a new scanner
		String searchKey;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Search contacts: ");
        searchKey = keyboard.nextLine();
        System.out.println(searchKey);
		keyboard.close();

		//search
		String first_name,last_name,phone_no,e_addr;
		for(Map.Entry<Integer, Contacts> entry:contactList.entrySet()){    
			//int key=entry.getKey();  
			Contacts c=entry.getValue();  
			//System.out.print(key+" Details: ");

			first_name= c.fName;
			last_name = c.lName;
			phone_no  = c.phone;
			e_addr	  = c.email;

			if (last_name.equals(searchKey)){
				System.out.println(c.fName+" "+c.phone+" "+c.email);
			}
			else{
				continue;
			}
			//System.out.println(c.fName+" "+c.lName+" "+c.phone+" "+c.email);   
		} 
		

		
	}
}