package om.xiaoyue.test1;


/*
*冒泡排序
*/
public class XyBubblingSort {
	/*
	 * public void testSort(int[] as) { 
	 * //循环的躺数
	 *  	for(int i=as.length-1;i>0;i--) {
	 * //每躺要比较的次数
	 *  		for(int j=0;j<i;j++) {
	 *  			if(as[j]>as[j+1]) {
	 *  		 		int tmp=as[j];
	 * 					as[j]=as[j+1];
	 * 					 as[j+1]=tmp; 
	 *  			}
	 *  		}
	 * 		 }
	 * }
	 */
	public void testSort(int[] as) {
		//循环的躺数
		for(int i=as.length-1;i>0;i--) {
			//每躺要比较的次数
			for(int j=0;j<i;j++) {
				if(as[j]>as[j+1]) {
					sorts(as,j,j+1);
				}
			}
		}
	}
	public void sorts(int[] array, int aIndex, int bIndex) {
		int temp = array[aIndex];
		array[aIndex] = array[bIndex];
		array[bIndex] = temp;
	}
	
	public void printArray(String str,int[] as) {
		System.out.print(str+":");
		for (int i : as) {
				System.out.print(i+",");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		int [] as=new int [] {5,8,3,69,1,24,15,12};

		XyBubblingSort testSort1=new XyBubblingSort();
		testSort1.printArray("排序前",as);
		testSort1.testSort(as);
		testSort1.printArray("排序后",as);
	}
}
