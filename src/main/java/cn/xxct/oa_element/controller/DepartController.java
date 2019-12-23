package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Depart;
import cn.xxct.oa_element.service.DepartService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2019-12-20 11:34
 */
@RequestMapping("/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;


    @RequestMapping(value = "/json")
    @ResponseBody
    public Map<String, Object> findAll(Depart depart){
        ResultEntity list = departService.findAll(depart);
       List<Depart> data = (List<Depart>) list.getData();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",list);
        map.put("data",data);
        System.out.println("map"+map);
        System.out.println("data"+data);
        return map;
    }

    @RequestMapping("/add")
    public ResultEntity insert(Depart depart){
        return departService.save(depart);
    }


    @RequestMapping("/update")
    public ResultEntity update(Depart depart){
        System.out.println(depart.getStaff_no());
        return departService.update(depart);
    }

    @RequestMapping("/delete")
    public ResultEntity delete(Depart depart){
        return departService.delete(depart);
    }


    @RequestMapping("/find")
    public ResultEntity find(Integer staff_no){
        return departService.find(staff_no);
    }
}
