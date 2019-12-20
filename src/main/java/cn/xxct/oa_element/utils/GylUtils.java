package cn.xxct.oa_element.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GylUtils {
    public static String getDDH(String type) {
        Calendar cal = Calendar.getInstance();//使用日历类
        int year = cal.get(Calendar.YEAR);
        int mouth = cal.get(Calendar.MONTH) + 1;//得到月,从0开始所以加一
        int day = cal.get(Calendar.DAY_OF_MONTH);//得到天
        return type + year + mouth + day;
    }


    /**
     * 订单类别头
     */
    private static final String ORDER_CODE = "1";
    /**
     * 退货类别头
     */
    private static final String RETURN_ORDER = "2";
    /**
     * 退款类别头
     */
    private static final String REFUND_ORDER = "3";
    /**
     * 未付款重新支付别头
     */
    private static final String AGAIN_ORDER = "4";
    /**
     * 随即编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};
    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 14;

    /**
     * 更具id进行加密+加随机数组成固定长度编码
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            //ASCII '0'到'9'对应数字48到57，减去48就是0到9了
            //得到当前下标i的字符 这个字符-'0'就是它本身的十进制 传入
            idsbs.append(r[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     *
     * @param n 长度
     */
    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        //new Random().nextDouble()生成0到1之间小数随机数转换为Long失去小数位8+1最多等于9
        //就算不够位数+min也能够位数
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     * 生成不带类别标头的编码
     *
     * @param userId
     */
    private static synchronized String getCode(Long userId) {
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }

    /**
     * 生成订单单号编码
     *
     * @param userId
     */
    public static String getOrderCode(Long userId) {
        return ORDER_CODE + getCode(userId);
    }

    /**
     * 生成退货单号编码
     *
     * @param userId
     */
    public static String getReturnCode(Long userId) {
        return RETURN_ORDER + getCode(userId);
    }

    /**
     * 生成退款单号编码
     *
     * @param userId
     */
    public static String getRefundCode(Long userId) {
        return REFUND_ORDER + getCode(userId);
    }

    /**
     * 未付款重新支付
     *
     * @param userId
     */
    public static String getAgainCode(Long userId) {
        return AGAIN_ORDER + getCode(userId);
    }


    public static void main(String[] args) {
        String userid = getOrderCode(1000l);
        String userid2 = getOrderCode(1000l);
        System.out.println(userid.equals(userid2));
    }
}
