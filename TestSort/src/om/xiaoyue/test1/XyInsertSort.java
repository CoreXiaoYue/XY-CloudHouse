package om.xiaoyue.test1;

public class XyInsertSort {
	/*
	*插入排序
	*/
	public void insertSort(int[] array) {
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			for (j = i; j > 0; j--) {
				if (array[j - 1] <= tmp) {
					array[j] = array[j - 1];
//						array[j-1]=tmp;
				} else {
					break;
				}
			}
			array[j] = tmp;
		}
	}

	public void insertSort1(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			for (int j = i; j > 0; j--) {
				if (array[j - 1] >= tmp) {
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				} else {
					break;
				}
			}
		}
	}

	// 遍历打印集合
	public void printArray(String str, int[] as) {
		System.out.print(str + ":");
		for (int i : as) {
			System.out.print(i + ",");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 1, 3, 42, 12, 0, 41 };
		XyInsertSort insertSort = new XyInsertSort();
		insertSort.insertSort1(array);
		insertSort.printArray("排序后", array);
	}

}
