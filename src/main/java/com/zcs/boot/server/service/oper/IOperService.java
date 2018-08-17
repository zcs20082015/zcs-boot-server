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



    /**
    *@Desc: 获取操作员信息
    *@Author: zhengcs
    *@Date: 2018/6/20 12:48
    *@Modified: 
    */
    public OperInfo getOperInfo(String correlationID, String oidOper);

    /**
    *@Desc: 获取操作员角色
    *@Author: zhengcs
    *@Date: 2018/6/20 12:48
    *@Modified: 
    */
    public List<RoleInfo> getRoleListByOper(String correlationID, String oidOper);

    /**
    *@Desc: 获取操作员权限信息
    *@Author: zhengcs
    *@Date: 2018/6/20 12:49
    *@Modified: 
    */
    public List<String> getPermissionsByOper(String correlationID, String oidOper);

    /**
    *@Desc: 通过url查询菜单
    *@Author: zhengcs
    *@Date: 2018/6/20 12:49
    *@Modified: 
    */
    public String getMenuCodeByUrl(String correlationID,String url);
}
