package cn.xxct.oa_element.domain;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

@Data
public class Archives implements  Serializable, AuthCachePrincipal {

    private static final long serialVersionUID = 8170659221922885950L;
//档案登记
    private String a_UID;
    private String unit_Name;
    private String a_Address;
    private String a_Phone;
    private String cp_UID;
    private String delivery_Name;
    private String a_Sex;
    private String a_Emil;
    private String dm_UID;


    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
//    档案id	a_UID
//    单位名称	unit_Name
//    配送地址	a_Address
//    电话	a_Phone
//	产品类型、副id cp_UID
//            配送目标人名称delivery_Name
//            性别	a_Sex
//            邮箱	a_Emil
//            dm_UID 消息表副id	dm_UID