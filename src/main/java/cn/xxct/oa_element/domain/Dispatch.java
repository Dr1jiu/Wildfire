package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

/**
 * @create 2019-12-21 19:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispatch implements Serializable, AuthCachePrincipal {

    private Integer departNo;
    private String departName;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
