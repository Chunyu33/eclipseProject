package Serialize;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
//序列化
import java.io.Serializable;

public class SerializableTest {
	public static void main(String[] args) throws Exception {
		Person p1 = new Person(10,"zhangsan",4.55);
		Person p2 = new Person(20,"lisi",4.57);
		Person p3 = new Person(30,"wangwu",4.66);
		
		//序列化到文件里面
		FileOutputStream fos = new FileOutputStream("Person.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
		oos.close();
	}
}
@SuppressWarnings("serial")
class Person implements Serializable{
	int age;
	//transient修饰不可被序列化
	transient String name;
	double height;
	public Person(int age, String name, double height) {
		super();
		this.age = age;
		this.name = name;
		this.height = height;
	}
	
}