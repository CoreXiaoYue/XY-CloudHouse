package om.xiaoyue.test1;

public class XyStack {
	/*
	*栈的实现
	*
	*/
	private int[] array;
	private int tmpIndex=-1;

	/*
	初始化栈的容量
	*/
	public XyStack(int length) {
		array=new int[length];
	}

	/*
	 * 元素的压入
	 * 
	*/
	public void push(int obj) {
		tmpIndex++;
		array[tmpIndex]=obj;
	}

	/*
	 * 元素的弹出
	 * */
	public int pop() {
		int pop = array[tmpIndex];
		tmpIndex--;
		return pop;
		
	}

	/*
	*查看栈顶元素，不弹出。
	*/
	public int cheek() {
		return array[tmpIndex];
		
	}

	/*
	*判断栈是否为空。
	*/
	public boolean isEmpty() {
		return tmpIndex==-1;
		
	}

	/*
	 * 获取栈中的元素的个数
	*/
	public int size() {
		tmpIndex+=1;
		return tmpIndex;
		
	}
	
	public static void main(String[] args) {
		XyStack stackTest=new XyStack(10);
		stackTest.push(1);
		stackTest.push(2);
		stackTest.push(3);
		stackTest.push(4);
		stackTest.push(5);
		stackTest.pop();
		System.out.println(stackTest.cheek());
		System.out.println(stackTest.size());
	}

}
