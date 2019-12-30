package wbCompany;

import java.io.Serializable;

/**
 * 员工
 */
public class Staff implements Serializable {
    String name;//员工名/部门名.,在系统中需要保证唯一性
    boolean sex;//false:为男性
    String duty;//职务
    String dutyName;//职称
    Department department=null; //负责部门

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void update(Staff s){
        if (s.name!=null)this.name=s.name;
        this.sex=s.sex;//性别有默认值,直接覆盖.
        if (s.dutyName!=null)this.dutyName=s.dutyName;
        if (s.duty!=null)this.duty=s.duty;
        if (s.department!=null)this.department.update(s.department);
    }

    @Override
    public String toString() {
        return  ", 姓名='" + name + '\'' +
                "性别=" + (sex?"女":"男") + '\''+
                  ", 职务='" + duty + '\'' +
                ", 职称='" + dutyName+ '\''+
               (department==null?"":", 负责部门='"+department.title+ '\'');
    }
}
