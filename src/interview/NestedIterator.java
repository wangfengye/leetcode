package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author maple on 2019/4/2 9:49.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Pair> stack;
    List<NestedInteger> mList;
    int i = 0;
    Integer next;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        mList = nestedList;
        getNext();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer tmp = next;
        if (tmp!=null)getNext();
        return tmp;
    }

    private void getNext() {
        NestedInteger tmp;
        while (true) {
            if (mList == null) {
                next = null;
                return;
            } else if (mList.size() <= i) {
                if (stack.isEmpty()){
                    next = null;
                    return;
                }
                Pair pair = stack.pop();
                mList = pair.mList;
                i = pair.index + 1;
            } else if (!(tmp = mList.get(i)).isInteger()) {
                stack.add(new Pair(i, mList));
                mList = tmp.getList();
                i = 0;
            } else {
                next = tmp.getInteger();
                i++;
                return;
            }
        }
    }
    //转为ArrayList,再用ArrayList的迭代器.
    static ArrayList<Integer> mArrayList = new ArrayList<>();
    private void unfold(List<NestedInteger> nestedList){
        for (int j = 0; j < nestedList.size(); j++) {
            if (nestedList.get(j).isInteger)mArrayList.add(nestedList.get(j).getInteger());
            else unfold(nestedList.get(j).getList());
        }
    }

    static class Pair {
        int index;
        List<NestedInteger> mList;

        public Pair(int index, List<NestedInteger> list) {
            this.index = index;
            this.mList = list;
        }
    }

    static class NestedInteger {
        Integer i;
        List<NestedInteger> list;
        boolean isInteger;

        public NestedInteger(Integer i) {
            this.i = i;
            isInteger=true;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
            isInteger=false;
        }

        public boolean isInteger(){
            return isInteger;
        }

        public Integer getInteger(){
            return  i;
        }


        public List<NestedInteger> getList(){
            return list;
        }
    }
    public static void main(String[] args){
        ArrayList<NestedInteger> a = new ArrayList<>();
        a.add(new NestedInteger(1));
        a.add(new NestedInteger(1));
        ArrayList<NestedInteger> b = new ArrayList<>();
        b.add(new NestedInteger(1));
        b.add(new NestedInteger(1));
        ArrayList<NestedInteger> c = new ArrayList<>();
        c.add(new NestedInteger(a));
        c.add(new NestedInteger(2));
        c.add(new NestedInteger(b));
        NestedIterator n = new NestedIterator(c);
        /*while (n.hasNext()){
            System.out.println(n.next());
        }*/
        n.unfold(c);
        System.out.println(mArrayList.toString());
    }
}

