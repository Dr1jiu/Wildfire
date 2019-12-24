package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.mapper.DynamicMessageMapper;
import cn.xxct.oa_element.service.ArchivesService;
import cn.xxct.oa_element.service.DeliveryService;
import cn.xxct.oa_element.service.DynamicMessageService;
import cn.xxct.oa_element.service.impl.DynamicMessageServiceImpl;
import cn.xxct.oa_element.utils.MYUtil;
import cn.xxct.oa_element.utils.ResultEntity;
import org.activiti.engine.impl.util.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class wildfireController {
    @Autowired
    private DeliveryService deliveryService;
    @Resource
    DynamicMessageService dynamicMessageService;
    @Autowired
    private ArchivesService archivesService;




    @RequestMapping("/addArchives")
    public ResultEntity a(@RequestBody JSONObject jsonObject){
        Archives ar = new Archives();
        ar = MYUtil.jz(jsonObject);
        Dynamic_Message am = new Dynamic_Message();
        am = MYUtil.dnj(jsonObject);
        am.setDm_state("0");
        am.setDm_dateTime(MYUtil.getDateTime());
        dynamicMessageService.addDm(am);
        ar.setA_UID(MYUtil.getUUID());
        ar.setDm_UID(am.getCg_UID());
        ar.setState("0");
        ar.setDateTime(MYUtil.getDateTime());
        return archivesService.save(ar);
    }

    @RequestMapping("/setState")
    public ResultEntity xg(@RequestParam String state,@RequestParam String A_UID){
        Archives ar = new Archives();
        ar.setState(state);
        ar.setA_UID(A_UID);
        return archivesService.update(ar);
    }
    @RequestMapping("/deleteA")
    public ResultEntity shanchu(@RequestParam String state,@RequestParam String A_UID){
        Archives ar = new Archives();
        ar.setA_UID(A_UID);
        return archivesService.delete(ar);
    }
    @RequestMapping("/getAllA")
    public Map getAll(){
        Archives ar = new Archives();
//        ar.setA_UID(A_UID);
        Map map = new HashMap();
        map.put("data",archivesService.getAll(ar));
        return map;
    }

}
