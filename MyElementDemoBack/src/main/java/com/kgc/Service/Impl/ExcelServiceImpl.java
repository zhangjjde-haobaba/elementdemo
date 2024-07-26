package com.kgc.Service.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kgc.Service.ExcelService;
import com.kgc.Vo.ExcelVo;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2/21/22 10:49 PM
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<ExcelVo> list(InputStream inputStream) {
        List<ExcelVo> list = new ArrayList<>();
        EasyExcel.read(inputStream)
                .head(ExcelVo.class)
                .sheet()
                .registerReadListener(new AnalysisEventListener<ExcelVo>() {

                    @Override
                    public void invoke(ExcelVo excelVo, AnalysisContext analysisContext) {
//                        解析出来的每一个对象添加到列表中
                        list.add(excelVo);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        System.out.println("数据解析完成");
                    }
                }).doRead();
        return list;
    }
}
