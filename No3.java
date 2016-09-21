
public class No3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr={{1,2,8,9},
					 {2,4,9,12},
					 {4,7,10,13},
					 {6,8,11,15}};
		
		System.out.println(search(arr,7));
	}

	private static boolean search(int[][] arr, int value) {
		
		int a=arr[0].length;	
		int b=arr.length;
		int i=0;
		int j=a-1;
		
		while(i<=b-1&&j>=0){
			if(arr[i][j]==value){
				return true;
			}
			if(arr[i][j]>value){
				j--;
			}
			else {
				i++;
			}
		}
		return false;
	}

}
