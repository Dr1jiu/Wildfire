package cn.xxct.oa_element.mapper;


import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DynamicMessageMapper extends BaseMapper<Dynamic_Message> {

    Integer addDm(Dynamic_Message entity);
}
