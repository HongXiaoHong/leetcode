package cn.gd.cz.hong.leetcode.dichotomy;

import cn.gd.cz.hong.leetcode.util.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 二分法测试
 */
public class DichotomyTest {

    /**
     * 二分法
     * 判断数字num 是否存在数组中
     *
     * @param sortedArray 排好序的数组
     * @param num         寻找的数字
     * @return 数字是否存在数组中
     */
    public boolean isExisted(int[] sortedArray, int num) {
        // 排除特殊情况
        if (sortedArray == null) {
            return false;
        }
        if (sortedArray.length == 1) {
            return sortedArray[0] == num;
        }

        int left = 0;
        int right = sortedArray.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            // 可以优化为 int mid = left + ((right - left) >> 1);
            // left + right 有可能超出精度 越界计算可能得到负数
            if (sortedArray[mid] == num) {
                return true;
            }
            if (sortedArray[mid] > num) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return false;
    }

    @Test
    public void test() {
        int[] array = ArrayUtils.makeIntArray(10);
        Arrays.sort(array);
        System.out.println("array : " + Arrays.toString(array) + ", num is " + array[2] + ", isExisted is " + isExisted(array, array[2]));
    }

    /**
     * 二分法
     * 判断数字num 是否存在数组中
     *
     * @param sortedArray 排好序的数组
     * @param num         寻找的数字
     * @return 数字是否存在数组中
     */
    public int leftIndex(int[] sortedArray, int num) {
        // 排除特殊情况
        if (sortedArray == null) {
            return -1;
        }
        if (sortedArray.length == 1) {
            return 0;
        }

        int left = 0;
        int right = sortedArray.length - 1;
        while (left != right) {
            int mid = left + ((right - left) >> 1);
            if (sortedArray[mid] < num) {
                left = mid + 1; // 可以避免left right相差1 出现死循环的情况
                continue;
            }
            right = mid;
        }
        return sortedArray[left] == num ? left : -1;
    }

    @Test
    public void testLeftIndex() {
        int[] array = {13, 19, 96, 96, 96, 96, 97, 208, 219, 230, 260, 536, 536};
        Arrays.sort(array);
        System.out.println("array : " + Arrays.toString(array) + ", num is " + array[2] + ", leftIndex is " + leftIndex(array, array[2]));
    }

    /**
     * 局部最小
     * 二分法不一定非得用在有序队列上
     *
     * @param array 无序数组 相邻数不相等
     * @return 局部最小的数字 一个即可
     */
    public int min(int[] array) {
        // https://www.bilibili.com/video/BV13g41157hK?p=3&vd_source=eabc2c22ae7849c2c4f31815da49f209
        // 1:47:51 秒
        System.out.println("set is " + Arrays.toString(array));
        if (array[0] < array[1]) {
            return 0;
        }
        int length = array.length;
        if (array[length - 1] < array[length - 2]) {
            return length - 1;
        }
        int left = 1;
        int right = length - 2;
        while (left != right) {
            int mid = left + ((right - left) >> 1);
            if (isMinLocal(array, mid)) {
                return mid;
            }
            if (array[mid - 1] < array[mid]) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return -1;
    }

    private boolean isMinLocal(int[] array, int mid) {
        return array[mid - 1] > array[mid] && array[mid] < array[mid + 1];
    }

    @Test
    public void testMin() {
//        array 无序数组 相邻数不相等
        int[] array = {23, 19, 96, 97, 98, 93, 99, 208, 219, 230, 260, 531, 536};
        System.out.println("minIndex is " + min(array));
        ;
    }
}
