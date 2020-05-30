package sort;



import java.util.Arrays;

/**
 * @author maple on 2019/4/12 16:21.
 * @version v1.0
 * @see 1040441325@qq.com
 * 快速排序
 */
public class QuickSort {
    /**
     * 局限,当数据非结构化即,分布极不均匀时,性能会退化到n^2
     * @param nums
     * @param l
     * @param r
     */
    public static void sort(int[] nums, int l, int r) {
        int partIndex;
        if (l < r) {
            partIndex = partition(nums, l, r);
            sort(nums, l, partIndex - 1);
            sort(nums, partIndex + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {

        int tem = nums[l];
        while (l < r) {
            while (l < r && nums[r] >tem) r--;
            if (l < r) {
                nums[l]=nums[r];
                l++;
            }
            while (l < r && nums[l] < tem) l++;
            if (l < r) {
                nums[r] =nums[l];
                r--;
            }
        }
        nums[l]=tem;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 2, 54, 8, 2};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        byte a=-1;byte b=11;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1));
        int c =a&b;
        System.out.println(c);
        quickSort2(nums, 0, nums.length - 1, null, 0, 0);


    }
    /*******************Java源码中的排序算法*******************************/
    /**
     * 关键词, TimSort ,Dual_Pivot QuackSort, insertionSort
     * 该排序算法,对局部有序的算法友好,(统计表明,大量数据的排序存在该情况)
     * 主要思路
     * 超短数组直接插入排序
     * 稍长数组直接进行双轴快排
     * 大数组,使用Timsort,
     * TimSort (归并的思路)步骤
     *  1. 遍历找数组中的有序段落,当连续相等元素过多,有序段落太小(即run数组不够存有序段index),改用快速排序
     *  2. 对有序的数组进行合并操作.
     *  经典快排和Dual_pivot 快排
     *  * 经典 元素比较次数少, dual_pivot 扫描元素少
     *  * 早期经典性能好, 随cpu发展,限制排序速度的门槛到了内存读取上, dual_pivot 性能更好
     *      * 因为现代场景cpu性能太好了,多比较几次元素消耗性能远少于 多读取元素消耗的性能.
     *
     */
    /**
     * 数组元素少于该值,使用快速排序.
     */
    private static final int QUICKSORT_THRESHOLD = 286;
    /**
     * 最多分区
     */
    private static final int MAX_RUN_COUNT = 67;
    // 归并的长度
    private static final int MAX_RUN_LENGTH = 33;
    /**
     * java 源码.
     * @param a 被排序的数组
     * @param left  first element
     * @param right last element
     * @param work 排序过程中使用的临时数组
     * @param workBase 合并有序数组段时的临时数组
     * @param workLen 临时数组的可用大小
     */
    public static void quickSort2(int[] a, int left, int right,
                                  int[] work, int workBase, int workLen) {
        if(right-left<QUICKSORT_THRESHOLD){
            //短数组使用快速排序.
            //源码中在快速 排序中加了个判断,<47的使用插入排序.
            // 快排采用的Dual_Pivot算法(该算法比经典快排减少了元素扫描次数)
            // 基准点选取: 从中点开始,以(长度/7)为步长,取五个点(包含中点),对五个点进行插入排序,
            // ,取 2,4两个点作为基准点.
            sort(a,left,right);outer:
            return;
        }
        //TimSort.
        int[] run=new int[MAX_RUN_COUNT+1];
        int count =0;run[0]=left;
        //找到排列好的数组段,记录在run中
        for (int k = left; k < right; run[count]=k) {
            if(a[k]<a[k+1]){//一个递增块
                //k递增,找到非递增的点
                while (++k<=right&&a[k-1]<=a[k]);
            }else if(a[k]>a[k+1]){//递减块
                // k递减, 找到非递减点
                while (++k <= right && a[k - 1] >= a[k]);
                /**
                 * 将递减块,变为递增块.
                 * 开始  lo=run[count] hi=k-1
                 * 每次循环后 lo++ hi--;
                 * zhi到 lo>=hi,跳出循环
                 * 循环中搅浑 lo, hi位置的值
                 */
                for (int lo = run[count] - 1, hi = k; ++lo < --hi; ) {
                    int t = a[lo]; a[lo] = a[hi]; a[hi] = t;
                }
            }else {//找到连续相等的数.
                for (int m = MAX_RUN_LENGTH; ++k <= right && a[k - 1] == a[k]; ) {
                    if (--m == 0) {//连续相等的数过多,直接快排.
                        sort(a, left, right);
                        return;
                    }
                }
            }
            /**
             * 原话:非高度结构化数据,采用快速排序替代归并排序
             * 理解:当run[]空间使用完时,还有数据没有放入run[]中,使用快速排序
             */
            if (++count == MAX_RUN_COUNT) {
                sort(a, left, right);
                return;
            }
        }
        //todo 根据run中记录的排序好的段落,进行归并.
    }
}
