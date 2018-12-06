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
			System.out.println(e);
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
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			if(br != null){
				try{
					br.close();
				}
				catch(IOException e){
					System.out.println(e);
				}
			}
		}

		//create a new scanner
		String searchKey;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Search contacts: ");
        searchKey = keyboard.nextLine();
        System.out.println("----------------------");
		keyboard.close();

		String[] searchSplit = searchKey.split(":");	//split input string
		String q1=searchSplit[0];	//F or L
		String q2=searchSplit[1];	//name
		
		switch (q1) {
			case "F":
				for(Map.Entry<Integer, Contacts> entry:contactList.entrySet()){    

					Contacts c=entry.getValue();

					if (c.fName.equals(q2)){
						System.out.println("Name: "+c.fName+" "+c.lName+"\nPhone: "+c.phone+"\nEmail: "+c.email);
						System.out.println("----------------------");
					}
					else{
						continue;
					}
				}
				break;
			case "L":
				for(Map.Entry<Integer, Contacts> entry:contactList.entrySet()){    
				
					Contacts c=entry.getValue();  

					if (c.lName.equals(q2)){
						System.out.println("Name: "+c.fName+" "+c.lName+"\nPhone: "+c.phone+"\nEmail: "+c.email);
						System.out.println("----------------------");
					}
					else{
						continue;
					}
				}
				break;
			default:
				break;
		}

		
	}
}