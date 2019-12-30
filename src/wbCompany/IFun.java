package wbCompany;

/**
 * 功能接口
 */
public interface IFun {
    //遍历部门
    void traverseDepartment();
    //遍历职员
    void traverseStaff();

    /**
     *  判断两人关系
     * @param a
     * @param b
     * @return 两者关系
     */
    String contactTwoStaff(String a,String b);

    /**
     * 编辑信息
     * @param  depart 要修改的部门名
     * @param o 编辑后的对象
     * @return 编辑成功
     */
    boolean edit(String depart,Department o);
    /**
     * 编辑信息
     * @param  name 要修改的员工名
     * @param o 编辑后的对象
     * @return 编辑成功
     */
    boolean edit(String name,Staff o);


    /**
     * 新增员工
     * 新增部门使用同一接口.因为部门和负责人是同时存在的.
     * 新增部门=新增一个有部门的负责人
     * @param departName 部门名
     * @param d 要增加的成员
     * @return
     */
    boolean add(String departName,Staff d);
    /**
     * 删除部门,自动解散其下属成员
     * @param name 部门名
     * @return 是否成功.
     */
    boolean removeDepart(String name);
    /**
     * 删除节点,删除部门负责人,自动解散其下属成员
     * @param name 人名
     * @return 是否成功.
     */
    boolean removeStaff(String name);

    /**
     * 根据姓名查找节点.
     * @param name 节点名称
     * @return 节点
     */
    Node findByName(String name);
    /**
     * 根据部门查找节点.
     * @param depart 部门名称
     * @return 节点
     */
    Node findByDepart(String depart);
    /**
     *  查询一个成员的隶属关系
     * @param name 名称.
     */
    void showMembership(String name);
    /**
     *  查询一个部门的隶属关系
     * @param title 名称.
     */
    void showDepartShip(String title);


}
