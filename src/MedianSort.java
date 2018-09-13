public class MedianSort {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int a = 0;
        int b = 0;
        int c = nums1.length + nums2.length;
        int[] res = new int[c];
        while (a + b < c) {
            if (a >= nums1.length) {
                res[a + b] = nums2[b];
                b++;
                continue;
            }
            if (b >= nums2.length) {
                res[a + b] = nums1[a];
                a++;
                continue;
            }
            if (nums1[a] < nums2[b]) {
                res[a + b] = nums1[a];
                a++;
            } else {
                res[a + b] = nums2[b];
                b++;
            }
        }
        if (c%2==0)return (res[c/2]+res[c/2-1])/2;
        else  return res[c/2];
    }
    public static void main(String[] args){
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        findMedianSortedArrays(a,b);
    }
}
