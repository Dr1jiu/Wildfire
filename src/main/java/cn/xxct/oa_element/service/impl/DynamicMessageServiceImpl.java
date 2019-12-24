package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.mapper.DynamicMessageMapper;
import cn.xxct.oa_element.service.DynamicMessageService;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@Service("dynamicMessageService")
public class DynamicMessageServiceImpl implements DynamicMessageService {

    @Autowired
    private DynamicMessageMapper dynamicMessageMapper;

//    @PostConstruct
//    public void init() {
//        dynamic_messageService = this;
//        dynamic_messageService.dynamic_MessageMapper= this.dynamic_MessageMapper;
//    }

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Dynamic_Message param) {
        return PageUtils.findPage(currentPage, pageRows, dynamicMessageMapper, param);
    }

    @Override
    public ResultEntity save(Dynamic_Message entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(dynamicMessageMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Dynamic_Message dynamic_Message) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(dynamicMessageMapper, dynamic_Message.getDm_UID());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Dynamic_Message entity) {
        ResultEntity result=Success.updateAllsuccess(dynamicMessageMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(dynamicMessageMapper,id);
    }


    @Override
    public ResultEntity findAll(Dynamic_Message entity) {
        return Success.findAllSuccess(dynamicMessageMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(dynamicMessageMapper, ids);
        return resultEntity;
    }

    @Override
    public Integer addDm(Dynamic_Message entity) {
        return dynamicMessageMapper.addDm(entity);
    }
}
