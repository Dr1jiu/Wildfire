package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

/**
 * @create 2019-12-21 22:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Waybill  implements Serializable, AuthCachePrincipal {

    private String waybill_no;
    private Long number;
    private String s_name;
    private String s_phone;
    private String s_address;
    private String r_name;
    private String r_phone;
    private String r_address;
    private Date time;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
