package weibo;

import nTreenode.Node;

import java.util.Stack;

/**
 * @author maple on 2019/8/28 9:58.
 * @version v1.0
 * @see 1040441325@qq.com
 * 微博:超大数之和
 *
 */
public class bigNumber {
    public static void main(String[] args) {
        System.out.println("a:"+toNode(12345).toString());
        System.out.println("b:"+toNode(1633999).toString());
        System.out.println("a+b:"+add(toNode(12345), toNode(1633999)).toString());
        System.out.println("验证: "+(12345 + 1633999));
    }

    public static Node add(Node a, Node b) {
        Stack<Byte> aS = new Stack<>();
        Stack<Byte> bS = new Stack<>();
        Node tr = new Node((byte) 126);
        while (a != null && a.val != 126) {

            aS.push(a.val);
            a = a.next;
        }
        while (b != null && b.val != 126) {
            bS.push(b.val);
            b = b.next;
        }
        int up = 0;
        while (aS.size() > 0 && bS.size() > 0) {
            int tmp = aS.pop() + bS.pop() + up;
            int tmpV = tmp % 10;
            up = tmp / 10;
            Node node = new Node((byte) tmpV);
            node.next = tr;
            tr = node;
        }
        while (aS.size() > 0) {
            Node node = new Node(aS.pop());
            node.next = tr;
            tr = node;
        }
        while (bS.size() > 0) {
            Node node = new Node(bS.pop());
            node.next = tr;
            tr = node;
        }
        return tr;
    }

    static class Node {
        byte val;//节点的值都是个位数.- 用127表示,126表示null
        Node next;

        public Node(byte val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node tmp = this;
            while (tmp != null) {
                if (tmp.val == 127) {
                    builder.append('-');
                    builder.append(" -> ");
                } else if (tmp.val == 126) {
                    builder.append("null");
                } else {
                    builder.append(tmp.val);
                    builder.append(" -> ");
                }
                tmp = tmp.next;
            }
            return builder.toString();
        }
    }

    public static Node toNode(int num) {
        if (num == 0) return new Node((byte) 0);
        Node res = null;
        if (num < 0) {
            num = -num;
            res = new Node((byte) 127);
        }
        Node tr = new Node((byte) 126);
        while (num > 0) {
            byte tmp = (byte) (num % 10);
            num /= 10;
            Node node = new Node(tmp);
            node.next = tr;
            tr = node;
        }
        if (res == null) {
            return tr;
        } else {
            res.next = tr;
            return res;
        }
    }

}
