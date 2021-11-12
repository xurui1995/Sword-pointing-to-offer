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


### 剑指 Offer 10- II. 青蛙跳台阶问题
```
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
```

```
class Solution {
    int mod = 1000000007;
    public int numWays(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i & 1] = (dp[(i - 1) & 1] % mod + dp[(i - 2) & 1] % mod) % mod;
        }
        return dp[n & 1];
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc10-2.png?raw=true)

### 剑指 Offer 11. 旋转数组的最小数字
```
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：
输入：[3,4,5,1,2]
输出：1

示例 2：
输入：[2,2,2,0,1]
输出：0

```

```
class Solution {
    public int minArray(int[] nums) {
        int n = nums.length;
        int r = n - 1;
        if (nums[r] > nums[0]) {
            return nums[0];
        }
        while (r >= 0 && nums[r] == nums[0]) {
            r--;
        }
        if (r == -1) {
            return nums[0];
        }
        if (nums[r] > nums[0]) {
            return nums[0];
        }
        int l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];

    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc11.png?raw=true)

### 剑指 Offer 12. 矩阵中的路径
```
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc12-desc.png?raw=true)
```
class Solution {
    char[][] board;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean ans = dfs(word, index + 1, i + 1, j) || dfs(word, index + 1, i - 1, j)
                || dfs(word, index + 1, i, j + 1) || dfs(word, index + 1, i, j - 1);

        visited[i][j] = false;
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc12.png?raw=true)

### 剑指 Offer 13. 机器人的运动范围
```
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
```

```
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int ans = 0;
        Queue<int[]> queue = new LinkedList();

        queue.offer(new int[]{0, 0});
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans += size;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int K = 0; K < 4; K++) {
                    int newX = poll[0] + x[K];
                    int newY = poll[1] + y[K];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        int num = 0;
                        int temp = newX;
                        while (temp != 0) {
                            num += temp % 10;
                            temp = temp / 10;
                        }
                        temp = newY;
                        while (temp != 0) {
                            num += temp % 10;
                            temp = temp / 10;
                        }
                        if (num <= k) {
                            queue.offer(new int[]{newX, newY});
                        }

                    }
                }
            }
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc13.png?raw=true)

### 剑指 Offer 14- I. 剪绳子
```
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
```
```
class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = n % 3;
        int cnt = n / 3;
        if (mod == 1) {
            return (int) (Math.pow(3.0, cnt - 1) * 4);
        }
        return (int) (Math.pow(3.0, cnt) * (mod == 0 ? 1 : mod));
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc14-1.png?raw=true)

### 剑指 Offer 14- II. 剪绳子 II
```
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
```
```
class Solution {
    int mod = 1000000007;

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long ans = 1;
        while (n > 4) {
            ans = ans * 3 % mod;
            n -= 3;
        }
        ans = ans * n % mod;
        return (int) (ans);
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc14-2.png?raw=true)

### 剑指 Offer 15. 二进制中1的个数
```
编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
```
```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0) {
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc15.png?raw=true)

### 剑指 Offer 16. 数值的整数次方
```
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
输入：x = 2.00000, n = 10
输出：1024.00000
```

```
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {

            return 1 / (myPow(x, -(n + 1)) * x);
        }
        int halfN = n / 2;
        double val = myPow(x, halfN);
        double ans = val * val;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc16.png?raw=true)

### 剑指 Offer 17. 打印从1到最大的n位数
```
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

```
class Solution {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] ans = new int[max];
        for (int i = 0; i < max; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc17.png?raw=true)

### 剑指 Offer 18. 删除链表的节点
```
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

```
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode hair = new ListNode();
        ListNode temp = hair;
        while (head != null) {
            if (head.val != val) {
                temp.next = head;
                temp = temp.next;
                head = head.next;
                temp.next = null;
            } else {
                head = head.next;
            }

        }
        return hair.next;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc18.png?raw=true)

### 剑指 Offer 19. 正则表达式匹配
```
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```
```
class Solution {
    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if ((sc == pc || pc == '.') && i >= 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char prev = p.charAt(j - 1);
                    if (i >= 1 && (prev == sc || prev == '.')) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 2];
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc19.png?raw=true)


