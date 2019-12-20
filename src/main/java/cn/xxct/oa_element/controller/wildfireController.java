package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.service.ArchivesService;
import cn.xxct.oa_element.service.DeliveryService;
import cn.xxct.oa_element.service.Dynamic_MessageService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class wildfireController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private Dynamic_MessageService dynamic_messageService;
    @Autowired
    private ArchivesService archivesService;




    @RequestMapping("/add")
    public ResultEntity a(@RequestBody JSONObject jsonObject){
        
        return null;
    }

}
