package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Dispatch;
import cn.xxct.oa_element.service.DispatchService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2019-12-21 19:19
 */
@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;


    @RequestMapping("/select")
    public ResultEntity findAll(Dispatch dispatch){
        return dispatchService.findAll(dispatch);
    }
}
