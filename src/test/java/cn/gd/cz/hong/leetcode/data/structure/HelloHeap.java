package cn.gd.cz.hong.leetcode.data.structure;

import cn.gd.cz.hong.leetcode.util.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 堆结构
 */
public class HelloHeap {

    // 插入堆
    public void insertHeap(int[] array, int num, int heapSize) {
        int parentIndex = (heapSize - 1) / 2;
        int parent = array[parentIndex];
        if (parent < num) {
            array[heapSize] = parent;
            array[parentIndex] = num;
        } else {
            array[heapSize] = num;
        }
    }

    @Test
    public void testInsertHeap() {
        int[] array = new int[10];
        insertHeap(array, 1, 0);
        System.out.println("array is  " + Arrays.toString(array));
    }

    // 删除最大数
    public int deleteMaxNum(int[] array, int heapSize) {
        int maxNum = array[0];
        array[0] = array[--heapSize];
        heapify(array, 0, heapSize);
        return maxNum;
    }

    // 堆化
    private void heapify(int[] array, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize
                    && array[left] < array[left + 1] ?
                    left + 1 : left;
            largest = array[index] > array[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            ArrayUtils.swap(array, index, largest);
            index = largest;
            left = 2 * largest + 1;
        }
    }

    @Test
    public void testDeleteMaxNum() {
        int[] array = new int[]{10, 12, 11, 0, 0, 0, 0, 0, 0, 0};
        deleteMaxNum(array, 3);
        System.out.println("array is  " + Arrays.toString(array));
    }

    // todo 更新堆
    public void update() {

    }


}
