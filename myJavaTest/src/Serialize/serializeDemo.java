package Serialize;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class serializeDemo {
	//序列化对象数据存储
	public static void main(String[] args) {
		Employee e = new Employee();
		e.haha = "aaa";
		e.name = "chun";
		e.address = "GuangDong";
		e.SSN = 111222333;
		e.number = 193;
		try {
		FileOutputStream fileOut = new FileOutputStream("d:\\java\\serialize.txt");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(e);
		out.close();
		System.out.println("序列化的数据保存在 /d:java\\serialize.txt");
		}catch(IOException a) {
			a.printStackTrace();
		}
	}
}

class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	public String haha;
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck() {
		System.out.println("Mailing a check to"+name+"  "+address);
	}
}
