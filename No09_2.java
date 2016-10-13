
public class No09_2 {

	/**
	 * .一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 求该青蛙跳上一个n级台阶总共有多少种跳法
	 */
	public static void main(String[] args) {
			System.out.println(getMethodNumber(10));
	}

	private static int getMethodNumber(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		return getMethodNumber(n-1)+getMethodNumber(n-2);
	}

}
