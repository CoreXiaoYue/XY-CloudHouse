package om.xiaoyue.test1;

/*
*
*选择排序
*/
public class XySelectSort {
	//排序规则
	public void choessSort(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			sorts(array, min, i);
		}
	}
	//交换元素
	public void sorts(int[] array, int min, int index) {
		int temp = array[min];
		array[min] = array[index];
		array[index] = temp;
	}
	//遍历打印集合
	public void printArray(String str,int[] as) {
		System.out.print(str+":");
		for (int i : as) {
				System.out.print(i+",");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		int[] array = new int[] { 5, 1, 3, 42, 12, 0, 41 };
		XySelectSort testSort2 = new XySelectSort();
		testSort2.printArray("排序前",array);
		testSort2.choessSort(array);
		testSort2.printArray("排序后",array);
	}
}
