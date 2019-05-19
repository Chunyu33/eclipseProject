package IO_liu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符缓冲流的特殊方法
 * BufferedWriter:
 * 	public void newLine(); 根据系统来决定换行符
 * BufferedReader:
 * 	public String readLine();一次读取一行数据
 * */
public class BufferedDemo {
	public static void main(String[] args) throws IOException{
		//创建字符缓冲输出流对象
		read();
	}
	
	private static void read() throws IOException{
		//创建字节输入流对象
		BufferedReader br = new BufferedReader(new FileReader("bw2.txt"));
		//一次读取一行数据
//		String line = br.readLine();
//		System.out.println(line);
//		line = br.readLine();
//		System.out.println(line);
//		br.close();
		
		//最终版代码
		String line = null;
		while((line = br.readLine()) !=null) {
			System.out.println(line);
		}
		br.close();
	}
	
	private static void writer() throws IOException{
		//创建字符缓冲输出流对象
				BufferedWriter bw = new BufferedWriter(new FileWriter("bw2.txt"));
				
				for(int x= 0;x<10;x++) {
					bw.write("nihao"+x);
					//bw.write("\r\n");
					bw.newLine();   
				}
				bw.close();
			}
	}

