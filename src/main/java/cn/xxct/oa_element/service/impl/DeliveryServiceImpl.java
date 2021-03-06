package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.mapper.DeliveryMapper;
import cn.xxct.oa_element.service.DeliveryService;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Delivery param) {
        return PageUtils.findPage(currentPage, pageRows, deliveryMapper, param);
    }

    @Override
    public ResultEntity save(Delivery entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(deliveryMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Delivery delivery) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(deliveryMapper, delivery.getA_UID());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Delivery entity) {
        ResultEntity result=Success.updateAllsuccess(deliveryMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(deliveryMapper,id);
    }

    @Override
    public ResultEntity findAll(Delivery entity) {
        return Success.findAllSuccess(deliveryMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(deliveryMapper, ids);
        return resultEntity;
    }

    @Override
    public ResultEntity zJian(Map map) {

        return ResultEntity.successWithData(deliveryMapper.zJian(map));
    }

    @Override
    public List<Delivery> gitAll(Delivery entity) {
        return deliveryMapper.gitAll(entity);
    }
    public List<Map> getAllA(Delivery entity){
        return deliveryMapper.getAllA(entity);
    }

    @Override
    public Delivery finds(Serializable id) {
        return deliveryMapper.find(id);
    }
}
