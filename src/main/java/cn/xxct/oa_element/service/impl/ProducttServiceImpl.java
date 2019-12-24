package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Productt;
import cn.xxct.oa_element.mapper.ProducttMapper;
import cn.xxct.oa_element.service.ProducttService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ProducttServiceImpl implements ProducttService {

    @Autowired
    private ProducttMapper producttMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Productt param) {
        return PageUtils.findPage(currentPage, pageRows, producttMapper, param);
    }

    @Override
    public ResultEntity save(Productt entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(producttMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Productt productt) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(producttMapper, productt.getId());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Productt entity) {
        ResultEntity result=Success.updateAllsuccess(producttMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(producttMapper,id);
    }

    @Override
    public ResultEntity findAll(Productt entity) {
        return Success.findAllSuccess(producttMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(producttMapper, ids);
        return resultEntity;
    }
}
