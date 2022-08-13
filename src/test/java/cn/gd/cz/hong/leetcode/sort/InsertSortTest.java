package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.notNeedSorted;
import static cn.gd.cz.hong.leetcode.util.ArrayUtils.swap;

/**
 * 插入排序
 */
public class InsertSortTest {

    /**
     * 原地进行排序
     *
     * @param array 数组
     */
    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        /*
        像打牌一样 左边有序 右边无序
        从右边无序的牌中抽取一张
        跟左边有序的牌组 最右开始比较
        大了不需要再往前比较了
        小了继续往前直到前面没有数字或者比前面的数字大了
         */
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j - 1, j);
            }
        }
    }

    @Test
    public void test() {
        int[] randomArray = IntStream.range(1, 10).map(item -> new Random().nextInt(item * 100)).toArray();
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        sort(randomArray);
        System.out.println("after: ");
        System.out.println(Arrays.toString(randomArray));
    }/*
    test result:
     before:
     [15, 143, 99, 395, 492, 194, 457, 576, 638]
     after:
     [15, 99, 143, 194, 395, 457, 492, 576, 638]
     */


}
