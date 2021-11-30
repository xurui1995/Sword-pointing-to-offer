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


### 剑指 Offer 20. 表示数值的字符串
```
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：
若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格


小数（按顺序）可以分成以下几个部分：
（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字

整数（按顺序）可以分成以下几个部分：
（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：
["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：
["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
```
```
class Solution {

    static HashMap<Integer, Map<Integer, Integer>> map = new HashMap();
    static int blank = 0;
    static int sign = 1;
    static int digit = 2;
    static int dot = 3;
    static int e = 4;


    // 空格 0 { 空格 -> 0, 符号-> 1, 数字-> 2, 点-> 3}
    // 符号1 1  {数字 -> 2, 点 -> 3}
    // 数字1 2   {数字 -> 2,   (e, E) -> 4 , 点-> 5, 空格->9 }
    // 无数字前缀的点 3 { 数字 -> 8 }
    // E   4  {符号  -> 6,  数字-> 7}
    // 有数字前缀的点 5 { 数字 -> 8, (e, E) -> 4, 空格 -> 9}
    // 符号2  6 {数字 -> 7}
    // e后面的数字 7 {空格->9, 数字->7}
    // 点后面的数字 8 {空格->9, 数字->8, (e, E) -> 4}
    // 结尾空格 9 {空格 -> 9}


    static {
        Map<Integer, Integer> stat0 = new HashMap();
        stat0.put(blank, 0);
        stat0.put(sign, 1);
        stat0.put(digit, 2);
        stat0.put(dot, 3);
        map.put(0, stat0);

        Map<Integer, Integer> stat1 = new HashMap();
        stat1.put(digit, 2);
        stat1.put(dot, 3);
        map.put(1, stat1);

        Map<Integer, Integer> stat2 = new HashMap();
        stat2.put(digit, 2);
        stat2.put(e, 4);
        stat2.put(dot, 5);
        stat2.put(blank, 9);
        map.put(2, stat2);

        Map<Integer, Integer> stat3 = new HashMap();

        stat3.put(digit, 8);
        map.put(3, stat3);


        Map<Integer, Integer> stat4 = new HashMap();
        stat4.put(sign, 6);
        stat4.put(digit, 7);
        map.put(4, stat4);


        Map<Integer, Integer> stat5 = new HashMap();
        stat5.put(digit, 8);
        stat5.put(e, 4);
        stat5.put(blank, 9);
        map.put(5, stat5);

        Map<Integer, Integer> stat6 = new HashMap();
        stat6.put(digit, 7);
        map.put(6, stat6);

        Map<Integer, Integer> stat7 = new HashMap();
        stat7.put(blank, 9);
        stat7.put(digit, 7);
        map.put(7, stat7);
        Map<Integer, Integer> stat8 = new HashMap();
        stat8.put(digit, 8);
        stat8.put(e, 4);
        stat8.put(blank, 9);
        map.put(8, stat8);


        Map<Integer, Integer> stat9 = new HashMap();

        stat9.put(blank, 9);
        map.put(9, stat9);


    }

    public boolean isNumber(String s) {
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int action = -1;
            if (c == '.') {
                action = dot;
            } else if (c == 'e' || c == 'E') {
                action = e;
            } else if (c == ' ') {
                action = blank;
            } else if (c == '+' || c == '-') {
                action = sign;
            } else if (c >= '0' && c <= '9') {
                action = digit;
            }
            if (action == -1 || !map.get(cur).containsKey(action)) {
                return false;
            }

            cur = map.get(cur).get(action);
        }
        return cur == 2 || cur == 5 || cur == 7 || cur == 8 || cur == 9;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc20.png?raw=true)

### 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
```
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
```
```
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 1) {
                l++;
            }

            while (l < r && nums[r] % 2 == 0) {
                r--;
            }

            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc21.png?raw=true)


### 剑指 Offer 22. 链表中倒数第k个节点
```
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
```
```
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc22.png?raw=true)


### 剑指 Offer 24. 反转链表
```
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
```
```
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc24.png?raw=true)

### 剑指 Offer 25. 合并两个排序的链表
```
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```
```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(-1);
        ListNode temp = hair;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
                temp.next = null;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;

                temp.next = null;
            }
        }
        return hair.next;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc25.png?raw=true)

### 剑指 Offer 26. 树的子结构
```
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。
```
```
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (solve(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean solve(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return solve(A.left, B.left) && solve(A.right, B.right);
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc26.png?raw=true)

### 剑指 Offer 27. 二叉树的镜像
```
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
```
```
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc27.png?raw=true)

### 剑指 Offer 28. 对称的二叉树
```
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
```
```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node2.left, node1.right);

    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc28.png?raw=true)


### 剑指 Offer 29. 顺时针打印矩阵
```
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```
```
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        if (n == 0) {
            return new int[0];
        }
        int round = Math.min((m + 1) / 2, (n + 1) / 2);
        int[] ans = new int[m * n];
        int index = 0;
        int l = 0, t = 0, r = n - 1, b = m - 1;
        for (int x = 0; x < round; x++) {
            for (int i = l; i <= r; i++) {
                ans[index++] = matrix[t][i];
            }
            for (int i = t + 1; i <= b; i++) {
                ans[index++] = matrix[i][r];
            }
            for (int i = r - 1; i >= l && b != t; i--) {
                ans[index++] = matrix[b][i];
            }
            for (int i = b - 1; i > t && l != r; i--) {
                ans[index++] = matrix[i][l];
            }
            l++;
            t++;
            r--;
            b--;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc29.png?raw=true)

### 剑指 Offer 30. 包含min函数的栈
```
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```
```
class MinStack {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public MinStack() {

    }

    public void push(int x) {
        s1.push(x);
        if (s2.empty() || s2.peek() >= x) {
            s2.push(x);
        }
    }

    public void pop() {
        if (s1.pop().equals(s2.peek())) {
            s2.pop();
        }

    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc30.png?raw=true)

### 剑指 Offer 31. 栈的压入、弹出序列
```
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```
```
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack();
        int i = 0;
        for (int num : pushed) {
            s.push(num);
            while (i < popped.length && !s.isEmpty() && popped[i] == s.peek()) {
                s.pop();
                i++;
            }
        }
        return s.isEmpty();
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc31.png?raw=true)

### 剑指 Offer 32 - I. 从上到下打印二叉树
```
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
```

```
class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                ans.add(node.val);
            }
        }
        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }
        return array;
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc32-1.png?raw=true)

### 剑指 Offer 32 - II. 从上到下打印二叉树 II
```
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
```
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc32-2.png?raw=true)

### 剑指 Offer 32 - III. 从上到下打印二叉树 III
```
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
```
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root != null) {
            queue.offer(root);
        }
        boolean ltr = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for(int i=0; i< size; i++) {
                TreeNode node = queue.poll();
                if(node.left  != null) {
                    queue.offer(node.left);
                }
                if(node.right  != null) {
                    queue.offer(node.right);
                }
                if(ltr) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }
            ltr = !ltr;
            ans.add(list);
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc32-3.png?raw=true)

### 剑指 Offer 33. 二叉搜索树的后序遍历序列
```
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
```
```
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return verify(0, n - 1, postorder);
    }

    public boolean verify(int l, int r, int[] postorder) {
        if (l >= r) {
            return true;
        }
        int root = postorder[r];
        int mid = r;
        while (mid >= l && postorder[mid] >= root) {
            mid--;
        }
        int next = mid;
        while (next >= l) {
            if (postorder[next] >= root) {
                return false;
            }
            next--;
        }
        return verify(l, mid, postorder) && verify(mid + 1, r - 1, postorder);
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc33.png?raw=true)

### 剑指 Offer 34. 二叉树中和为某一值的路径
```
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
```
```
class Solution {
    List<List<Integer>> ans = new ArrayList();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return ans;
        }
        this.target = target;
        dfs(root, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> temp, int sum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                temp.add(root.val);
                ans.add(new ArrayList(temp));
                temp.remove(temp.size() - 1);
            }
        }

        temp.add(root.val);

        if (root.left != null) {
            dfs(root.left, temp, sum + root.val);
        }
        if (root.right != null) {
            dfs(root.right, temp, sum + root.val);
        }
        temp.remove(temp.size() - 1);
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc34.png?raw=true)

### 剑指 Offer 35. 复杂链表的复制
```
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
```
```
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }
        temp = head;
        while (temp != null) {
            Node next = temp.next;
            next.random = temp.random == null ? null : temp.random.next;
            temp = next.next;
        }

        Node newHead = head.next;
        temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = temp.next == null ? null : temp.next.next;
            temp = next;
        }
        return newHead;
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc35.png?raw=true)

### 剑指 Offer 36. 二叉搜索树与双向链表
```
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

```
```
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] ans = dfs(root);
        ans[0].left = ans[1];
        ans[1].right = ans[0];
        return ans[0];
    }

    public Node[] dfs(Node root) {
        if (root.left == null && root.right == null) {
            return new Node[]{root, root};
        }
        Node left = root;
        if (root.left != null) {
            Node[] l = dfs(root.left);
            left = l[0];
            l[1].right = root;
            root.left = l[1];
        }

        Node right = root;
        if (root.right != null) {
            Node[] r = dfs(root.right);
            right = r[1];
            r[0].left = root;
            root.right = r[0];
        }
        return new Node[]{left, right};
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc36.png?raw=true)

### 剑指 Offer 37. 序列化二叉树
```
请实现两个函数，分别用来序列化和反序列化二叉树。
你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
```
```
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String root = queue.poll();
        if (root.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(root));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc37.png?raw=true)

### 剑指 Offer 38. 字符串的排列
```
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
```
```
class Solution {
    ArrayList<String> list = new ArrayList();
    boolean[] visited;
    int n;

    public String[] permutation(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        n = arr.length;
        visited = new boolean[n];
        Arrays.sort(arr);
        dfs(sb, arr);
        return list.toArray(new String[0]);
    }

    public void dfs(StringBuilder sb, char[] arr) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i >= 1 && !visited[i - 1] && arr[i - 1] == arr[i]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(arr[i]);
            dfs(sb, arr);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc38.png?raw=true)

### 剑指 Offer 39. 数组中出现次数超过一半的数字
```
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
```
```
class Solution {
    public int majorityElement(int[] nums) {
        int c = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                c = nums[i];
                cnt++;
            } else if (nums[i] == c) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return c;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc39.png?raw=true)

### 剑指 Offer 40. 最小的k个数
```
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
```
```
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i : pq) {
            ans[index++] = i;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc40.png?raw=true)


### 剑指 Offer 41. 数据流中的中位数
```
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
```
```

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> queue1 = new PriorityQueue<>((v1, v2) -> v2 - v1);
    PriorityQueue<Integer> queue2 = new PriorityQueue();
    int flag = -1;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (flag == -1) {
            queue1.offer(num);
            flag = 0;
        } else if (flag == 0) {
            queue2.offer(num);
            if (queue1.peek() > queue2.peek()) {
                var temp = queue1.poll();
                queue1.offer(queue2.poll());
                queue2.offer(temp);
            }
            flag = 1;
        } else {
            if (num >= queue1.peek()) {
                queue2.offer(num);
            } else {
                queue1.offer(num);
            }
            if (queue1.size() - queue2.size() >= 1) {
                queue2.offer(queue1.poll());
            } else if (queue2.size() - queue1.size() >= 2) {
                queue1.offer(queue2.poll());
            }
        }
    }

    public double findMedian() {
        int size = queue1.size() + queue2.size();
        if (size % 2 == 0) {
            return (queue1.peek() * 1.0 + queue2.peek() * 1.0) / 2;
        }
        if (size == 1) {
            return queue1.peek();
        }
        return queue2.peek();
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc41.png?raw=true)

### 剑指 Offer 42. 连续子数组的最大和
```
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
```
```
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc42.png?raw=true)

### 剑指 Offer 43. 1～n 整数中 1 出现的次数
```
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
```
```
class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        int range = 1;
        int l = n / 10;
        int cur = n % 10;
        int r = 0;
        while (!(l == 0 && cur == 0)) {
            if (cur == 0) {
                // 301 -> *1*
                ans += l * range;
            } else if (cur == 1) {
                // 311
                ans += l * range + r + 1;
            } else {
                // 321
                ans += (l + 1) * range;
            }

            r += cur * range;
            cur = l % 10;
            l /= 10;
            range *= 10;
        }
        return ans;
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc43.png?raw=true)

### 剑指 Offer 44. 数字序列中某一位的数字
```
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

输入：n = 3
输出：3
```
```
class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long cnt = 9;
        long l = 1, r = 9, c = 1;
        
        while (cnt < n) {
            r = r * 10 + 9;
            l = l * 10;
            c++;
            cnt += c * (r - l + 1);
        }
        long s = cnt - c * (r - l + 1);
        long gap = n - s - 1;
        long gapC = gap / c;
        long modC = gap % c;
        long num = l + gapC;
        String str = String.valueOf(num);
        char ch = str.charAt((int) (modC));
        return ch - '0';

    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc44.png?raw=true)

### 剑指 Offer 45. 把数组排成最小的数
```
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
输入: [10,2]
输出: "102"
```
```
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {

            public int compare(String a, String b) {
                return (a + b).compareTo(b+a);
            }
        });
        StringBuilder sb  = new StringBuilder();
        for(var str : strs) {
            sb.append(str);
        }
        return  sb.toString();
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc45.png?raw=true)


### 剑指 Offer 46. 把数字翻译成字符串
```
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```
```
class Solution {
    public int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        int[] dp = new int[n];
        // 1 2 2 5 8
        // 1 2 3 5 5
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int c = arr[i] - '0';
            int last = arr[i - 1] - '0';
            dp[i] = dp[i - 1];
            if (last * 10 + c >= 10 && last * 10 + c <= 25) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }
}
```
* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc46.png?raw=true)

### 剑指 Offer 47. 礼物的最大价值
```
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

```
```
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                int left = j>=1 ? grid[i][j-1] : 0;
                int right = i>=1 ? grid[i-1][j] : 0;
                grid[i][j] = Math.max(grid[i][j] + left, grid[i][j] + right);
            }
        }
        return grid[m-1][n-1];

    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc47.png?raw=true)

### 剑指 Offer 48. 最长不含重复字符的子字符串
```
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int start=0;
        int ans = 0;
        for(int i=0; i < s.length(); i++) {
            int last = map.getOrDefault(s.charAt(i), -1);
            if(last == -1) {
                ans = Math.max(ans, i- start + 1);
            } else {
                start = Math.max(start,  last + 1);
                 ans = Math.max(ans, i- start + 1);
            }
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}
```

* ![](https://github.com/xurui1995/Sword-pointing-to-offer/blob/master/%E5%89%91%E6%8C%87offer%20I%20-%20leetcode%E7%89%88/image/lc48.png?raw=true)



