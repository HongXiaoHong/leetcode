package cn.gd.cz.hong.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static cn.gd.cz.hong.leetcode.util.ArrayUtils.*;

/**
 * 快速排序
 */
public class QuickSortTest2 {

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

    private void process(int[] array, int low, int height) {
        // 先随机选择一个数字 pivot 放到最后
        // 使用分治法 将数组切割成 三部分 小于 等于 大于 pivot 三部分
        if (low < height) {
            // 随机选择一个数字放到最后
            int pivotIndex = low + (int) (Math.random() * (height - low + 1));
            swap(array, pivotIndex, height);

            // 将数组切割为三部分 并且返回等于 pivot 的数组
            // 因为有可能 等于 pivot 有多个值 这里返回一个数组
            int[] p = partition(array, low, height);
            process(array, low, p[0] - 1);
            process(array, p[1] + 1, height);
        }
    }

    /**
     * 设计成数组是因为有可能 有多个 pivot 的数字
     * 分别返回 小于 大于 pivot 的数字
     *
     * @param array
     * @param low
     * @param height
     * @return
     */
    private int[] partition(int[] array, int low, int height) {
        int smallIndex = low - 1;
        int bigIndex = height;
        int pivot = array[height];

        while (low < bigIndex) {
            if (array[low] < pivot) {
                swap(array, ++smallIndex, low++); // 小于 pivot 队列里面都是比 pivot小的 直接走了
            } else if (array[low] > pivot) {
                swap(array, --bigIndex, low); // 从 大于 pivot的索引拿过来的是没有比较过的 还得继续比较 不继续++
            } else {
                low++; // 等于 pivot 直接走了
            }
        }
        swap(array, bigIndex, height);
        return new int[]{smallIndex + 1, bigIndex};
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
