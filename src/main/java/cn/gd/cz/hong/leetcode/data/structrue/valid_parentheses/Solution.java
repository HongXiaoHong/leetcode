package cn.gd.cz.hong.leetcode.data.structrue.valid_parentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2021/3/28 15:54
 */

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

    public boolean isValid(String s) {
        // 参照官方 排除不可能的情况
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        // 这里使用双向队列（具有栈和队列的特点）
        // PS：这里使用Deque 而不是LinkedList 可以减少内存的消耗
        Deque<Character> singleParentheses = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char parentheses = s.charAt(i);
            // 是左边括号就放到栈里 操作下一个字符
            if ("([{".indexOf(parentheses) != -1) {
                singleParentheses.push(parentheses);
                continue;
            }
            // 从ASCII码表中知道 左右括号之间的码值不会超过3
            // 如果这时候栈里没有数据 或者不满足左右括号规则 退出返回
            if (singleParentheses.isEmpty()
                    || parentheses - singleParentheses.peek() <= 0
                    || parentheses - singleParentheses.peek() >= 3) {
                return false;
            }
            // 满足条件则出栈
            singleParentheses.pop();
        }
        return singleParentheses.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
