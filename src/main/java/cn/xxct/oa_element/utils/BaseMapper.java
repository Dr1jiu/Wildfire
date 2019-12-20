package cn.xxct.oa_element.utils;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {

    //单表分页通用方法
    List<T> findPageList(@Param("currentPage") Integer currentPage, @Param("pageRows") Integer pageRows, @Param("param") T param);

    //查询单表行数通用方法
    Integer getTotalCount(T param);

    //删除单表通用方法
    Integer delete(Serializable id);

    //按照id查询
    T find(Serializable deptid);

    //通用保存方法
    Integer save(T entity);

    //通用更新方法
    Integer update(T entity);

    //查询全部不带条件
    List<T> findAll(T entity);

    //删除多个
    Integer deleteMany(Serializable[] ids);
}
