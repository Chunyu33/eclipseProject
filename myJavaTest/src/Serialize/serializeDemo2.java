package Serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//反序列化
public class serializeDemo2 {
	public static void main(String[] args) {
		Employee e = new Employee();
		try {
			FileInputStream fileIn = new FileInputStream("d:\\java\\serialize.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException a) {
			a.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("Employee class not fund!");
			c.printStackTrace();
			return;
		}
		System.out.println("反序列化……");
		System.out.println("name: "+e.name);
		System.out.println("Address: "+e.address);
		System.out.println("SSN: "+e.SSN);
		System.out.println("number:  "+e.number);
	}
}
