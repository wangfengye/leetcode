/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
 */
public class PalindromicSubString {
    public String longestPalindrome(String s) {
        if (s.length()==0)return s;
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length*2+1];
        for (int i = 0; i < chars.length; i++) {
            newChars[2*i]= '#';
            newChars[2*i+1]=chars[i];
        }
        newChars[chars.length*2] ='#';
        int[] rl = new int[newChars.length];
        int maxRight =0;
        int pos =0;
        int subIndex = 0;
        int length =0;
        for (int i = 0; i < newChars.length; i++) {
            if (i<maxRight){//复用以判断过对称性的字符
                rl[i] = Math.min(rl[2*pos-i],maxRight-i);
            }else {
                rl[i] =1;
            }
            while (i-rl[i]>=0&& i+rl[i]<newChars.length){
                if (newChars[i-rl[i]]!= newChars[i+rl[i]])break;
                rl[i]+=1;
                pos =i;
                maxRight =i +rl[i]-1;
            }
            if (rl[i]-1>length){
                length =rl[i]-1;//-1后正好是原字符串的回文长度
                subIndex =i/2;// /2后为回文中心index,若长度为偶数,index中心右侧index
            }
        }

        if (length%2==0)return s.substring(subIndex-length/2,subIndex+length/2);
        else return s.substring(subIndex-length/2,subIndex+length/2+1);
    }
    public static void  main(String[] args){
        System.out.println(new PalindromicSubString().longestPalindrome("ccc"));
    }
}
