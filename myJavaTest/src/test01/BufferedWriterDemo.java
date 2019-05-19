package test01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//缓冲流
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException{
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bw.txt")));
		BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));
		
		bw.write("hhh");
		bw.write("www");
		bw.write("aaa");
		
		bw.close();
	}
}
