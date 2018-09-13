/**
 * 字符串乘法
 */
public class BigNumberMult {
    public static void main(String[] args){
        System.out.println(multiply("123","456"));
        System.out.print(multiply("0","0"));
    }
    // 按位相乘累加
    public static String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int m = nums1.length;
        int n = nums2.length;
        int[] o = new int[m + n-1];

        for (int i = 0; i < m; i++) {
            int mx = nums1[i] - '0';
            for (int j = 0; j < n; j++) {
                o[i + j] += mx * (nums2[j] - '0');
            }
        }
        int start=0;
        while (start < m+n-2 && o[start] == 0) start++;
        int end = m+n-2;
        int temp = 0;
        StringBuilder builder = new StringBuilder();
        while (end>=start) {
            builder.insert(0, (o[end] + temp) % 10);
            temp = (o[end] + temp) / 10;
            end--;
        }
        if (temp > 0) builder.insert(0,temp);
        return builder.toString();

    }
}
