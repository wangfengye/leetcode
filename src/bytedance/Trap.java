package bytedance;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author maple on 2019/2/19 10:07.
 * @version v1.0
 * @see 1040441325@qq.com
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 */
public class Trap {
    public int trap(int[] height) {
        int idx = 0;
        int lefth = 0;
        int righth = 0;
        int area = 0;
        //1. 找出最高点
        //2. 从两侧逼近,一直取最高点,当前点比边缘逼近的最高点低的即是可存水面积
        for (int i = 0; i < height.length; i++) {//最高id
            idx = height[idx] <= height[i] ? i : idx;
        }
        for (int i = 0; i < idx; i++) {
            if (height[i]<lefth)area+=lefth-height[i];
            else lefth=height[i];
        }
        for (int i = height.length-1; i >idx; i--) {
            if (height[i]<righth)area+=righth-height[i];
            else righth=height[i];
        }
        return area;
    }
    public int trap2(int[] height) {
        int area = 0;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty())stack.push(new Pair<>(height[i],i));
            else if (height[i]<stack.peek().getKey()){
                stack.push(new Pair<>(height[i],i));
            }else {
                while (!stack.empty()&&height[i]>stack.peek().getKey()){
                    Pair<Integer,Integer> tmp = stack.pop();
                    if (!stack.empty()){
                        area+=(i-1- stack.peek().getValue())*(Math.min(stack.peek().getKey(),height[i])-tmp.getKey());
                    }
                }
                stack.push(new Pair<>(height[i],i));
            }
        }
        return area;
    }
    public static void main(String[] args){
        System.out.println(new Trap().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
