package com.zcs.boot.server.share.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


/**
*@Desc: 通用工具类
*@Author: zhengcs
*@Date: 2018/6/19 16:46
*@Modified: 
*/
public class UtilTool {
	/**
	 * 获得日期  yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static Date getDate(String str){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获得日期  yyyy-MM-dd
	 * @return String
	 */
	public static Date getDate1(String str){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获得日期字符串  yyyyMMddHHmmss
	 * @return String
	 */
	public static String getStringDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	/**
	 * 获得日期字符串  yyyyMMddHHmmss
	 * @return String
	 */
	public static String getTimeStamp(String datestr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStamp = "";
		try {
			long time = sdf.parse(datestr).getTime();
			timeStamp += time;
		} catch (Exception e){

		}
		return  timeStamp;
	}
	
	/**
	 * 
	 * @Title: getStringDateByDay
	 * @author xiangf
	 * @date 2017年3月8日 下午2:36:38
	 * @Description: yyyy-MM-dd
	 * @param @param date
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringDateByDay(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 获取当前日期字符串 yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrent14StringDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * 获得当前日期字符串  yyyyMMdd
	 * @return String
	 */
	public static String getCurrent8StringDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * 获得前一天日期字符串  yyMMdd
	 * @return String
	 */
	public static String getFormateStringDate6(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Calendar canlendar = Calendar.getInstance(); 
	    canlendar.setTime(new Date());
	    canlendar.add(Calendar.DATE, -1);
		return sdf.format(canlendar.getTime());
	}
	
	/**
	 * 获得前一天日期字符串  yyyyMMdd
	 * @return String
	 */
	public static String getFormateStringDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar canlendar = Calendar.getInstance(); 
	    canlendar.setTime(new Date());
	    canlendar.add(Calendar.DATE, -1);
		return sdf.format(canlendar.getTime());
	}
	
	/**
	 * 获得近7天日期字符串  yyMMdd
	 * @return String
	 */
	public static String getFormateStringDate7(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar canlendar = Calendar.getInstance(); 
	    canlendar.setTime(new Date());
	    canlendar.add(Calendar.DATE, +7);
		return sdf.format(canlendar.getTime());
	}
	/**
	 * 获得近30天日期字符串  yyMMdd
	 * @return String
	 */
	public static String getFormateStringDate30(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar canlendar = Calendar.getInstance(); 
	    canlendar.setTime(new Date());
	    canlendar.add(Calendar.DATE, +30);
		return sdf.format(canlendar.getTime());
	}
	/**
	 * 获得前N天日期字符串 yyyyMMdd
	 * 
	 * @return String
	 */
	public static String getFormateStringDate(int day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(new Date());
		canlendar.add(Calendar.DATE, -day);
		return sdf.format(canlendar.getTime());
	}	
	/**
	 * 获取当前日期字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrent19StringDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
	/**
	 * 加X天
	 * @param
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	 public static String addDate(long day) throws ParseException {
		  long time = System.currentTimeMillis();
		  day = day*24*60*60*1000;
		  time+=day;
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		  return sdf.format(new Date(time));
	 } 
	/**
	 * 加法运算
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double add(double d1, double d2){       
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }
	
	/**
	 * 减法运算 d1-d2
	 * @param d1
	 * @param d2
	 * @return
	 */
    public static double subtract(double d1, double d2){        
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }
    
	/**
	 * 加法运算
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long add(long d1, long d2){       
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).longValue();
    }
	
	/**
	 * 减法运算d1-d2
	 * @param d1
	 * @param d2
	 * @return
	 */
    public static long subtract(long d1, long d2){        
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).longValue();
    }
	
    /**
     * 乘法运算
     * @param d1
     * @param d2
     * @return
     */
    public static long multiply(long d1, long d2){
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).longValue();
    }
    
    /**
     * 乘法运算
     * @param d1
     * @param d2
     * @return
     */
    public static double multiply(long d1, double d2){
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * 除法运算
     * @param d1
     * @param d2
     * @return
     */
    public static long divide(long d1,long d2) {
    	BigDecimal b1 = new BigDecimal(Double.valueOf(d1));
	    BigDecimal b2 = new BigDecimal(Double.valueOf(d2));
	    return b1.divide(b2,BigDecimal.ROUND_FLOOR).longValue();
    }
    
    
    
    /**
     * String转换为Long型
     * @param str
     * @return
     */
    public static Long StringToLong(String str){
    	if(str != null && !"".equals(str)){
    		return Long.parseLong(str);
    	}
    	return null;
    }
    
    /**
     * <p>Function: 判断字符串是否为空</P>
     * @author liuzhy
     * @date 2015-8-28 下午3:39:55
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if (null == str || "NULL".equalsIgnoreCase(str) || "".equals(str)){
            return true;
        } else{
        	return false;
        }
    }
    
    /**
     * <p>Function: 获取真实的IP地址</P>
     * @date 2015-8-28 下午3:40:14
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        if (!isNull(ip) && ip.contains(",")){
            String[] ips = ip.split(",");
            ip = ips[ips.length - 1];
        }
        return ip;
    }
    
    /**
     * <p>Function: 流转字符串方法</P>
     * @date 2015-9-1 下午8:56:18
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is){
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line = null;

            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            try{
                if (null != reader){
                    reader.close();
                }
            } catch (IOException e){

            }
        }
        return sb.toString();
    }

    /**
     * <p>Function: 非注册用户</P>
     * @date 2015-9-22 下午1:49:05
     * @param id
     * @return
     */
    public static boolean isMachineId(String id){
        if (isNull(id))
        {
            return false;
        }
        if (id.length() != 32)
        {
            return false;
        }
        return true;
    }
    
    /**
     * <p>Function: 校验是否为正整数</P>
     * @date 2015-9-29 下午2:34:00
     * @param str
     * @return
     */
    public static boolean isNum(String str){
    	if(isNull(str)){
    		return false;
    	}
    	String regex = "/^[1-9]+\\d*$";
    	if(str.matches(regex)){
    		return true;
    	}
    	return false;
    }
    
    /**
     * <p>Function: 校验是否为非负整数</P>
     * @date 2015-10-19 下午1:48:18
     * @param str
     * @return
     */
    public static boolean isNotNegativeInt(String str){
    	if(isNull(str)){
    		return false;
    	}
    	String regex = "^\\d+$";
    	if(str.matches(regex)){
    		return true;
    	}
    	return false;
    }
    /**
     * 检查是否为中文名称
     * @param
     * @return
     */
    public static boolean isChinaName(String name)
    {
        if (isNull(name))
        {
            return false;
        }
        return Pattern.matches("[\u4E00-\u9FA5]{1,15}?(?:[·.．•][\u4E00-\u9FA5]{1,15})*", name);
    }
    /** 
     * @author yuanqf
     * @date 2016/10/25 21:19:22
     * 校验银行卡卡号 
     * @param cardId 
     * @return 
     */  
    public static boolean checkBankCard(String cardId) {  
          char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));  
          if(bit == 'N'){  
              return false;  
          }  
          return cardId.charAt(cardId.length() - 1) == bit;  
    }  
     
    /** 
     * @author yuanqf
     * @date 2016/10/25 21:21:12
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位 
     * @param nonCheckCodeCardId 
     * @return 
     */  
    public static char getBankCardCheckCode(String nonCheckCodeCardId){  
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0  
                || !nonCheckCodeCardId.matches("\\d+")) {  
         //如果传的不是数据返回N  
            return 'N';  
        }  
        char[] chs = nonCheckCodeCardId.trim().toCharArray();  
        int luhmSum = 0;  
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {  
            int k = chs[i] - '0';  
            if(j % 2 == 0) {  
                k *= 2;  
                k = k / 10 + k % 10;  
            }  
            luhmSum += k;             
        }  
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');  
    }  
    /** 
     * @author yuanqf
     * @date 2017/01/04 15:241:13
     * 判断是否为整数  
     * @param str 传入的字符串  
     * @return 是整数返回true,否则返回false  
   */
    private static Pattern INTEGER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");
    public static boolean isInteger(String str) {
        return INTEGER_PATTERN.matcher(str).matches();
      }  
    
    /**
     * @param str
     * @return
     * @Date   2017年3月30日 下午6:02:04
     */
    public static Set<String> commaDelimitedStringToSet(String str) {
        Set<String> set = new HashSet<String>();
        String[] split = str.split(",");
        for (String aSplit : split) {
            String trimmed = aSplit.trim();
            if (trimmed.length() > 0) {
				set.add(trimmed);
			}
        }
        return set;
    }


	public static void main(String[] args) {

		System.out.println(MD5Utils.MD5Encrpytion(MD5Utils.MD5Encrpytion("11111111")));
	}
}
