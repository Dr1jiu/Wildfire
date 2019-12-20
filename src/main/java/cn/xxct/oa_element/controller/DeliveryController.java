package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.service.DeliveryService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2019-12-19 16:47
 */
@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;


    @RequestMapping("/deliveryadd")
    public ResultEntity insert(@RequestParam(value = "delivery") Delivery delivery){
        return deliveryService.save(delivery);
    }

    @RequestMapping("/deliverydelete")
    public ResultEntity delete(@RequestParam(value = "delivery") Delivery delivery){
        return deliveryService.delete(delivery);
    }


    @RequestMapping("/deliveryupdate")
    public ResultEntity update(@RequestParam(value = "delivery") Delivery delivery){
        return deliveryService.update(delivery);
    }


    @RequestMapping("/deliveryfindAll")
    public ResultEntity findAll(@RequestParam(value = "delivery") Delivery delivery){
        return deliveryService.findAll(delivery);
    }


    @RequestMapping("/deliverypage")
    public ResultEntity findPage(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "PageRows",defaultValue = "6") Integer PageRows,Delivery delivery){
        return deliveryService.findPage(currentPage,PageRows,delivery);
    }
}
