package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.data.structure.HelloHeap.heapify;
import static cn.gd.cz.hong.leetcode.util.ArrayUtils.*;

/**
 * 堆排序
 * 时间复杂度 O(N * logN)
 * 空间复杂度 O(1)
 */
public class HeapSortTest {

    public void sort(int[] array, int heapSize) {
        if (notNeedSorted(array)) {
            return;
        }
        // 从右往左 堆化数组 最右的默认是叶子不需要堆化 加一个元素堆化一次
        for (int i = array.length - 1; i >= 0; i--) { // O(N)
            heapify(array, i, array.length); // O(logN)
        }
        System.out.println("after heapify array to be " + Arrays.toString(array));
        // 将大根堆 第一个元素与最后一个元素交换 堆长度减1 即让最后一个失效
        // 堆化 剩余的元素 继续交换 直到第一个元素停止
        while (heapSize > 0) { // O(N)
            swap(array, 0, --heapSize);
            heapify(array, 0, heapSize); // O(logN)
        }
    }

    @Test
    public void test() {
//        int[] randomArray = {13, 12, 11, 2, 1};
        int[] randomArray = {1, 12, 11, 2, 13};
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        sort(randomArray, 5);
        System.out.println("after: ");
        System.out.println(Arrays.toString(randomArray));
    }
}
