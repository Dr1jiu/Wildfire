package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Dynamic_Message;
import cn.xxct.oa_element.service.DynamicMessageService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2019-12-19 15:41
 */
@RestController
public class DynamicMessageController {

    @Autowired
    private DynamicMessageService dynamicMessageService;


    @RequestMapping("/dynamicadd")
    public ResultEntity insert(@RequestParam(value = "dynamic_message") Dynamic_Message dynamic_message){
        return dynamicMessageService.save(dynamic_message);
    }

    @RequestMapping("/dynamicdelete")
    public ResultEntity delete(@RequestParam(value = "dynamic_message") Dynamic_Message dynamic_message){
        return dynamicMessageService.delete(dynamic_message);
    }

    @RequestMapping("/dynamicupdate")
    public ResultEntity update(@RequestParam(value = "dynamic_message") Dynamic_Message dynamic_message){
        return dynamicMessageService.update(dynamic_message);
    }


    @RequestMapping("/dynamicfindAll")
    public ResultEntity findAll(@RequestParam(value = "dynamic_message") Dynamic_Message dynamic_message){
        return dynamicMessageService.findAll(dynamic_message);
    }

    @RequestMapping("/dynamicpage")
    public ResultEntity findPage(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "PageRows",defaultValue = "6") Integer PageRows,Dynamic_Message dynamic_message){
        return dynamicMessageService.findPage(currentPage,PageRows,dynamic_message);
    }
}
