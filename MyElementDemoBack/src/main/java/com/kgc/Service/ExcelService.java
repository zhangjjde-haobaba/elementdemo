package com.kgc.Service;

import com.kgc.Vo.ExcelVo;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jiang on 2/21/22 10:46 PM
 */
public interface ExcelService {
    public List<ExcelVo> list(InputStream inputStream);
}
