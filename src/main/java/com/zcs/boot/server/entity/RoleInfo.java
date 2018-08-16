package com.zcs.boot.server.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author: zhengcs
 * @Desc: 角色信息
 * @Date: 2018/6/19 19:40
 * @Modified:
 **/
@Entity
@Table(name="tb_role_info")
public class RoleInfo implements Serializable {

    @Id@GeneratedValue
    private Integer id;

    @Column(unique = true,name="oid_role")
    private String oidRole;

    @Column(name="name_role")
    private String nameRole;

    private String description;

    private Integer status;

    @ManyToMany
    @JoinTable(name="tb_role_menu",joinColumns = {@JoinColumn(name="oid_role",referencedColumnName = "oid_role")},inverseJoinColumns = {@JoinColumn(name="oid_menu",referencedColumnName = "oid_menu")})
    private List<MenuInfo> menuList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="tb_oper_role2",joinColumns = {@JoinColumn(name="oid_role",referencedColumnName = "oid_role")},inverseJoinColumns = {@JoinColumn(name="oid_oper",referencedColumnName = "oid_oper")})
    private List<OperInfo> operList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOidRole() {
        return oidRole;
    }

    public void setOidRole(String oidRole) {
        this.oidRole = oidRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuInfo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuInfo> menuList) {
        this.menuList = menuList;
    }

    public List<OperInfo> getOperList() {
        return operList;
    }

    public void setOperList(List<OperInfo> operList) {
        this.operList = operList;
    }
}
