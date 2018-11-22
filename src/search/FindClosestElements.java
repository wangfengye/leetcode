package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 * <p>
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l =0;
        int r = arr.length-1;
        while (l<=r){
            int mid = (r-l)/2+l;
            if (arr[mid]<x)l=mid+1;
            else r=mid-1;
        }
        if (l>0&&arr[l]>x)l=l-1;
        List<Integer> res = new ArrayList<>();
        res.add(arr[l]);
        r = l;
        while (res.size() < k) {
            if (l < 1 && r > arr.length - 2) break;
            if (l >= 1 && r <= arr.length - 2) {
                if (x - arr[l - 1] <= arr[r + 1] - x) {
                    res.add(arr[l - 1]);
                    l--;
                } else {
                    res.add(arr[r + 1]);
                    r++;
                }
            } else if (l < 1) {
                res.add(arr[r + 1]);
                r++;
            } else {
                res.add(arr[l - 1]);
                l--;
            }
        }
        Collections.sort(res);
        return res;
    }
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = (r -l) / 2+l;
            if (x - arr[mid] > arr[mid + k] - x)
                l = mid + 1;
            else
                r = mid;
        }
        List<Integer> results = new ArrayList<Integer>();
        for (int i = l; i < l + k; i++) {
            results.add(arr[i]);
        }
        return results;
    }
    public static void main (String[] args){
        new FindClosestElements().findClosestElements(new int[]{1,2,3,4,5},4,3);
    }
}
