package com.zcs.boot.server.dao;

import com.zcs.boot.server.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhengcs
 * @Desc:
 * @Date: 2018/6/19 20:29
 **/
public interface RoleInfoDao extends JpaRepository<RoleInfo,Integer> {

    public RoleInfo getRoleInfoByOidRole(String oidRole);
}
