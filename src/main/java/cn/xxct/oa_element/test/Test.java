package cn.xxct.oa_element.test;

import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @create 2019-12-19 16:55
 */
public class Test {

    @Autowired
    private DeliveryService deliveryService;

    @org.junit.Test
    public void text(){

        Delivery delivery = new Delivery();
        delivery.setD_UID("1");
        deliveryService.delete(delivery);
    }
}
