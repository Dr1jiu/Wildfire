package cn.xxct.oa_element.domain;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

/**
 * @create 2019-12-19 15:49
 */
@Data
public class Delivery implements Serializable, AuthCachePrincipal {
    private static final long serialVersionUID = -1250109247978003898L;
    //配送
    private String d_UID;
    private String a_UID;
    private String d_Phone;
    private Date quasi_Date;
    private String user_UID;
    private String d_Remarks;
    private Character state;
    private Date dateTime;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
