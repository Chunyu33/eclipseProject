package JDK_5_news;

import java.util.ArrayList;
import java.util.List;

/*
 * jdk5的新特性：自动拆装箱，增强for，静态导入，可变参数，枚举
 * 
 * 增强for:是for循环的一种，简化了数组和集合的遍历
 * 格式：
 * 		for(元素数据类型遍历：数组或者Collection集合){
 * 			使用变量即可，该变量就是元素
 * 		}
 * 弊端：目标不能为null
 * */
public class ForDemo {
	public static void main(String[] args) {
		// 定义一个int 数组
		int[] arr = { 1, 2, 3, 4, 5 };
		for (int x = 0; x < arr.length; x++) {
			System.out.println(arr[x]);
		}
		System.out.println("\r\n");
		// 增强for
		for (int x : arr) {
			System.out.println(x);
		}
		System.out.println("\r\n");
		// 集合
		ArrayList<String> array = new ArrayList<String>();
		array.add("春哥");
		array.add("nihao");
		array.add("java");

		for (String s : array) {
			System.out.println(s);
		}

		System.out.println("\r\n");

		// 弊端
		List<String> list = null; // java.lang.NullPointerException
		// s是list里面获取出来的，在获取前肯定还需要做出判断
		if (list != null) {
			for (String s : list) {
				System.out.println(s);
			}
		}
		//增强for其实是用来替代迭代器的
//		for(String s :array) {
//			if("nihao".equals(s)) {	// java.util.ConcurrentModificationException
//				array.add("javaee");
//			}
//		}
//		System.out.println("array:" +array);
	}
}
