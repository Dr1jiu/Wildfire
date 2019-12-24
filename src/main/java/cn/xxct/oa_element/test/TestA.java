package cn.xxct.oa_element.test;

import cn.xxct.oa_element.mapper.DynamicMessageMapper;
import cn.xxct.oa_element.service.DynamicMessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @create 2019-12-19 16:55
 */

public class TestA {

    @Autowired
    private DynamicMessageService dynamicMessageService;

    private DynamicMessageMapper dynamicMessageMapper;

    public void text(){
        if (dynamicMessageService!=null){
            System.out.println(dynamicMessageService);
        }else {
            System.out.println("dynamicMessageService是空的");
            System.out.println(dynamicMessageService);
        }
        if (dynamicMessageMapper!=null){
            System.out.println(dynamicMessageMapper);

        }else {
            System.out.println("dynamicMessageMapper是空的");
            System.out.println(dynamicMessageService);
        }
    }
}
