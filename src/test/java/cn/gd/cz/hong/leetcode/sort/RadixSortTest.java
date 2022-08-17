package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.makeIntArray;
import static cn.gd.cz.hong.leetcode.util.ArrayUtils.notNeedSorted;

/**
 * 基数排序
 */
public class RadixSortTest {

    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 打牌的时候 从左到右 依次拿起两张牌 前面比后面的大 进行交换
        // 继续往后比较直到把最大的都挪到最后
        radixSort(array, maxBits(array));
    }

    private void radixSort(int[] array, int maxBits) {
        final int radix = 10;
        int i = 0, j = 0;

        int[] bucket = new int[array.length];
        for (int d = 1; d <= maxBits; d++) {
            int[] counts = new int[radix];
            for (i = 0; i < array.length; i++) {
                j = getDigit(array[i], d);
                counts[j]++;
            }
            for (i = 1; i < radix; i++) {
                counts[i] = counts[i] + counts[i - 1];
            }
            for (i = array.length - 1; i >= 0; i--) {
                j = getDigit(array[i], d);
                bucket[counts[j] - 1] = array[i];
                counts[j]--;
            }
            for (i = 0, j = 0; i < array.length; i++, j++) {
                array[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 获取一个数组中最大数字的位数
     *
     * @param array 整形数组
     * @return 最大数字的位数
     */
    public int maxBits(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();
        int maxBits = 0;
        while (maxNum > 0) {
            maxNum /= 10;
            maxBits++;
        }
        return maxBits;
    }

    @Test
    public void test() {
        int[] randomArray = makeIntArray(10);
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        sort(randomArray);
        System.out.println("after: ");
        System.out.println(Arrays.toString(randomArray));
    }
}
