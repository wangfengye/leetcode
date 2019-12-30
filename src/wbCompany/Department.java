package wbCompany;

import java.io.Serializable;

/**
 * 部门
 */
public class Department implements Serializable {
    String title;
    String fun;//职能


    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public Department() {
    }

    public Department(String title, String fun) {
        this.title = title;
        this.fun = fun;
    }
    public void update(Department d){//根据传入的对象更新自身属性
        if (d.title!=null)this.title=d.title;
        if (d.fun!=null)this.fun=d.fun;
    }

    @Override
    public String toString() {
        return "名称='" + title + '\'' +
                ", 职能='" + fun + '\'';
    }
}
