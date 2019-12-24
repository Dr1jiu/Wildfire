package cn.xxct.oa_element.service;

import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.service.BaseService;

import java.util.List;
import java.util.Map;

public interface ArchivesService extends BaseService<Archives>{
    List<Map> getAll(Archives archives);
}
