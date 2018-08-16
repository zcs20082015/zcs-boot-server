package com.zcs.boot.server.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author: zhengcs
 * @Desc: 操作员信息表
 * @Date: 2018/6/19 19:06
 * @Modified:
 **/
@Entity
@Table(name="tb_oper_info")
public class OperInfo implements Serializable {

    @Id@GeneratedValue
    private Integer id;

    @Column(unique = true,name="oid_oper")
    private String oidOper;

    @Column(name="name_oper")
    private String nameOper;

    @Column(name="user_login")
    private String userLogin;

    private String password;

    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="tb_oper_role2",joinColumns={@JoinColumn(name="oid_oper",referencedColumnName = "oid_oper")},inverseJoinColumns = {@JoinColumn(name="oid_role",referencedColumnName = "oid_role")})
    private List<RoleInfo> roleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOidOper() {
        return oidOper;
    }

    public void setOidOper(String oidOper) {
        this.oidOper = oidOper;
    }

    public String getNameOper() {
        return nameOper;
    }

    public void setNameOper(String nameOper) {
        this.nameOper = nameOper;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleInfo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleInfo> roleList) {
        this.roleList = roleList;
    }

}
