package findtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 数之和
 */
public class FindNumsTarget {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * <p>
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        boolean[] table = new boolean[max - min + 1];
        for (int i = 0; i < nums.length; i++) table[nums[i] - min] = true;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) break;
            int j = i + 1;
            while (j < nums.length - 1) {
                if (nums[i] + nums[j] * 2 > 0) break;
                int k = j + 1;
                int need = 0 - nums[i] - nums[j];
                if (need <= max && table[need - min] && nums[k] <= need) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(need);
                    result.add(r);
                }
                j = goNext(nums, j);
            }
            i = goNext(nums, i);
        }
        return result;
    }

    private int goNext(int[] nums, int pos) {
        int value = nums[pos];
        while (pos + 1 < nums.length) {
            if (value != nums[pos + 1]) return pos + 1;
            else pos++;
        }
        return pos + 1;
    }

    /**
     * 四数之和
     * 核心思路:先排序,再遍历,尽量减少不必要的遍历
     * 每取一个数考虑边界效果: 最大和小于target,跳过本次循环,最小和大于target,跳出循序;
     * 下一个数与上一个数值相同,跳过遍历
     * 取到最后两数,两端逼近
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];

        int i = 0;
        while (i < nums.length-3) {
            if (nums[i] * 4 > target) break;
            int j = i + 1;
            while (j < nums.length-2) {
                if (nums[i] + nums[j] * 3 > target) break;
                int l = j + 1;
                int r = nums.length-1;
                while(l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
                j = goNext(nums, j);
            }
            i = goNext(nums, i);
        }
        return result;
    }
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){ //nums[i] is too large
                break;
            }
            if(nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target){//nums[i] is too small
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]){  //跳过重复项
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2] > target){   //nums[j] is too large
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1] + nums[nums.length-2] < target){ // nums[j] is too small
                    continue;
                }
                if(j>i+1 && nums[j]==nums[j-1]){    //跳过重复项
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
    public static void main (String[] args){
        new FindNumsTarget().fourSum2(new int[]{91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245},
        -236727523);
    }
}
