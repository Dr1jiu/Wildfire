package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Waybill;
import cn.xxct.oa_element.mapper.WaybillMapper;
import cn.xxct.oa_element.service.WaybillService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class WaybillServiceImpl implements WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Waybill param) {
        return PageUtils.findPage(currentPage, pageRows, waybillMapper, param);
    }

    @Override
    public ResultEntity save(Waybill entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(waybillMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Waybill waybill) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(waybillMapper, waybill.getWaybill_no());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Waybill entity) {
        ResultEntity result=Success.updateAllsuccess(waybillMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(waybillMapper,id);
    }

    @Override
    public ResultEntity findAll(Waybill entity) {
        return Success.findAllSuccess(waybillMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(waybillMapper, ids);
        return resultEntity;
    }
}
