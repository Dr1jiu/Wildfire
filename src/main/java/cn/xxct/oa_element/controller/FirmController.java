package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Firm;
import cn.xxct.oa_element.service.FirmService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2019-12-21 19:18
 */
@RestController
@RequestMapping("/firm")
public class FirmController {

    @Autowired
    private FirmService firmService;


    @RequestMapping("/select")
    public ResultEntity findAll(Firm firm){
        return firmService.findAll(firm);
    }
}
