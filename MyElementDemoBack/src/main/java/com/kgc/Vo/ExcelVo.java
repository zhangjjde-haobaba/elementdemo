package com.kgc.Vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Created by jiang on 2/21/22 10:41 PM
 */
@Data
public class ExcelVo {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("性别")
    private String gender;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("班级")
    private String classes;
}
