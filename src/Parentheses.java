import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 */
public class Parentheses {
    public List<String> generateParenthesis(int n) {
        if (n ==0)return null;
        ArrayList<String> list = new ArrayList<>();
        def(0,0,list,new char[n*2],n);
        return list;
    }

    public void def(int left,int right,ArrayList<String> list,char[] buffer,int n){
        if (left+right ==2*n){
            list.add(String.copyValueOf(buffer));return;
        }
        if (left<n){
            buffer[left+right]='(';
            def(left+1,right,list,buffer,n);
        }
        if (left>right){
            buffer[left+right]=')';
            def(left,right+1,list,buffer,n);
        }
    }
}
