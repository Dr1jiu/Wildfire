package cn.xxct.oa_element.utils;

import java.lang.reflect.Method;
import java.util.List;

public class PageUtils {

    public static <T> ResultEntity findPage(Integer currentPage, Integer pageRows, BaseMapper mapper, T param) {
        PageBean<T> pageBean = null;
        try {
            Integer start = (currentPage - 1) * pageRows;
            List<T> list = mapper.findPageList(start, pageRows, param);
            pageBean = new PageBean<>();
            Integer totalCount = mapper.getTotalCount(param);
            pageBean.setTotalCount(totalCount);

            pageBean.setCurrentPage(currentPage);
            pageBean.setRowsPage(pageRows);
            pageBean.setList(list);

            Integer PageCount = (totalCount - 1) / pageRows + 1;
            pageBean.setPageCount(PageCount);

            return ResultEntity.successWithData(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public static <T> ResultEntity MyfindPage(Integer currentPage, Integer pageRows, Object mapper, T param, String PageMethods, String CountMethods) {

        try {
            Integer start = (currentPage - 1) * pageRows;
            Method method = mapper.getClass().getMethod(PageMethods, Integer.class, Integer.class, param.getClass());
            List<T> list = (List<T>) method.invoke(mapper, start, pageRows, param);
            PageBean<T> pageBean = new PageBean<>();
            Method countMethod = mapper.getClass().getMethod(CountMethods, param.getClass());
            Integer totalCount = (Integer) countMethod.invoke(mapper, param);
            pageBean.setTotalCount(totalCount);

            pageBean.setCurrentPage(currentPage);
            pageBean.setRowsPage(pageRows);
            pageBean.setList(list);

            Integer PageCount = (totalCount - 1) / pageRows + 1;
            pageBean.setPageCount(PageCount);

            return ResultEntity.successWithData(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }
}
