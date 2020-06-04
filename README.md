# springBoot-2.0+mybatis+mysql+jta 分布式事物



## 二段提交概念

​	XA 方案：即“全票通过方案”，要求所有的事务系统必须全部准备好，才可以进行事务处理，这种方案其实是将事务问题抛给了各个数据库本身，好处是数据一致性很高，缺点是耗费性能，所以这种方案一般用的不多。

​	所谓的 XA 方案，即：两阶段提交，有一个事务管理器的概念，负责协调多个数据库（资源管理器）的事务，事务管理器先问问各个数据库你准备好了吗？如果每个数据库都回复OK，那么就正式提交事务，在各个数据库上执行操作；如果任何其中一个数据库回答不OK，那么就回滚事务。

这种分布式事务方案，比较适合单块应用里，跨多个库的分布式事务，而且因为严重依赖于数据库层面来搞定复杂的事务，效率很低，绝对不适合高并发的场景。如果要玩儿，那么基于 Spring + JTA 就可以搞定。

这个方案，我们很少用，一般来说某个系统内部如果出现跨多个库的这么一个操作，是不合规的。现在微服务，一个大的系统可能分成几十甚至几百个服务，一般来说，我们的规定和规范，是要求每个服务只能操作自己对应的一个数据库。

如果要操作别的服务对应的库，不允许直连别的服务的库，违反微服务架构的规范，随便交叉胡乱访问，几百个服务的话，全体乱套，这样的一套服务是没法管理的，没法治理的，可能会出现数据被别人改错，自己的库被别人写挂等情况。

如果要操作别人的服务的库，最好是通过调用别的服务的接口来实现，绝对不允许交叉访问别人的数据库。



## 分段提交机制

![img](https://img-blog.csdnimg.cn/20190123180448834.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3p6aHVhbl8x,size_16,color_FFFFFF,t_70)

![img](https://img-blog.csdnimg.cn/20190123180502588.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3p6aHVhbl8x,size_16,color_FFFFFF,t_70)

- XA中大致分为两部分：
  - 事务管理器：作为全局的调度者，负责各个本地资源的提交和回滚
  - 本地资源管理器：往往由数据库实现
- XA机制将提交过程两个阶段
  - prepare
  - commit

## 流程

1. 事务管理模块在prepare服务A的DB事务、服务B的DB事务都成功后。
2. 逐个commit这些DB事务。

DB在prepare返回OK后，如果没有收到来自事务管理模块的commit/rollback请求则会一直保留该分支事务的数据。

出现错误的情况：

若在prepare阶段出现故障，则回滚prepare过的分支事务，从而达到全局事务回滚。
若在commit阶段出现故障，后续仍然可以再次commit那些未成功commit的分支事务，最终达到全局事务提交。



## 优缺点

- 优点：实现简单易懂
- 缺点：性能不理想，高并发场景下表现不佳





## demo版本

我测试使用的版本。其他可参考pom文件。

- spring boot  2.0.3.RELEASE
- mybatis 2.0.0
- mysql 5.7.20







## 1. demo 工程 注意项

- 注意 数据库的创建 
- 注意 application.properties的配置 数据库路径以及用户名密码







## 2. 启动测试程序



找到类：com.example.DemoSpringootJtaApplicationTests  ，执行单元测试。






