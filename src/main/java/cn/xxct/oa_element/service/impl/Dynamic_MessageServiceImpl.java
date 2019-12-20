package cn.xxct.oa_element.service.impl;

import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.mapper.Dynamic_MessageMapper;
import cn.xxct.oa_element.service.Dynamic_MessageService;
import cn.xxct.oa_element.utils.PageBean;
import cn.xxct.oa_element.utils.PageUtils;
import cn.xxct.oa_element.utils.ResultEntity;
import cn.xxct.oa_element.utils.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class Dynamic_MessageServiceImpl implements Dynamic_MessageService {

    @Autowired
    private Dynamic_MessageMapper dynamic_MessageMapper;

    @Override
    public ResultEntity findPage(Integer currentPage, Integer pageRows, Dynamic_Message param) {
        return PageUtils.findPage(currentPage, pageRows, dynamic_MessageMapper, param);
    }

    @Override
    public ResultEntity save(Dynamic_Message entity) {
        ResultEntity resultEntity=Success.saveAllsuccess(dynamic_MessageMapper,entity);
        return resultEntity;
    }

    @Override
    public ResultEntity delete(Dynamic_Message dynamic_Message) {
        ResultEntity resultEntity = Success.deleteSingeSuccess(dynamic_MessageMapper, dynamic_Message.getDm_UID());
        return resultEntity;
    }

    @Override
    public ResultEntity update(Dynamic_Message entity) {
        ResultEntity result=Success.updateAllsuccess(dynamic_MessageMapper, entity);
        return result;
    }

    @Override
    public ResultEntity find(Serializable id) {
        return Success.findSingle(dynamic_MessageMapper,id);
    }

    @Override
    public ResultEntity findAll(Dynamic_Message entity) {
        return Success.findAllSuccess(dynamic_MessageMapper,entity);
    }

    @Override
    public ResultEntity deleteMany(Long[] ids) {
        ResultEntity resultEntity = Success.deleteAllsuccess(dynamic_MessageMapper, ids);
        return resultEntity;
    }
}
