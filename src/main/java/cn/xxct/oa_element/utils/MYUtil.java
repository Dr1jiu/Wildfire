package cn.xxct.oa_element.utils;



import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.domain.Dynamic_Message;
import org.activiti.engine.impl.util.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class MYUtil {


    private static AtomicInteger counter = new AtomicInteger(0);

    private static long  getAtomic(){
        return  counter.incrementAndGet();
    }

    public static long getUID(){
        if (counter.get()>999){
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        return time*1000+getAtomic();
    }


    /**
     * 获取UID
     * @return
     */
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

    /**
     * 时间
     * @return
     */
    public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 根据输入的格式获取
     * @param format
     * @return
     */
    public static String getCurrentDateTime(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().format(formatter);
    }
//    private String a_UID;
//    private String unit_Name;
//    private String a_Address;
//    private String a_Phone;
//    private String cp_UID;
//    private String delivery_Name;
//    private String a_Sex;
//    private String a_Emil;
//    private String dm_UID;
    public static Archives jz(JSONObject jsonObject){
        Archives archives = new Archives();
        if (jsonObject.has("a_UID")&&jsonObject.get("a_UID")!=null&&jsonObject.get("a_UID")!=""){
            archives.setA_UID(jsonObject.get("a_UID").toString());
        }
        if (jsonObject.has("unit_Name")&&jsonObject.get("unit_Name")!=null&&jsonObject.get("unit_Name")!=""){
            archives.setUnit_Name(jsonObject.get("unit_Name").toString());
        }
        if (jsonObject.has("a_Address")&&jsonObject.get("a_Address")!=null&&jsonObject.get("a_Address")!=""){
            archives.setA_Address(jsonObject.get("a_Address").toString());
        }
        if (jsonObject.has("a_Phone")&&jsonObject.get("a_Phone")!=null&&jsonObject.get("a_Phone")!=""){
            archives.setA_Phone(jsonObject.get("a_Phone").toString());
        }
        if (jsonObject.has("cp_UID")&&jsonObject.get("cp_UID")!=null&&jsonObject.get("cp_UID")!=""){
            archives.setCp_UID(jsonObject.get("cp_UID").toString());
        }
        if (jsonObject.has("delivery_Name")&&jsonObject.get("delivery_Name")!=null&&jsonObject.get("delivery_Name")!=""){
            archives.setDelivery_Name(jsonObject.get("delivery_Name").toString());
        }
        if (jsonObject.has("a_Sex")&&jsonObject.get("a_Sex")!=null&&jsonObject.get("a_Sex")!=""){
            archives.setA_Sex(jsonObject.get("a_Sex").toString());
        }
        if (jsonObject.has("a_Emil")&&jsonObject.get("a_Emil")!=null&&jsonObject.get("a_Emil")!=""){
            archives.setA_Emil(jsonObject.get("a_Emil").toString());
        }
        if (jsonObject.has("dm_UID")&&jsonObject.get("dm_UID")!=null&&jsonObject.get("dm_UID")!=""){
            archives.setDm_UID(jsonObject.get("dm_UID").toString());
        }
        if (jsonObject.has("dateTime")&&jsonObject.get("dateTime")!=null&&jsonObject.get("dateTime")!=""){
            archives.setDateTime(jsonObject.get("dateTime").toString());
        }
        if (jsonObject.has("state")&&jsonObject.get("state")!=null&&jsonObject.get("state")!=""){
            archives.setState(jsonObject.get("state").toString());
        }
        return archives;
    }

    public static Dynamic_Message dnj(JSONObject jsonObject){
        Dynamic_Message dynamic_message = new Dynamic_Message();
        if (jsonObject.has("a_UID")&&jsonObject.get("a_UID")!=null&&jsonObject.get("a_UID")!=""){
            dynamic_message.setDm_Invoice(jsonObject.get("a_UID").toString());
        }
        if (jsonObject.has("unit_Name")&&jsonObject.get("unit_Name")!=null&&jsonObject.get("unit_Name")!=""){
            dynamic_message.setDm_Products(jsonObject.get("unit_Name").toString());
        }
        if (jsonObject.has("a_Address")&&jsonObject.get("a_Address")!=null&&jsonObject.get("a_Address")!=""){
            dynamic_message.setDm_user_Id(jsonObject.get("a_Address").toString());
        }
        if (jsonObject.has("a_Phone")&&jsonObject.get("a_Phone")!=null&&jsonObject.get("a_Phone")!=""){
            dynamic_message.setDm_Name(jsonObject.get("a_Phone").toString());
        }
        if (jsonObject.has("cp_UID")&&jsonObject.get("cp_UID")!=null&&jsonObject.get("cp_UID")!=""){
            dynamic_message.setCg_UID(jsonObject.get("cp_UID").toString());
        }
        if (jsonObject.has("delivery_Name")&&jsonObject.get("delivery_Name")!=null&&jsonObject.get("delivery_Name")!=""){
            dynamic_message.setDm_state(jsonObject.get("delivery_Name").toString());
        }
        if (jsonObject.has("a_Sex")&&jsonObject.get("a_Sex")!=null&&jsonObject.get("a_Sex")!=""){
            dynamic_message.setDm_dateTime(jsonObject.get("a_Sex").toString());
        }
        return dynamic_message;
    }

    public static Delivery dj(JSONObject jsonObject){
        Delivery delivery = new Delivery();

//        private String d_UID;
//        private String a_UID;
//        private String d_Phone;
//        private Date quasi_Date;
//        private String user_UID;
//        private String d_Remarks;
//        private Character state;
//        private Date dateTime;
        if (jsonObject.has("d_UID")&&jsonObject.get("d_UID")!=null&&jsonObject.get("d_UID")!=""){
            delivery.setD_UID(jsonObject.get("d_UID").toString());
        }
        if (jsonObject.has("a_UID")&&jsonObject.get("a_UID")!=null&&jsonObject.get("a_UID")!=""){
            delivery.setA_UID(jsonObject.get("a_UID").toString());
        }
        if (jsonObject.has("d_Phone")&&jsonObject.get("d_Phone")!=null&&jsonObject.get("d_Phone")!=""){
            delivery.setD_Phone(jsonObject.get("d_Phone").toString());
        }
        if (jsonObject.has("quasi_Date")&&jsonObject.get("quasi_Date")!=null&&jsonObject.get("quasi_Date")!=""){
            delivery.setQuasi_Date(jsonObject.get("quasi_Date").toString());
        }
        if (jsonObject.has("d_Remarks")&&jsonObject.get("d_Remarks")!=null&&jsonObject.get("d_Remarks")!=""){
            delivery.setD_Remarks(jsonObject.get("d_Remarks").toString());
        }
        if (jsonObject.has("state")&&jsonObject.get("state")!=null&&jsonObject.get("state")!=""){
            delivery.setState(jsonObject.get("state").toString());
        }
        if (jsonObject.has("dateTime")&&jsonObject.get("dateTime")!=null&&jsonObject.get("dateTime")!=""){
            delivery.setDateTime(jsonObject.get("dateTime").toString());
        }


        return delivery;
    }


}
