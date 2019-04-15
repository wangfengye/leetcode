package sort;

import java.util.Arrays;

/**
 * @author maple on 2019/4/14 14:44.
 * @version v1.0
 * @see 1040441325@qq.com
 * 堆排序
 * 思路: 使用最大堆: 构建最大堆,堆顶为最大值,移到最后,重复该过程,
 */
public class HeapSort {
    private static void buildMaxHeap(int[] arr) {
        len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    /**
     * 堆调整结果为最大堆
     * @param arr
     * @param i
     */
    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;// 节点id的左子树
        int right = 2 * i + 2;// 节点id的右子树
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            BubbleSort.swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    private static int len;

    public static void sort(int[] arr) {
        buildMaxHeap(arr);//构建大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            BubbleSort.swap(arr, 0, i);//去除大顶
            len--;
            heapify(arr, 0);//调整堆
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 2, 54, 8, 2};
        int[] b = new int[]{1, 2, 3, 4, 5, 6};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
