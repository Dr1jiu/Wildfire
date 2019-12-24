package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Firm;
import cn.xxct.oa_element.mapper.FirmMapper;
import cn.xxct.oa_element.service.FirmService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    private FirmMapper firmMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Firm param) {
        return PageUtils.findPage(currentPage, pageRows, firmMapper, param);
    }

    @Override
    public ResultEntity save(Firm entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(firmMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Firm firm) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(firmMapper, firm.getFirmNo());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Firm entity) {
        ResultEntity result=Success.updateAllsuccess(firmMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(firmMapper,id);
    }

    @Override
    public ResultEntity findAll(Firm entity) {
        return Success.findAllSuccess(firmMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(firmMapper, ids);
        return resultEntity;
    }
}
