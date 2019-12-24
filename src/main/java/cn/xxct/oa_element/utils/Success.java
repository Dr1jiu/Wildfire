package cn.xxct.oa_element.utils;


import java.io.Serializable;
import java.util.List;

public class Success {
    public static ResultEntity deleteAllsuccess(BaseMapper mapper, Serializable[] ids) {
        try {
            Integer num = mapper.deleteMany(ids);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed("统一删除失败" + e.getMessage());
        }
    }

    //统一的查询全部返回的方法
    public static <T> ResultEntity findAllSuccess(BaseMapper mapper, T entity) {
        try {
            List all = mapper.findAll(entity);
            return ResultEntity.successWithData(all);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public static ResultEntity deleteSingeSuccess(BaseMapper mapper, Serializable ids) {
        try {
            Integer num = mapper.delete(ids);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed("删除失败" + e.getMessage());
        }
    }

    public static <T> ResultEntity updateAllsuccess(BaseMapper mapper, T entity) {
        try {
            Integer num = mapper.update(entity);
            System.out.println(entity+"--------->");
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed("修改失败" + e.getMessage());
        }
    }

    public static <T> ResultEntity saveAllsuccess(BaseMapper mapper, T entity) {
        try {
            Integer num = mapper.save(entity);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed("添加失败" + e.getMessage());
        }
    }

    public static ResultEntity findSingle(BaseMapper deptMapper, Serializable id) {
        try {
            Object entity = deptMapper.find(id);
            return ResultEntity.successWithData(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
