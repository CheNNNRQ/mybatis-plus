package com.diodi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diodi.mapper.UserMapper;
import com.diodi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        List<User> users = mapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
//        User user = new User( 123123L,"张三" , 18 , "aaa@qq.com");
        User user = new User();
        user.setAge(14);
        user.setName("张三4");
        user.setEmail("saa2@qq.com");
        int insert = mapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(6L);
        user.setName("aa");
        // 注意：updateById 但是参数是一个 对象！
        int i = mapper.updateById(user);
        System.out.println(i);
    }
    //测试乐观锁插件成功
    @Test
    public void leTest(){
        User user = mapper.selectById(1L);
        user.setName("haha");
        mapper.updateById(user);
    }
    //测试乐观锁失败 多线程下
    @Test
    public void leTest1(){
        //线程1
        User user = mapper.selectById(2L);
        user.setName("haha3");
        //模拟另一个线程执行插队操作
        User user2 = mapper.selectById(2L);
        user2.setName("haha4");
        mapper.updateById(user2);
        mapper.updateById(user);
    }
    //测试查询操作
    @Test
    public void selectByidTest(){
        User user = mapper.selectById(1L);
        System.out.println(user);
    }
    //测试批量查询操作
    @Test
    public void selectBatchIdsTest(){
        List<User> users = mapper.selectBatchIds(Arrays.asList(1 , 2 , 3));
        users.forEach(System.out::println);
    }
    //map查询
    @Test
    public void selectByMapTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1L);
        map.put("name", "aa");
        map.put("id", 5L);
        List<User> users = mapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //测试分页查询
    @Test
    public void pageTest(){
        Page<User> userPage = new Page<>(1,5);
        mapper.selectPage(userPage, null);
        userPage.getRecords().forEach(System.out::println);
    }
    //测试单删除
    @Test
    public void deleteByIdTest(){
        mapper.deleteById(1L);
    }
    //测试多个删除
    @Test
    public void pagedeleteBatchTest(){
        mapper.deleteBatchIds(Arrays.asList(2,3));
    }
    //测试map删除
    @Test
    public void pageByMapTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 21);
        mapper.deleteByMap(map);
    }
}


