package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.makeIntArray;
import static cn.gd.cz.hong.leetcode.util.ArrayUtils.notNeedSorted;

/**
 * 堆排序
 */
public class HeapSortTest {

    public void sort(int[] array) {
        if (notNeedSorted(array)) {
            return;
        }
        // 打牌的时候 平均分成两堆牌组
        // 不断地往下拆分
        // 直到剩余一张
        // 然后不断向上合并排序
        process(array, 0, array.length - 1);
    }

    public void process(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(array, l, mid);
        process(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private void merge(int[] array, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lIndex = l;
        int rIndex = mid + 1;
        int i = 0;
        while (lIndex <= mid && rIndex <= r) {
            help[i++] = array[lIndex] <= array[rIndex] ? array[lIndex++] : array[rIndex++];
        }
        while (lIndex <= mid) {
            help[i++] = array[lIndex++];
        }
        while (rIndex <= r) {
            help[i++] = array[rIndex++];
        }
        System.arraycopy(help, 0, array, l, help.length);
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
