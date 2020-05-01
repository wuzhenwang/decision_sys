package edu.sxu.decision_sys.entity;

/**
 * @author wzw
 * @version 1.0
 * @description 角色表
 * @date 2020/5/1 16:33
 */
public class Role {
    private String roleId;
    private String name;
    private String nameZh;

    public String getName() {
        return name;
    }
    public String getRoleId() {
        return roleId;
    }
    public String getNameZh() {
        return nameZh;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
