
public class No34 {

	/**
	 * 
	 */
	public static void main(String[] args) {
	
		System.out.println(getUgly(20));
		
	}

	private static int getUgly(int n) {
		if(n<0)
			return 0;
		int[] uglyArray=new int[n];
		uglyArray[0]=1;		
		int multiply2 = 0;  
        int multiply3 = 0;  
        int multiply5 = 0;
        for(int i = 1;i<n;i++){  
            int min = getMin(uglyArray[multiply2]*2,uglyArray[multiply3]*3,uglyArray[multiply5]*5);  
            uglyArray[i] = min; 
            System.out.println(uglyArray[i]);
            while(uglyArray[multiply2]*2 == uglyArray[i])  
                multiply2++;  
            while(uglyArray[multiply3]*3 == uglyArray[i])  
                multiply3++;  
            while(uglyArray[multiply5]*5 == uglyArray[i])  
                multiply5++;  
        }  
		return uglyArray[n-1];
	}

	private static int getMin(int i, int j, int k) {
		int min=(i<j)?i:j;
		return (min<k)?min:k;
	}

}
