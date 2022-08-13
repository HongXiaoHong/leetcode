package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.notNeedSorted;
import static cn.gd.cz.hong.leetcode.util.ArrayUtils.swap;

/**
 * 选择排序
 */
public class SelectSortTest {

    /**
     * 原地进行排序
     *
     * @param array 数组
     */
    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 像打牌一样 先把一边排好序 另一边一次抽一张牌过来排序
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                minIndex = array[j] > array[minIndex] ? minIndex : j;
            }
            swap(array, i, minIndex);
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
    }


}
