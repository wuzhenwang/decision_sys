package edu.sxu.decision_sys.entity;

/**
 * @author wzw
 * @version 1.0
 * @description 菜单
 * @date 2020/5/2 16:40
 */
public class Menu {
    private String menuId; // 菜单id
    private String menuName; // 菜单名字
    private String menuUrl; // 菜单链接
    private String menuIcon; // 菜单图标
    private String parentId;
    private Integer sortId; // 菜单排序id

    public Menu(){}
    public Menu(String menuId, String menuName, String menuUrl, String menuIcon, String parentId, Integer sortId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuIcon = menuIcon;
        this.parentId = parentId;
        this.sortId = sortId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
