package hash;

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
}
