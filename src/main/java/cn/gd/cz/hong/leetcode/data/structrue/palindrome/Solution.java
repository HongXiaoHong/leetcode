package cn.gd.cz.hong.leetcode.data.structrue.palindrome;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2021/3/29 22:37
 */

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表
// 👍 54 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int first = 0;
        int last = list.size() - 1;
        while (first < last && list.get(first).equals(list.get(last))) {
            first++;
            last--;
        }
        return first >= last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(node));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
