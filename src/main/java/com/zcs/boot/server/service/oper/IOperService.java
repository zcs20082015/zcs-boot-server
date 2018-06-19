package com.zcs.boot.server.service.oper;


import com.zcs.boot.server.entity.MenuInfo;
import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.entity.RoleInfo;

import java.util.List;

/**
*@Desc:
*@Author: zhengcs
*@Date: 2018/6/19 20:30
*@Modified: 
*/
public interface IOperService {



    public OperInfo getOperInfo(String correlationID, String oidOper);

    public List<RoleInfo> getRoleListByOper(String correlationID, String oidOper);

    public List<MenuInfo> getMenuListByOper(String correlationID, String oidOper);

    public String getMenuCodeByUrl(String correlationID,String url);
}
