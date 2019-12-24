package cn.xxct.oa_element.mapper;


import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.utils.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ArchivesMapper extends BaseMapper<Archives> {

    List<Map> getAll(Archives archives);
}
