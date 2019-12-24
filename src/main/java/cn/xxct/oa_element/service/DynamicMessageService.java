package cn.xxct.oa_element.service;

import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.service.BaseService;
import org.apache.ibatis.annotations.Mapper;


public interface DynamicMessageService extends BaseService<Dynamic_Message>{
    Integer addDm(Dynamic_Message entity);
}
