package test01;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

//获取本机支持的字符集
public class getChars {
	public static void main(String[] args) {

		SortedMap<String, Charset> map = Charset.availableCharsets();

		Set<String> set = map.keySet();

		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}
}
