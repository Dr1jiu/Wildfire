package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.mapper.ArchivesMapper;
import cn.xxct.oa_element.service.ArchivesService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ArchivesServiceImpl implements ArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Archives param) {
        return PageUtils.findPage(currentPage, pageRows, archivesMapper, param);
    }

    @Override
    public ResultEntity save(Archives entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(archivesMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Archives archives) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(archivesMapper, archives.getA_UID());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Archives entity) {
        ResultEntity result=Success.updateAllsuccess(archivesMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(archivesMapper,id);
    }

    @Override
    public ResultEntity findAll(Archives entity) {
        return Success.findAllSuccess(archivesMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(archivesMapper, ids);
        return resultEntity;
    }
}
