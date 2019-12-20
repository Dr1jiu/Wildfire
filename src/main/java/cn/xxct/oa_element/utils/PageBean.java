package cn.xxct.oa_element.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {

    //分页列表数据
    private List<T> list;
    //总记录数
    private Integer totalCount;
    //当前页
    private Integer currentPage;
    //每页显示条数
    private Integer rowsPage;
    //总页数
    private Integer PageCount;
}
