## Web应用架构设计
**应用框架使用分层框架**  


![应用框架图](https://raw.githubusercontent.com/bisheng6/web/40b303e543cc2ba8a1f40350c4a95f268b392c8f/web%E5%BA%94%E7%94%A8%E6%9E%B6%E6%9E%84.jpg)

MVC模型：

![MVC](https://github.com/bisheng6/web/blob/master/MVC.png?raw=true)



Domian Object（领域对象）层：此层由一系列普通、传统的Java对象组成，每个对象包含各自业务逻辑方法。

DAO层：实现与数据库的创建、查询、更新、和删除等原子操作

Service层：此层由一系列的业务逻辑对象组成，实现系统实现系统所需要的业务逻辑方法。

Controller层：用于拦截用户请求，并调用业务逻辑组件的业务逻辑方法，处理用户请求，并根据处理结果向不同的表现层组件转发。

View层：收集用户请求，并显示处理结果。

Database层：实现数据的持久化


各组件之间一个松耦合的方式耦合在一起

