package com.kgc.controller;


import com.kgc.entity.Test;
import com.kgc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author Jiang Yiwei
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/book")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/list")
    public List<Test> list(){
        return this.testService.list();
    }

    @GetMapping("/findById/{id}")
    public Test findById(@PathVariable("id") Integer id){
        return this.testService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return this.testService.removeById(id);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Test test){
//      接受到一个完整的json对象 @RequestBody将json对象转成java对象
        return this.testService.save(test);
    }
    @PutMapping("/update")
    public boolean update(@RequestBody Test test){
        return this.testService.updateById(test);
    }

}

