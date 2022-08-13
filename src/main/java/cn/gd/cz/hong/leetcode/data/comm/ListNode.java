package cn.gd.cz.hong.leetcode.data.comm;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2021/3/30 22:10
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
