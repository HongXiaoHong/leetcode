package cn.gd.cz.hong.leetcode.data.structure;

import cn.gd.cz.hong.leetcode.util.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 堆结构
 */
public class HelloHeap {

    public void heapInsert(int[] array, int num, int heapSize) {
        int index = heapSize;
        while (array[index] > array[(index - 1) / 2]) {
            ArrayUtils.swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    @Test
    public void testHeapInsert() {
        int[] array = new int[10];
        insertHeap(array, 1, 0);
        System.out.println("array is  " + Arrays.toString(array));
        insertHeap(array, 3, 1);
        System.out.println("array is  " + Arrays.toString(array));
        insertHeap(array, 8, 2);
        System.out.println("array is  " + Arrays.toString(array));
        /* result:->
         array is  [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         array is  [3, 1, 0, 0, 0, 0, 0, 0, 0, 0]
         array is  [8, 1, 3, 0, 0, 0, 0, 0, 0, 0]
         */
    }

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
    public static void heapify(int[] array, int index, int heapSize) {
        int left = 2 * index + 1; // 左子节点
        while (left < heapSize) { // 当前节点拥有左子树
            int largest = left + 1 < heapSize
                    && array[left] < array[left + 1] ?
                    left + 1 : left; // 左子节点 右子节点哪个大
            largest = array[index] > array[largest] ? index : largest; // 头结点跟左右节点哪个最大
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
