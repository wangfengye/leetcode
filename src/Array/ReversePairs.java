package Array;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class ReversePairs {
    public static void main(String[] args) {
        // System.out.println(new ReversePairs().reversePairs(new int[]{7, 5, 6, 4}));
        ExecutorService a = Executors.newFixedThreadPool(1);
        Object o = new Object();
        a.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println(System.currentTimeMillis() + ": start");
                    try {
                        o.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + ": end");
                }
            }
        });
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (o) {
            o.notifyAll();
        }

    }

    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    //归并排序
    private int merge(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            //j-(mid+1)右侧比arr[i]小的个数.
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }
}
