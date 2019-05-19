package generic_paradigm;
//泛型的使用

public class ObjectToolDemo {
	public static void main(String[] args) {
//		ObjectTool ot = new ObjectTool();
//		
//		ot.setObj(new String("风清扬"));
//		String s  = (String) ot.getObj();
//		System.out.println("姓名是： "+s);
//		
//		ot.setObj(new Integer(30));
//		Integer i = (Integer) ot.getObj();
//		System.out.println("年龄是： "+i);
		
		//正确用法
		ObjectTool<String> ot = new ObjectTool<String>();
		//ot.setObject(new Integer(27));//这个时候编译期间就过不去
		ot.setObj(new String("林允儿"));
		String s = ot.getObj();
		System.out.println("美女是： "+s);
		
		ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
		ot2.setObj(new Integer(27));
		Integer i = ot2.getObj();
		System.out.println("芳龄是： "+i);
	}
}
