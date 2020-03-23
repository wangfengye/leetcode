package Array;



import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res=new int[k];
        Arrays.fill(res,Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {
                if(arr[i]<res[j]){
                    for (int l = k-1; l > j; l--) {
                        res[l]=res[l-1];
                    }
                    res[j]=arr[i];
                    break;
                }
            }
        }
        return res;
    }
    //快排
    public static int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);
    }

    private static void quickSort(int[] arr, int l, int r, int k) {
        int lt=l;
        int rt=r;
        if(l>=r)return;
        int mid = arr[ (l+r)/2];
        while (l<=r){
            while (l<=r&&arr[l]<mid){
                l++;
            }
            while (r>=l&&arr[r]>mid){
                r--;
            }
            if (l <= r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;r--;
            }
        }
        if(r>=k){
            quickSort(arr,lt,r,k);
        }else {
            quickSort(arr,l,rt,k);
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3,2,1},2)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,1,2,1},1)));
        System.out.println(Arrays.toString(getLeastNumbers1(new int[]{3,2,1},2)));
        System.out.println(Arrays.toString(getLeastNumbers1(new int[]{0,1,2,1},1)));
    }

}
