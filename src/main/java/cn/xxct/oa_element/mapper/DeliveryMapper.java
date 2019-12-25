package cn.xxct.oa_element.mapper;


import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.utils.BaseMapper;

import java.util.List;
import java.util.Map;

public interface DeliveryMapper extends BaseMapper<Delivery> {

    Integer zJian(Map map);

    List<Delivery> gitAll(Delivery entity);

    List<Map> getAllA(Delivery entity);
}
