/*
package com.zcs.boot.server.service.oper.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcs.boot.server.service.oper.BaseService;
import com.zcs.boot.server.service.oper.IOperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * @author: zhengcs@uubee.com
 * @Desc: 用户服务
 * @Date: 2018/6/11 21:27
 * @Modified:
 **//*

@Service
public class OperService extends BaseService implements IOperService {



    @Override
    public OperatorInfo getOperInfo(String correlationID, String oidOper) {

        OperatorInfo oper=new OperatorInfo();
        oper.setCorrelationID(correlationID);
        oper.setOid_oper(oidOper);
        oper=operInfoService.operInfoSignleQuery(oper);
        info(correlationID,oidOper,"操作员信息查询结果：",oper);
        if(null==oper){
            throw new UnknownAccountException();
        }
        return oper;
    }

    @Override
    public List getTransCodeByOper(String correlationID,String oidOper){

        OperatorInfo oper=new OperatorInfo();
        oper.setCorrelationID(correlationID);
        oper.setOid_oper(oidOper);
        String result=operInfoService.getOidTransCode(oper);
        info(correlationID,oidOper,"操作员权限菜单查询结果："+result);
        List<String> list=new ArrayList<>();
        if(null!=result){
            list=Arrays.asList(result.split("\\|"));
        }
        return list;
    }


    @Override
    public String getTransCodeByUrl(String correlationID,String url){

        if(FuncUtils.isNull(url)){
            return null;
        }
        List<String> list=operInfoService.getTransCodeByUrl(correlationID,url);
        info(correlationID,url,"url对应transcode查询结果：",list);
        if(null!=list&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
*/
