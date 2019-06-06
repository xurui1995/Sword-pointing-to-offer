/**
 * 题目：输入n个整数，输出其中最小的k个。
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 * <p>
 * 借鉴思路(源于网络)：
 * 这道题最简单的思路莫过于把输入的n个整数排序，这样排在最前面的k个数就是最小的k个数。只是这种思路的时间复杂度为O(nlogn)。
 * 题目并没有要求要查找的k个数，甚至后n-k个数是有序的，既然如此，咱们又何必对所有的n个数都进行排序列?
 * 这时，咱们想到了用选择或插入排序，即遍历n个数，先把最先遍历到得k个数存入大小为k的数组之中，对这k个数，进行排序，找到k个数中的最大数kmax，
 * k1<k2,K3<…<kmax（kmax设为k个元素的数组中最大元素），用时O（k），后再继续遍历后n-k个数，x与kmax比较，如果x<kmax，则x代替kmax，并再次排序k个元素的数组。如果x>kmax，则不更新数组。
 * 这样，每次更新或不更新数组的所用的时间为O（k）或O（0），整趟下来，总的时间复杂度平均下来为：n*O（k）=O（n*k）。
 * 3、  当然，更好的办法是维护k个元素的最大堆，原理与上述第3个方案一致，即用容量为k的最大堆存储最小的k个数，此时，k1<k2<...<kmax（kmax设为大顶堆中最大元素）。
 * 遍历一次数列，n，每次遍历一个元素x，与堆顶元素比较，x<kmax，更新堆（用时logk），否则不更新堆。这样下来，总费时O（n*logk）。此方法得益于在堆中，查找等各项操作时间复杂度均为logk（不然，就如上述思路2所述：直接用数组也可以找出前k个小的元素，用时O（n*k））。
 */
public class No30 {

    public static void main(String[] args) {
        int[] krr = {1, 3, 4, 2, 7, 8, 9, 10, 14, 16};
        int[] arr = minK(krr, 4);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    public static int[] minK(int[] krr, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = krr[i];
        buildHeap(arr);
        for (int j = k; j < krr.length; j++) {
            if (krr[j] < arr[0]) {
                arr[0] = krr[j];
                maxHeap(arr, 1, k);
            }
        }
        return arr;
    }


    public static void buildHeap(int[] arr) {
        int heapsize = arr.length;
        for (int i = arr.length / 2; i > 0; i--)
            maxHeap(arr, i, heapsize);
    }

    public static void maxHeap(int[] arr, int i, int heapsize) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= heapsize && arr[i - 1] < arr[left - 1])
            largest = left;
        if (right <= heapsize && arr[largest - 1] < arr[right - 1])
            largest = right;
        if (largest != i) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[largest - 1];
            arr[largest - 1] = temp;
            maxHeap(arr, largest, heapsize);
        }
    }


} 