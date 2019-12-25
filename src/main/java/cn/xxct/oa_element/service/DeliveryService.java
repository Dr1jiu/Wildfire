package cn.xxct.oa_element.service;

import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.service.BaseService;

import java.util.Map;

public interface DeliveryService extends BaseService<Delivery>{
    Integer zJian(Map map);
}
