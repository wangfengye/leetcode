package search;

/**
 * @author maple on 2018/11/24 14:04.
 * @version v1.0
 * @see 1040441325@qq.com
 * 寻找比目标字母大的最小字母
 *
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'
 */
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l =0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (letters[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }

        return l < letters.length ? letters[l] : letters[0];
    }

    public static void main(String[] args){
       //System.out.println(NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'a') );
       System.out.println(NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'c') );
        //System.out.println(NextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'},'k') );
    }

}
