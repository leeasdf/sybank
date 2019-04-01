**项目说明** 
- 采用 SpringBoot、MyBatis、Shiro框架。
- 采用 db2数据库
<br>

<br> 

**项目结构** 
```
enterprise-manage-spider
│ 
├─enterprise-manage-spider-admin 企业对公数据管理系统
│    ├─common  公共方法
│    │ 
│    ├─config  信息配置
│    │ 
│    ├─modules  模块
│    │    ├─spider 对公数据系统内核
│    │    ├─api API对外暴露接口
│    │    ├─sys 系统管理
│    │    └─job 定时任务
│    │ 
│    └─resources 
│        ├─dozer    dozer配置信息
│        ├─mapper   MyBatis文件
│        ├─statics  静态资源
│        ├─application*.yml   全局配置文件
│        └─logback-spring.xml   日志配置文件
│
├─project 项目文档
│    ├─ 01_需求分析
│    ├─ 02_数据处理
│    ├─ 03_接口对接
│    ├─ 04_项目文档
│    └─ 05_部署文档  
│        └─ `02_企业信息系统` --> 数据库脚本初始化
│           ├─01_建表  
│           └─02_导入数据

```

<br>

 **技术选型：** 
- 核心框架：Spring Boot 2.0.3
- 安全框架：Apache Shiro 1.3
- 视图框架：Spring MVC 4.3
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j

<br>

 **软件需求** 
- JDK1.8
- db2 9.0+
- Tomcat8.5+
- Maven3.0+

<br>
  **数据库表结构**
- 数据库文件 [01_sy_ent_manage_dfl.sql](http://172.19.160.82/hui.deng/enterprise-manage-sybank/blob/develop/project/05_%E9%83%A8%E7%BD%B2%E6%96%87%E6%A1%A3/02_%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF%E7%B3%BB%E7%BB%9F/%E4%B8%8A%E7%BA%BF/%E6%95%B0%E6%8D%AE%E5%BA%93%E8%84%9A%E6%9C%AC/01_%E5%BB%BA%E8%A1%A8/01_sy_ent_manage_dfl.sql)

<br>

 **本地部署**
- 通过git下载源码
- 创建数据库SYBANK_ENT_MANAGE，数据库编码为UTF-8
- 执行`数据库脚本初始化目录下`文件，初始化数据【按需导入表结构及数据】
- 修改application-dev.yml文件，更新db2账号和密码
- 在enterprise-manage-spider目录下，执行mvn clean install
<br>

- Eclipse、IDEA运行AdminApplication.java，则可启动项目【sybank_ent_manage】
- enterprise-manage-spider访问路径：http://localhost:9080/sybank_ent_manage
- swagger文档路径：http://localhost:9080/sybank_ent_manage/swagger-ui.html#

<br>

- 服务器部署配置信息，详见：[配置清单](http://172.19.160.82/hui.deng/enterprise-manage-sybank/wikis/configlist_%E9%85%8D%E7%BD%AE%E6%B8%85%E5%8D%95)
- 功能列表，详见：[功能清单](http://172.19.160.82/hui.deng/enterprise-manage-sybank/wikis/tasklist_%E4%BB%BB%E5%8A%A1%E6%B8%85%E5%8D%95)
- 具体文档，详见：project目录下文档信息

<br>

