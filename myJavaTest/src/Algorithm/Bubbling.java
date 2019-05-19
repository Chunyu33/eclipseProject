package Algorithm;

public class Bubbling {
	public static void main(String[] args) {
		int arr[] = {88,99,56,15,64,35,49,78,100};
		System.out.println("排序数组:");
		for (int i : arr) {
			System.out.print(" "+i);
		}
		
		for(int i = 0; i<arr.length-1; i++) {		//排多少趟
			for(int j = 0; j<arr.length-1-i;j++) {	//每一趟排多少次
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("\r\n"+"排序后：");
		for (int num : arr) {
			System.out.print(" "+num);
		}
	}
}
