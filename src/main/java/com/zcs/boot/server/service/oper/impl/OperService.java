package com.zcs.boot.server.service.oper.impl;

import com.zcs.boot.server.dao.OperInfoDao;
import com.zcs.boot.server.entity.MenuInfo;
import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.entity.RoleInfo;
import com.zcs.boot.server.service.oper.BaseService;
import com.zcs.boot.server.service.oper.IOperService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperService extends BaseService implements IOperService {

    @Resource
    private OperInfoDao operInfoDao;



    @Override
    public OperInfo getOperInfo(String correlationID, String oidOper) {
        OperInfo oper=operInfoDao.getOperInfoByOidOper(oidOper);
        return oper;
    }

    @Override
    public List<RoleInfo> getRoleListByOper(String correlationID, String oidOper){
        OperInfo oper=operInfoDao.getOperInfoByOidOper(oidOper);

        if(null!=oper){
            return oper.getRoleList();
        }

        return null;
    }

    @Override
    public List<MenuInfo> getMenuListByOper(String correlationID, String oidOper) {
        return null;
    }

    @Override
    public String getMenuCodeByUrl(String correlationID, String url) {
        return null;
    }
}