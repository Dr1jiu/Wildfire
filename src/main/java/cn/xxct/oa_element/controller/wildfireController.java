package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.domain.Delivery;
import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.mapper.DynamicMessageMapper;
import cn.xxct.oa_element.service.ArchivesService;
import cn.xxct.oa_element.service.DeliveryService;
import cn.xxct.oa_element.service.DynamicMessageService;
import cn.xxct.oa_element.service.impl.DynamicMessageServiceImpl;
import cn.xxct.oa_element.utils.MYUtil;
import cn.xxct.oa_element.utils.ResultEntity;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map getAll(@RequestParam String state){
        Archives ar = new Archives();
        ar.setState(state);
        Map map = new HashMap();
        map.put("data",archivesService.getAll(ar));
        return map;
    }
    @RequestMapping("/getAID")
    public ResultEntity getAID(@RequestParam String A_UID){
        return archivesService.find(A_UID);
    }

    @RequestMapping("/addPS")
    public ResultEntity addPeiSong(@RequestParam List list ,@RequestParam Delivery delivery){
        delivery.setD_UID(MYUtil.getUUID());
        String UID = MYUtil.getUUID();
        delivery.setLinshi_UID(UID);
        if (deliveryService.save(delivery).getResult()!=null){
            Map map = new HashMap();
            map.put("d_UID",delivery.getD_UID());
            map.put("zheko",UID);
            for (Object a: list
                 ) {
            map.put("s_UID",a);
            map.put("dateTime",MYUtil.getDateTime());
                System.out.println(deliveryService.zJian(map));
            }
            return ResultEntity.successWithData("ko");
        }
        return null;
    }

    @RequestMapping("/getPeiSong")
    public Map getPeiSong(@RequestParam Delivery delivery){
        Map map = new HashMap();
        map.put("delivery",deliveryService.gitAll(delivery));

//        if (deliveryService.save(delivery).getResult()!=null){
//            Map map = new HashMap();
//            map.put("d_UID",delivery.getD_UID());
//            map.put("zheko",delivery.getD_UID());
//            for (Object a: list
//            ) {
//                map.put("s_UID",a);
//                map.put("dateTime",MYUtil.getDateTime());
//                System.out.println(deliveryService.zJian(map));
//            }
//            return ResultEntity.successWithData("ko");
//        }
        return map;
    }
    @RequestMapping("/getXX")
    public Map getXiangXi(@RequestParam String UID){
        Map map = new HashMap();
        Delivery delivery = deliveryService.finds(UID);
        if (delivery == null){
            return null;
        }
        map.put("dly",delivery);
        List<Map> maps = deliveryService.getAllA(delivery);
        map.put("List",map);
//        if (deliveryService.save(delivery).getResult()!=null){
//            Map map = new HashMap();
//            map.put("d_UID",delivery.getD_UID());
//            map.put("zheko",delivery.getD_UID());
//            for (Object a: list
//            ) {
//                map.put("s_UID",a);
//                map.put("dateTime",MYUtil.getDateTime());
//                System.out.println(deliveryService.zJian(map));
//            }
//            return ResultEntity.successWithData("ko");
//        }
        return map;
    }

}
