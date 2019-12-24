package cn.xxct.oa_element.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2019-12-24 9:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productt {

    private String id;
    private String supplierId;
    private String productname;
    private String warranty;
    private String proid;
    private String cpdw;
    private String scdj;
    private String remark;
    private String manufacturer;

}
