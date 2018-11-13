package hash;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        for (int num : nums2) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        int[] temp = new int[max - min + 1];
        for (int num : nums1) {
            temp[num - min] = 1;
        }
        int count = 0;
        for (int num : nums2) {
            if (temp[num - min] == 1) {
                temp[num - min]++;
                count++;
            }
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) {
                res[count] = min + i;
                count++;
            }
        }
        return res;
    }

    /**
     * 两个数组的交集 II
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        boolean[] base = new boolean[nums1.length];
        int i = 0;
        int j = 0;
        int len = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                base[i] = true;
                len++;
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[len];
        len = 0;
        for (int k = 0; k < base.length; k++) {
            if (base[k]) {
                res[len] = nums1[k];
                len++;
            }
        }
        return res;
    }

}
