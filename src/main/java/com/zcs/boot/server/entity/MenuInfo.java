package com.zcs.boot.server.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: zhengcs@uubee.com
 * @Desc: 菜单信息
 * @Date: 2018/6/19 19:30
 * @Modified:
 **/
@Entity
@Table(name="tb_menu_info")
public class MenuInfo implements Serializable {

    @Id@GeneratedValue
    private Integer id;

    @Column(unique = true,name="oid_menu")
    private String oidMenu;

    @Column(name="name_menu")
    private String nameMenu;

    private Integer level;

    @Column(name="parent_menu")
    private String parentMenu;

    private String url;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOidMenu() {
        return oidMenu;
    }

    public void setOidMenu(String oidMenu) {
        this.oidMenu = oidMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }
}
