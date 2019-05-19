package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Student> array = new ArrayList<Student>();
		
		Student s1 = new Student("林青霞",27);
		Student s2 = new Student("大佬",50);
		Student s3 = new Student("jack",21);
		Student s4 = new Student("marry",22);
		Student s5 = new Student("hei",25);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
		
		Iterator<Student> it = array.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			System.out.println(s.getName()+" * * * "+s.getAge());
		}
		System.out.println("\r\n");
		System.out.println("增强for遍历：\r\n");
		//增强for
		for(Student s:array) {
			System.out.println(s.getName()+" * * * "+s.getAge());
		}
	}
}
