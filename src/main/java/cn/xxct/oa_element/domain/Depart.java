package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart implements Serializable, AuthCachePrincipal {

    private Integer staffNo;

    private String staffName;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthhday;

    private String phone;

    private String password;

    private Integer dedpartNo;

    private Integer firmNo;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}