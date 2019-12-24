package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Dispatch;
import cn.xxct.oa_element.mapper.DispatchMapper;
import cn.xxct.oa_element.service.DispatchService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchMapper dispatchMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Dispatch param) {
        return PageUtils.findPage(currentPage, pageRows, dispatchMapper, param);
    }

    @Override
    public ResultEntity save(Dispatch entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(dispatchMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Dispatch dispatch) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(dispatchMapper, dispatch.getDepartNo());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Dispatch entity) {
        ResultEntity result=Success.updateAllsuccess(dispatchMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(dispatchMapper,id);
    }

    @Override
    public ResultEntity findAll(Dispatch entity) {
        return Success.findAllSuccess(dispatchMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(dispatchMapper, ids);
        return resultEntity;
    }
}
