package wbCompany;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入口函数
 * 公司组织结构简易模型.
 */
public class Main {
    private static void showMenu() {
        System.out.println("1.遍历公司部门");
        System.out.println("2.遍历公司职员");
        System.out.println("3.输入两名员工,确定关系");
        System.out.println("4.编辑部门信息");
        System.out.println("5.编辑职员信息");
        System.out.println("6.添加部门");
        System.out.println("7.移除部门(会解散部门下所有人)");
        System.out.println("8.添加职员");
        System.out.println("9.移除职员(移除负责人,会同时移除负责人管理部门)");
        System.out.println("10.查询部门信息及隶属关系");
        System.out.println("11.查询职员信息及隶属关系");
        System.out.println("12.SAVE");
    }

    static Staff addStaff(Scanner sc) {
        Staff staff5 = new Staff();
        System.out.print("员工姓名: ");
        staff5.name = sc.next();
        System.out.print("员工性别(1:表示女性/0男性): ");
        staff5.sex = sc.nextInt() == 1;
        System.out.print("员工职务: ");
        staff5.duty = sc.next();
        System.out.print("员工职称: ");
        staff5.dutyName = sc.next();
        return staff5;
    }

    private static void addTestData(Tree tree) {
        Staff s1 = new Staff();
        s1.name = "A";
        s1.duty = "市场规划";
        s1.dutyName = "高级";
        s1.department = new Department("市场", "销售");
        tree.add("公司", s1);
        Staff s11 = new Staff();
        s11.name = "小z";
        s11.duty = "推销";
        s11.dutyName = "初级";
        tree.add("市场", s11);
        Staff s12 = new Staff();
        s12.name = "小g";
        s12.duty = "推销";
        s12.dutyName = "初级";
        tree.add("市场", s12);

        Staff s2 = new Staff();
        s2.name = "A";
        s2.sex = true;
        s2.duty = "人才管理";
        s2.dutyName = "高级";
        s2.department = new Department("人事", "人才管理");
        tree.add("公司", s2);
        Staff s21 = new Staff();
        s21.name = "小高";
        s21.duty = "招聘";
        s21.dutyName = "初级";
        tree.add("人事", s21);
        Staff s22 = new Staff();
        s22.name = "樊欣";
        s22.duty = "内务";
        s22.dutyName = "初级";
        tree.add("人事", s22);


    }

    public static void main(String[] args) throws IOException {
        //构造公司总部,

        Staff staff = new Staff();
        staff.name = "Boss";
        staff.duty = "总裁";
        staff.dutyName = "总裁";
        staff.department = new Department("公司", "整体管理");
        Tree tree = readFromFile();
        if (tree == null) {
            tree = Tree.createCompany(staff);
            addTestData(tree);
        }
        Scanner sc = new Scanner(System.in);
        int c;
        while (true) {
            showMenu();
            try {
                c = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("异常字符");
                sc.next();
                continue;
            }
            switch (c) {
                case 1:
                    tree.traverseDepartment();
                    break;
                case 2:
                    tree.traverseStaff();
                    break;
                case 3:
                    System.out.print("输入A员工姓名:");
                    String nameA = sc.next();
                    System.out.print("输入A员工姓名:");
                    String nameB = sc.next();
                    System.out.println(tree.contactTwoStaff(nameA, nameB));
                    break;
                case 4:
                    Department d4 = new Department();
                    System.out.print("输入要修改的部门名称: ");
                    String dname = sc.next();
                    System.out.print("输入修改后的部门名称: ");
                    d4.title = sc.next();
                    System.out.print("输入修改后的部门职能: ");
                    d4.fun = sc.next();
                    if (tree.edit(dname, d4)) System.out.println("修改成功 ");
                    else System.out.println("修改失败 ");
                    break;
                case 5:
                    System.out.print("要修改的员工姓名:");
                    String name5 = sc.next();
                    System.out.print("修改后的信息:");
                    if (tree.edit(name5, addStaff(sc))) System.out.println("修改成功 ");
                    else System.out.println("修改失败 ");
                    break;
                case 6:
                    Department d6 = new Department();
                    System.out.print("输入要添加的部门: ");
                    String name6 = sc.next();
                    System.out.print("部门名称: ");
                    d6.title = sc.next();
                    System.out.print("部门职能: ");
                    d6.fun = sc.next();
                    System.out.print("添加负责人信息");
                    Staff s6 = addStaff(sc);
                    s6.department = d6;
                    if (tree.add(name6, s6)) System.out.println("新增成功");
                    else System.out.println("新增失败");
                    break;
                case 7:
                    System.out.print("输入要解散的部门: ");
                    String name7 = sc.next();
                    if (tree.removeDepart(name7)) System.out.println("部门移除成功");
                    else System.out.println("部门移除失败");
                    break;
                case 8:
                    System.out.print("输入要加入的部门: ");
                    String name8 = sc.next();
                    System.out.print("新增的员工信息:");
                    if (tree.add(name8, addStaff(sc))) System.out.println("新增成功 ");
                    else System.out.println("新增失败 ");
                    break;
                case 9:
                    System.out.print("要移除的员工姓名");
                    String name9 = sc.next();
                    if (tree.removeStaff(name9)) System.out.println("员工移除成功");
                    else System.out.println("员工移除失败");
                    break;
                case 10:
                    System.out.println("要查询的部门姓名");
                    String name10 = sc.next();
                    tree.showDepartShip(name10);
                    break;
                case 11:
                    System.out.println("要查询的员工姓名");
                    String name11 = sc.next();
                    tree.showMembership(name11);
                    break;
                case 12:
                    saveToFile(tree);
                    break;
                default:
                    System.out.println("未定义的指令");
                    break;

            }
            System.out.println("\n\n任意键+回车继续");
            sc.next();
        }
    }

    private static final String fileName = "company.info";

    private static void saveToFile(Tree tree) {
        FileOutputStream os;
        ObjectOutputStream oos;
        try {
            os = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(os);
            oos.writeObject(tree);
            oos.flush();
            oos.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Tree readFromFile() {
        try {
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is);
            Tree tree = (Tree) ois.readObject();
            ois.close();
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
