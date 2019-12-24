package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Depart;
import cn.xxct.oa_element.domain.Productt;
import cn.xxct.oa_element.service.ProducttService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2019-12-24 9:36
 */
@RestController
@RequestMapping("/productt")
public class ProducttController {

    @Autowired
    private ProducttService producttService;


    @RequestMapping("/findAll")
    public Map<String,Object> findAll(Productt productt){
        ResultEntity entity = producttService.findAll(productt);
        List<Productt> data = (List<Productt>) entity.getData();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",entity);
        map.put("data",data);
        return map;
    }

    @RequestMapping("/update")
    public ResultEntity update(Productt productt){
        return producttService.update(productt);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultEntity delete(Productt productt){
        return producttService.delete(productt);
    }

    @RequestMapping("/add")
    public ResultEntity insert(Productt productt){
        return producttService.save(productt);
    }
}
