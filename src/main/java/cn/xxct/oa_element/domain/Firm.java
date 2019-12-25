package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

/**
 * @create 2019-12-21 19:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Firm implements Serializable, AuthCachePrincipal {

    private Integer firmNo;
    private String firmName;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
