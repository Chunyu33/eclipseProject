package test01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
//转换流
public class OutputStream {
	public static void main(String[] args) throws IOException{
		OutputStreamWriter  osw = new OutputStreamWriter(new FileOutputStream("a.txt"));
		osw.write("春哥你好",0,2);
		osw.close();
	}
}
