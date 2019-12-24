package com.example;

import cn.xxct.oa_element.ErpfbApplication;
import cn.xxct.oa_element.mapper.DynamicMessageMapper;
import cn.xxct.oa_element.service.DynamicMessageService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ErpfbApplication.class)
public class Sm01ApplicationTests {

    @Autowired
    private DynamicMessageService dynamicMessageService;


    @Test
    public void AVS(){

    }
        @Test
        public void ACC(){
            if (dynamicMessageService!=null){
                System.out.println(dynamicMessageService);
            }else {
                System.out.println("dynamicMessageService是空的");
            }
//            if (!=null){
//                System.out.println(dynamicMessageMapper);
//
//            }else {
//                System.out.println("dynamicMessageMapper是空的");
//            }
        }

}
