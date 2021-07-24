package com.diodi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author diodi
 * @create 2021-05-05-22:17
 */
// 代码自动生成器
public class diodi {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略
        //1 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前系统目录
        String projectPath = System.getProperty("user.dir");
        //设置输出目录
        gc.setOutputDir(projectPath+"/src/main/java");
        //生成作者的信息
        gc.setAuthor("diodi");
        //是否打开win资源管理器
        gc.setOpen(false);
        //是否需要覆盖原来的文件
        gc.setFileOverride(false);
        //去service的I前缀
        gc.setServiceName("%sService");
        //id 生成策略 默认
        gc.setIdType(IdType.ID_WORKER);
        //设置日期类型 仅仅只是时间
        gc.setDateType(DateType.ONLY_DATE);
        //将全局配置放到代码生成器中
        mpg.setGlobalConfig(gc);
        // 2设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        //连接驱动名
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        //数据库的类型
        dsc.setDbType(DbType.MYSQL);
        // 3 包的配置
        PackageConfig pc = new PackageConfig();
        //模块名 生成 com.diodi.blog包
        pc.setModuleName("blog");
        //放在哪个包下
        pc.setParent("com.diodi");
        //实体类的类名
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        //代码生成器生成 pc中的包
        mpg.setPackageInfo(pc);
        //4 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //映射的数据库表名
        strategy.setInclude("user");
        //设置包的命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列的命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        //逻辑删除的名字
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置 填充数据库添加修改时间
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        //将自动填充的策略加到 tableFills中
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 设置乐观锁名
        strategy.setVersionFieldName("version");
        //开启驼峰命名
        strategy.setRestControllerStyle(true);
        //localhost:8080/hello_id_2 使网址名有下划线
        strategy.setControllerMappingHyphenStyle(true);
        //将策略放到代码生成器
        mpg.setStrategy(strategy);
        //执行代码生成器
        mpg.execute();

    }
}
