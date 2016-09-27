import java.util.Stack;


public class No22 {

	/**
	 * .输入两个整数序列，第一个序列表示栈的压入顺序，
	 * 请判断第二个序列是否为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈
	 * 的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列
	 * 但4、3、5、1、2就不可能是该压栈序列的弹出序列
	 */
	public static void main(String[] args) {
		Integer[] pushOrder={1,2,3,4,5};
		Integer[] popOrder={4,5,3,2,1};
		isRight(pushOrder,popOrder,5);
	}

	private static boolean isRight(Integer[] pushOrder, Integer[] popOrder, int n) {
			boolean isRight=false;
			Stack<Integer> stack=new Stack<Integer>();
			for(int i=0;i<popOrder.length;i++){
				
			}
			return isRight;
		
	}

}
