package com.ooooo.quake.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

/**
 * 随机数工具类
 */
public class RandomUtils {

    /**
     * 获取随机数工具类
     *
     * @param len 长度
     * @return 生成随机数
     */
    public static String getRandom(int len) {
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, len - 1));
        return String.valueOf(rs);
    }

    //获取变量类型方法
    public static String getType(Object o) {
        //使用int类型的getClass()方法
        return o.getClass().toString();
    }


    //自动生成名字（中文）
    public static String getRandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

    //生成随机用户名，数字和字母组成,
    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    public static String randomEnglishName(int min, int max) {
        String name;
        char[] nameChar;
        //名字最长为max个,最短为min个
        int nameLength = (int) (Math.random() * (max - min + 1)) + min;
        nameChar = new char[nameLength];
        //生成大写首字母
        nameChar[0] = (char) (Math.random() * 26 + 65);
        for (int i = 1; i < nameLength; i++) {
            nameChar[i] = (char) (Math.random() * 26 + 97);
        }
        name = new String(nameChar);
        return name;
    }


    /**
     * 当前时间的前1分钟的时间
     * 结果：newDate = 2020-12-24 13:45:40 Before=2020-12-24 13:44:40
     *
     * @param now
     * @return
     */
    public static String getOneMinutebeforeTime(String now) {
        Date date = DateUtil.parse(now);
        Date newDate = DateUtil.offset(date, DateField.MINUTE, -1);
        String startTime = DateUtil.format(newDate, "yyyy-MM-dd HH:mm:ss");
        return startTime;
    }

    /**
     * 获取两月以前时间
     * @param date
     * @return
     */
    public static Date getTwomonthsbeforeTime(Date date) {
        Date newDate = DateUtil.offset(date, DateField.MINUTE, -87552);
//        String startTime = DateUtil.format(newDate, "yyyy-MM-dd HH:mm:ss");

        return newDate;
    }
    /**
     * 当前时间的后1个分钟的时间
     * 结果：newDate = 2020-12-24 13:45:40 Before=2020-12-24 13:46:40
     *
     * @param now
     * @return
     */
    public static String getOneMinuteAfterTime(String now) {
        Date date = DateUtil.parse(now);
        Date newDate = DateUtil.offset(date, DateField.MINUTE, 87552);
        String startTime = DateUtil.format(newDate, "yyyy-MM-dd HH:mm:ss");
        return startTime;
    }

}
