package cn.xxct.oa_element.controller;

import cn.xxct.oa_element.domain.Archives;
import cn.xxct.oa_element.service.ArchivesService;
import cn.xxct.oa_element.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;

/**
 * @create 2019-12-19 16:22
 */
@RequestMapping("/archives")
@RestController
public class ArchivesController {

    @Autowired
    private ArchivesService archivesService;


    @RequestMapping("/archivesadd")
    public ResultEntity insert(@RequestParam(value = "archives") Archives archives){
        return archivesService.save(archives);
    }

    @RequestMapping("/archivesdelete")
    public ResultEntity delete(@RequestParam(value = "archives") Archives archives){
        return archivesService.delete(archives);
    }


    @RequestMapping("/archivesupdate")
    public ResultEntity update(@RequestParam(value = "archives") Archives archives){
        return archivesService.update(archives);
    }

    @RequestMapping("/archivesfindAll")
    public ResultEntity findAll(@RequestParam(value = "archives") Archives archives){
        return archivesService.findAll(archives);
    }


    @RequestMapping("/archivespage")
    public ResultEntity findPage(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(value = "PageRows",defaultValue = "6") Integer PageRows,Archives archives){
        return archivesService.findPage(currentPage,PageRows,archives);
    }
}
