package com.zcs.boot.server.dao;

import com.zcs.boot.server.entity.MenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: zhengcs
 * @Desc:
 * @Date: 2018/6/19 20:28
 **/
public interface MenuInfoDao extends CrudRepository<MenuInfo,Integer>{

    public MenuInfo getMenuInfoByOidMenu(String oidMenu);

    public MenuInfo getDistinctFirstByUrl(String url);
}
