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
}
