package cn.xxct.oa_element.service;

import cn.xxct.oa_element.utils.ResultEntity;

import java.io.Serializable;

public interface BaseService<T> {

    //分页
    ResultEntity findPage(Integer currentPage, Integer pageRows, T param);

    //保存
    ResultEntity save(T entity);

    //删除
    ResultEntity delete(T entity);

    //更新
    ResultEntity update(T entity);

    //查询单个
    ResultEntity find(Serializable id);

    //查询全部
    ResultEntity findAll(T entity);

    //删除多个
    ResultEntity deleteMany(Long[] ids);
    //按多个id查询多个对象..
    //List<T> getByIds(Long[] ids);
}
