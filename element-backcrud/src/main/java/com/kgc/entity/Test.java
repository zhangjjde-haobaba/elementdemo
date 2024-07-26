package com.kgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author Jiang Yiwei
 * @since 2022-02-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Test implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 书本编号
     */
        @TableId(value = "bookid", type = IdType.AUTO)
      private Integer bookid;

      /**
     * 书本名称
     */
      private String name;

      /**
     * 书本价格
     */
      private Double price;


}
