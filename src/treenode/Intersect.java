package treenode;

/**
 * @author maple on 2020/1/2 13:28.
 * @version v1.0
 * @see 1040441325@qq.com
 * 558. 四叉树交集
 */
public class Intersect {
    public Node intersect(Node quadTree1, Node quadTree2) {
        Node quadTree3=new Node();
        due(quadTree1,quadTree2,quadTree3);
        combine(quadTree3);
        return quadTree3;
    }

    private int combine(Node quadTree3) {
        if(quadTree3.isLeaf){
            return quadTree3.val?1:0;
        }
        int tl=combine(quadTree3.topLeft);
        int tr=combine(quadTree3.topRight);
        int bl=combine(quadTree3.bottomLeft);
        int br=combine(quadTree3.bottomRight);

        if(tl!=2&&tl==tr&&tl==bl &&tl==br){
            quadTree3.val=tl==1;
            quadTree3.isLeaf=true;
            quadTree3.topLeft=null;
            quadTree3.topRight=null;
            quadTree3.bottomLeft=null;
            quadTree3.bottomRight=null;
            return tl;
        }
        return 2;
    }

    private void due(Node quadTree1, Node quadTree2, Node quadTree3) {
        if(quadTree1.isLeaf&&quadTree2.isLeaf){
            quadTree3.isLeaf=true;
            quadTree3.val=quadTree1.val||quadTree2.val;
            return;
        }
        quadTree3.topLeft=new Node();
        due(quadTree1.topLeft==null?quadTree1:quadTree1.topLeft,
                quadTree2.topLeft==null?quadTree2:quadTree2.topLeft,
                quadTree3.topLeft);
        quadTree3.topRight=new Node();
        due(quadTree1.topRight==null?quadTree1:quadTree1.topRight,
                quadTree2.topRight==null?quadTree2:quadTree2.topRight,
                quadTree3.topRight);
        quadTree3.bottomLeft=new Node();
        due(quadTree1.bottomLeft==null?quadTree1:quadTree1.bottomLeft,
                quadTree2.bottomLeft==null?quadTree2:quadTree2.bottomLeft,
                quadTree3.bottomLeft);
        quadTree3.bottomRight=new Node();
        due(quadTree1.bottomRight==null?quadTree1:quadTree1.bottomRight,
                quadTree2.bottomRight==null?quadTree2:quadTree2.bottomRight,
                quadTree3.bottomRight);
    }
    public static void main(String[] args){

    }
}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
    public void showStep(Node node,int deep){
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        if(node.isLeaf){
            System.out.println(node.val);
        }else {
            System.out.println("NULL");
            showStep(node.topLeft,deep+1);
            showStep(node.topRight,deep+1);
            showStep(node.bottomLeft,deep+1);
            showStep(node.bottomRight,deep+1);
        }

    }
    public void show(){
        showStep(this,0);
    }
}