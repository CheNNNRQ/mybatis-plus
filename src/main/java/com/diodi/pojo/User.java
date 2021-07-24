package com.diodi.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author diodi
 * @create 2021-05-03-20:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @TableId(type = IdType.AUTO)
    private Long id ;
    private String name;
    private Integer age;
    private String email;
    @Version //乐观锁Version注解
    private Integer version;
    @TableLogic //逻辑删除注解
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}




































