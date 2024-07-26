package com.kgc.Controller;

import com.kgc.Service.ExcelService;
import com.kgc.Vo.ExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by jiang on 2/21/22 10:58 PM
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @PostMapping("/import")
    public String importData(@RequestParam("file") MultipartFile file){
        try {
            List<ExcelVo> list = this.excelService.list(file.getInputStream());
            for(ExcelVo excelVo:list){
                System.out.println(excelVo);
            }
        } catch (IOException e) {
            return "false";
        }
        return "success";
    }
}
