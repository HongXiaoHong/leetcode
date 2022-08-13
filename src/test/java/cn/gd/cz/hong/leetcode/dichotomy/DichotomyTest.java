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
            left = mid;
        }
        return false;
    }

    @Test
    public void test() {
        int[] array = ArrayUtils.makeIntArray(10);
        Arrays.sort(array);
        System.out.println("array : " + Arrays.toString(array) + ", num is " + array[2] + ", isExisted is " + isExisted(array, array[2]));
    }
}
