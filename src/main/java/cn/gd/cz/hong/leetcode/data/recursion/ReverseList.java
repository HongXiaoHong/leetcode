package cn.gd.cz.hong.leetcode.data.recursion;


import cn.gd.cz.hong.leetcode.data.comm.ListNode;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2021/3/30 22:09
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
         * 官方解释
         * 领悟：
         *
         * 递归应该从其中任意一个节点观察规律
         * 可以画图辅助
         * 这里如果不画图 想半天
         */
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode src = new ListNode(1);
        src.next = new ListNode(2);
        src.next.next = new ListNode(3);
        src.next.next.next = new ListNode(4);
        src.next.next.next.next = new ListNode(5);
        ListNode result = reverseList.reverseList(src);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
