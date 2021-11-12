# 剑指Offer I - LeetCode CN 版本
### _所有题目描述来自leetcode cn_


### 剑指 Offer 03. 数组中重复的数字
```
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

```
class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i=0; i < nums.length; i++) {
            while(nums[i] != i) {     
                if(nums[nums[i]] ==  nums[i] ) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;     
            }
        }
        return -1;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc03.jpeg?raw=true)

### 剑指 Offer 04. 二维数组中的查找
```
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target=5，返回true。
给定target=20，返回false。
```

```
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && i >= 0 && j < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return false;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc04.png?raw=true)

### 剑指 Offer 05. 替换空格
```
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
```
```
class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc05.png?raw=true)

### 剑指 Offer 06. 从尾到头打印链表
```
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
```
```
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        int index = ans.length - 1;
        for (int i : list) {
            ans[index--] = i;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc06.png?raw=true)

### 剑指 Offer 07. 重建二叉树
```
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```
```
class Solution {
    HashMap<Integer, Integer> inordertIndexMap = new HashMap();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < n; i++) {
            inordertIndexMap.put(inorder[i], i);
        }

        return build(0, n - 1, 0, n - 1);

    }

    public TreeNode build(int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int index = inordertIndexMap.get(root.val);
        int leftLen = index - iStart;
        root.left = build(pStart + 1, pStart + leftLen, iStart, index - 1);
        root.right = build(pStart + leftLen + 1, pEnd, index + 1, iEnd);
        return root;
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc07.png?raw=true)

### 剑指 Offer 09. 用两个栈实现队列
```
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```
```
class CQueue {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        }
        return s2.pop();
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc09.png?raw=true)

### 剑指 Offer 10- I. 斐波那契数列
```
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
F(0) = 0,F(1)= 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

```
class Solution {
    int mod = 1000000007;

    public int fib(int n) {
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i & 1] = (dp[(i - 1) & 1] % mod + dp[(i - 2) & 1] % mod) % mod;
        }
        return dp[n & 1];
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc10-1.png?raw=true)



