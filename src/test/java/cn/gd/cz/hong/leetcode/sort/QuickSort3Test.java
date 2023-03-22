package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.*;

/**
 * 快速排序
 */
public class QuickSort3Test {

    @Test
    public void test() {
        int[] randomArray = makeIntArray(10);
        System.out.println("before: ");
        System.out.println(Arrays.toString(randomArray));
        int[] result = new int[0];
        try {
            result = sort(randomArray);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("log: " + e.getMessage());
        }
        System.out.println("after: ");
        System.out.println(Arrays.toString(result));
    }

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 使用分治法将数组分为小于基准 等于基准 大于基准的区间
     * 然后递归处理
     *
     * @param arr   待排序的数组
     * @param left  左边界
     * @param right 右边界
     * @return 排好序的数组
     */
    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 将数组分为三个区间 分别是小于基准 等于基准 大于基准的区间
     * 这里只是把 小于基准的区间标识出来 并且返回等于基准区间的第一个索引
     *
     * @param arr   带分组的数组
     * @param left  左边界
     * @param right 右边界
     * @return 数组分为 小于基准 等于基准 大于基准的区间
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 设定基准值（pivot）
        int smallLength = left + 1; // 比基准小的序列长度
        for (int i = smallLength; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, smallLength++); // 交换的同时 序列长度加1
            }
        }
        swap(arr, left, smallLength - 1); // 交换基准跟 小于基准集合的最后一个元素
        return smallLength - 1; // 返回中间索引
    }

}