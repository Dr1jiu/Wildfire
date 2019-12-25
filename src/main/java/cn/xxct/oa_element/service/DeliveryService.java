package cn.xxct.oa_element.service;

import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.service.BaseService;
import cn.xxct.oa_element.utils.ResultEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DeliveryService extends BaseService<Delivery>{
    ResultEntity zJian(Map map);
    List<Delivery> gitAll(Delivery entity);
    List<Map> getAllA(Delivery entity);
    Delivery finds(Serializable id);
}
