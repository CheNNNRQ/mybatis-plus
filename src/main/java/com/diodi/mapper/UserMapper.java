package com.diodi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diodi.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author diodi
 * @create 2021-05-03-20:56
 */
// 在对应的Mapper上面继承基本的类 BaseMapper
@Repository // 代表持久层
public interface UserMapper extends BaseMapper<User> {
// 所有的CRUD操作都已经编写完成了
// 你不需要像以前的配置一大堆文件了！
}
