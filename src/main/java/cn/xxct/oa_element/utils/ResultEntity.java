package cn.xxct.oa_element.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity {
    private String result;
    private String message;
    private Object data;

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MSG = "NO_MSG";
    public static final String NO_DATA = "NO_DATA";


    //成功没有数据没有消息
    public static ResultEntity successNoData() {
        return new ResultEntity(SUCCESS, NO_MSG, NO_DATA);
    }

    //成功有数据没有消息
    public static ResultEntity successWithData(Object data) {
        return new ResultEntity(SUCCESS, NO_MSG, data);
    }

    //失败返回错误消息,没有数据
    public static ResultEntity failed(String message) {
        return new ResultEntity(FAILED, message, null);
    }

}
