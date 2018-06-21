package com.zcs.boot.server.service.oper.impl;

import com.zcs.boot.server.dao.MenuInfoDao;
import com.zcs.boot.server.dao.OperInfoDao;
import com.zcs.boot.server.entity.MenuInfo;
import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.entity.RoleInfo;
import com.zcs.boot.server.exception.BusinessException;
import com.zcs.boot.server.exception.ParameterException;
import com.zcs.boot.server.service.oper.BaseService;
import com.zcs.boot.server.service.oper.IOperService;
import com.zcs.boot.server.share.util.UtilTool;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OperService extends BaseService implements IOperService {

    @Resource
    private OperInfoDao operInfoDao;
    @Resource
    private MenuInfoDao menuInfoDao;



    @Override
    @Cacheable(value = "operInfo", key="'oper-'+#oidOper")
    public OperInfo getOperInfo(String correlationID, String oidOper) {
        info(correlationID,oidOper,"进入操作员信息查询接口");
        if(isNull(oidOper)){
            throw new ParameterException();
        }
        OperInfo oper = operInfoDao.getOperInfoByOidOper(oidOper);

        return oper;
    }

    @Override
    @Cacheable(value = "operInfo",key="'roles-'+#oidOper")
    public List<RoleInfo> getRoleListByOper(String correlationID, String oidOper){

        OperInfo oper=getOperInfo(correlationID,oidOper);

        if(null==oper){
            throw new BusinessException("操作员信息不存在");
        }
        if(null!=oper.getRoleList()){
            return oper.getRoleList();
        }

        return new ArrayList<>();
    }

    @Override
    @Cacheable(value = "operInfo",key="'permissions-'+#oidOper")
    public List<String> getPermissionsByOper(String correlationID, String oidOper) {

        OperInfo oper=getOperInfo(correlationID,oidOper);

        if(null==oper){
            throw new BusinessException("操作员信息不存在");
        }

        if(null==oper.getRoleList()){
            return new ArrayList<>();
        }

        Set<String> permissions=new HashSet<>();
        for(RoleInfo role:oper.getRoleList()){
            if(null!=role && null!=role.getMenuList()){
                for (MenuInfo menu:role.getMenuList()){
                    if(null!=menu){
                        permissions.add(menu.getOidMenu());
                    }
                }
            }
        }


        return new ArrayList<>(permissions);
    }

    @Override
    @Cacheable(value = "menuInfo",key = "'url-'+#url")
    public String getMenuCodeByUrl(String correlationID, String url) {
        if(isNull(url)){
            throw new ParameterException();
        }

        MenuInfo menu=menuInfoDao.getDistinctFirstByUrl(url);

        if(null!=menu){
            return menu.getOidMenu();
        }

        return null;
    }
}