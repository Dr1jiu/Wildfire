package cn.xxct.oa_element.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dynamic_Message implements Serializable, AuthCachePrincipal {

    private static final long serialVersionUID = -6419060508818991678L;

    private Integer dm_UID;
    private String dm_Invoice;
    private String dm_Products;
    private String dm_user_Id;
    private String dm_Name;
    private String cg_UID;
    private String dm_state;
    private String dm_dateTime;

    @Override
    public String getAuthCacheKey() {
        return null;
    }


//    dm_UID int  主键自增
//    开票信息		dm_Invoice
//    可提供产品	dm_Products
//    登记人		dm_user_Id
//    登记时间
//    采购人		dm_Name
//    采购编号		cg_UID
}
