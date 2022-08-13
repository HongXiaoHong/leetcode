package cn.gd.cz.hong.leetcode.xor;

import org.junit.jupiter.api.Test;

/**
 * 异或练习
 */
public class OddNumberTest {

    /**
     * 一个数组里面只有一个数量为奇数的数字
     * 其他数字在数组中的数量都是偶数
     * <p>
     * 这里可以利用 异或 一个数字异或它本身 等于零
     * 而一个数异或0等于他本身
     * 即 0^N = N
     * N^N = 0
     */
    public void oneOddNumber() {
        int[] array = {1, 2, 2, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6};
        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        System.out.println("only one odd number is " + result);
    }

    @Test
    public void testOneOddNumber() {
        oneOddNumber();
    }

    /**
     * 一个数组里面有两个 数量为奇数的数字
     * 其他数字在数组中的数量都是偶数
     * <p>
     * 这里可以先算出全部数字异或的结果
     * xor = a ^ b
     * 我们根据 xor 中一位 为1 即a与b不同的一位
     * 这里我们可以使用 xor & (~xor + 1) 取到xor 从低位往前数 的第一位 1的数字
     * <p>
     * xor 0011
     * ~xor + 1 => 1100 -> 1101
     * xor & (~xor + 1) => 0001
     * <p>
     * 记为lastOne 使用该数字将数组一分为二
     * 只异或一部分 我们就可以找到a 或者 b
     * 然后将异或一半的结果记为 xor`
     * <p>
     * 即 xor`可能为 a或者为 b
     * 使用xor ^ xor`可以得到另外一个数字
     */
    public void twoOddNumber() {
        int[] array = {1, 2, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6};
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }
        System.out.println("xor is " + xor);

        int lastOne = xor & (~xor + 1);
        int a = 0;
        for (int i : array) {
            if ((lastOne & i) == 1) {
                a ^= i;
            }
        }
        System.out.println("number a is " + a + ", number b is " + (xor ^ a));
    }

    @Test
    public void testTwoOddNumber() {
        twoOddNumber();
    }
}
