package cn.gd.cz.hong.leetcode.util;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 数组操作工具类
 */
public class ArrayUtils {

    /**
     * 交换数组元素
     *
     * @param array 数组
     * @param pre   交换第一个索引
     * @param post  交换第二个索引
     */
    public static void swap(int[] array, int pre, int post) {
        if (pre == post) {
            return;
        }
        array[pre] = array[pre] ^ array[post];
        array[post] = array[pre] ^ array[post];
        array[pre] = array[pre] ^ array[post];
    }

    public static boolean notNeedSorted(int[] array) {
        return array == null || array.length < 2;
    }

    /**
     * 生成一个长度为n的随机数组
     *
     * @param n 数组长度
     * @return 随机数组
     */
    public static int[] makeIntArray(int n) {
        return IntStream.range(1, n).map(item -> new Random().nextInt(item * 100)).toArray();
    }
}
