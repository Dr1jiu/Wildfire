package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Depart;
import cn.xxct.oa_element.mapper.DepartMapper;
import cn.xxct.oa_element.service.DepartService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Depart param) {
        return PageUtils.findPage(currentPage, pageRows, departMapper, param);
    }

    @Override
    public ResultEntity save(Depart entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(departMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Depart depart) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(departMapper, depart.getStaffNo());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Depart entity) {
        ResultEntity result=Success.updateAllsuccess(departMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(departMapper,id);
    }

    @Override
    public ResultEntity findAll(Depart entity) {
        return Success.findAllSuccess(departMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(departMapper, ids);
        return resultEntity;
    }
}
