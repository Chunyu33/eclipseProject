package tests;
//基础
public class demo1 {
	public static void main(String[] args) {
		int result = jiecheng(5);
		System.out.println(result);
	}
	//递归
	public static int jiecheng(int n) {
		if(n==1) {
			return 1;
		}
		return jiecheng(n-1) * n;
	}
	
	public static void ball() {
		
	}
}
