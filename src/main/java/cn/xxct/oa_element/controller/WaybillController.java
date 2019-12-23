package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Depart;
import cn.xxct.oa_element.domain.Waybill;
import cn.xxct.oa_element.service.WaybillService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2019-12-21 22:44
 */
@RequestMapping("/waybill")
@RestController
public class WaybillController {


    @Autowired
    private WaybillService waybillService;
    @RequestMapping(value = "/waybilljson")
    @ResponseBody
    public ResultEntity findAll(Waybill waybill){
        ResultEntity list = waybillService.findAll(waybill);
        // List<Waybill> data = (List<Waybill>) list.getData();
        // System.out.println("==============================="+data);
        System.out.println("==============================="+waybill.getWaybill_no());
        //
        // Map<String, Object> map = new HashMap<>();
        // map.put("code", 0);
        // map.put("msg", "");
        // // map.put("count",list);
        // map.put("data",data);
        return list;
    }

    @RequestMapping("/waybillupdate")
    public ResultEntity update(Waybill waybill){
        return waybillService.update(waybill);
    }

    @RequestMapping("/find")
    public ResultEntity find(String waybill_no){
        ResultEntity entity = waybillService.find(waybill_no);
        System.out.println("======================"+entity);
        return entity;
    }
}
