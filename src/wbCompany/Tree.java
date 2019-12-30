package wbCompany;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 公司树结构
 */
public class Tree implements IFun, Serializable {
    Node root;

    public static Tree createCompany(Staff staff) {
        Tree tree = new Tree();
        tree.root = new Node(staff);
        return tree;
    }

    @Override
    public void traverseDepartment() {
        traverseDepartmentDfs(root, 0);
    }

    /**
     * 遍历展示
     *
     * @param node 节点
     * @param deep 树深度
     */
    private void traverseDepartmentDfs(Node node, int deep) {
        if (node.val.department == null) {
            //底层员工;
            return;
        }
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        System.out.println(node.val.department.title);
        for (int i = 0; i < node.children.size(); i++) {
            traverseDepartmentDfs(node.children.get(i), deep + 1);
        }
    }

    @Override
    public void traverseStaff() {
        traverseStaffDfs(root, 0);
    }

    private void traverseStaffDfs(Node node, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        System.out.println(node.val.name);
        for (int i = 0; i < node.children.size(); i++) {
            traverseStaffDfs(node.children.get(i), deep + 1);
        }
    }

    @Override
    public String contactTwoStaff(String a, String b) {
        Node aN = findByName(a);
        Node bN = findByName(b);
        if (aN == null) return a + " 员工不存在";
        if (bN == null) return b + " 员工不存在";
        if (findByNameDfs(aN, b) != null) {
            //b在a的子树中.
            return b + " 是 " + a + " 的下属";
        } else if (findByNameDfs(bN, a) != null) {
            return a + " 是 " + b + " 的下属";
        } else {
            return "两者没有从属关系";
        }
    }

    @Override
    public boolean edit(String depart, Department o) {
        Node node=findByDepart(depart);
        if (node==null){
            return false;
        }
        node.val.department.update(o);
        return true;
    }

    @Override
    public boolean edit(String name, Staff o) {
        Node node=findByName(name);
        if (node==null){
            return false;
        }
        node.val.update(o);
        return true;
    }



    @Override
    public boolean add(String departName, Staff d) {
        Node node = findByDepart(departName);
        if (node == null ) {
            return false;
        }
        node.addChild(new Node(d));
        return true;
    }

    @Override
    public boolean removeDepart(String name) {
        Node node=findParentDepartDfs(root,name,null);
        if (node==null){
            //两种情况
            //1. 目标节点是根节点.
            //2. 未找到目标节点
            return false;
        }
        for (int i = 0; i < node.children.size(); i++) {
            if (node.children.get(i).val.department.title.equals(name)){
                node.children.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     *  查找目标节点的父节点
     * @param root 搜索到的节点
     * @param title 目标节点部门名称
     * @param parent 搜索到的节点父节点
     * @return 目标节点的父节点
     */
    private Node findParentDepartDfs(Node root,String title,Node parent){
        if (root.val.department!=null&&root.val.department.title.equals(title)){
            return parent;
        }
        for (int i=0;i<root.children.size();i++){
            return  findParentDepartDfs(root.children.get(i),title,root);
        }
        return null;
    }
    @Override
    public boolean removeStaff(String name) {
        Node node=findParentNameDfs(root,name,null);
        if (node==null){
            //两种情况
            //1. 目标节点是根节点.
            //2. 未找到目标节点
            return false;
        }
        for (int i = 0; i < node.children.size(); i++) {
            if (node.children.get(i).val.name.equals(name)){
                node.children.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     *  查找目标节点的父节点
     * @param root 搜索到的节点
     * @param name 目标节点名称
     * @param parent 搜索到的节点父节点
     * @return
     */
    private Node findParentNameDfs(Node root,String name,Node parent){
        if (root.val.name.equals(name)){
            return parent;
        }
        for (int i=0;i<root.children.size();i++){
            return  findParentNameDfs(root.children.get(i),name,root);
        }
        return null;
    }

    @Override
    public Node findByName(String name) {
        return findByNameDfs(root, name);
    }
    private Node findByNameDfs(Node node, String name) {
        if (node == null) return null;
        if (node.val.name.equals(name)) {
            return node;
        }
        Node res;
        for (int i = 0; i < node.children.size(); i++) {
            if ((res = findByNameDfs(node.children.get(i), name)) != null) {
                return res;
            }
        }
        return null;
    }
    @Override
    public Node findByDepart(String depart) {
        return findByDepartDfs(root,depart);
    }

    private Node findByDepartDfs(Node root, String depart) {
        if (root==null||root.val.department==null){
        return null;}
        if (root.val.department.title.equals(depart)){
            return root;
        }
        Node res;
        for (int i = 0; i < root.children.size(); i++) {
            if ((res = findByDepartDfs(root.children.get(i), depart)) != null) {
                return res;
            }
        }
        return null;
    }



    @Override
    public void showMembership(String name) {
        Node node =findByName(name);
        if (node==null){
            System.out.println("不存在的员工");return;
        }
        Node parent= findParentNameDfs(root,name,null);
        System.out.println("个人信息:");
        System.out.println("\t"+node.val.toString());
        System.out.println("所属部门:");
        if (parent==null){
            System.out.println("\t公司大Boss,无上级部门");
            return;
        }
        System.out.println(parent.val.department.toString());
    }

    @Override
    public void showDepartShip(String title) {
        Node node=findByDepart(title);
        if (node==null){
            System.out.println("不存在的部门");return;
        }
        Node parent= findParentDepartDfs(root,title,null);
        System.out.println("部门信息:");
        System.out.println("\t"+node.val.department.toString()+":负责人='"+node.val.name+'\'');
        System.out.println("上级部门:");
        if (parent==null){
            System.out.println("\t,顶级部门,无上级部门");
            return;
        }
        System.out.println(parent.val.department.toString());
    }
}

class Node implements Serializable{
    Staff val;
    ArrayList<Node> children;

    void addChild(Node o) {
        children.add(o);
    }

    public Node(Staff val) {
        children = new ArrayList<>();
        this.val = val;
    }
}