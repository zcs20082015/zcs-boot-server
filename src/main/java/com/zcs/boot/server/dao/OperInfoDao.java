package com.zcs.boot.server.dao;

import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: zhengcs
 * @Desc:
 * @Date: 2018/6/19 20:20
 **/
public interface OperInfoDao extends CrudRepository<OperInfo,Integer> {

    public OperInfo getOperInfoByOidOper(String oidOper);

}
