package com.diodi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diodi.mapper.UserMapper;
import com.diodi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author diodi
 * @create 2021-05-05-21:07
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        mapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void test2(){
        //查询名字haha
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "张三3");
        System.out.println(mapper.selectOne(wrapper));
    }
    @Test
    void test3(){
        // 查询年龄在 20 ~ 30 岁之间的用户 使用between and
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 12, 18);
        //返回个数
        System.out.println(mapper.selectCount(wrapper));
    }
    //模糊查询
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "三")
                .likeLeft("email", "baomidou.com") //% val val结尾
                .likeRight("email", "test5"); //val开头
        List<Map<String, Object>> maps = mapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
    //模糊查询
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id 在子查询中查出
        wrapper.inSql("id", "select id from user where id <4");
        //查询的是个对象
        List<Object> objects = mapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }
    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行排序 降序
        wrapper.orderByDesc("id");
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
