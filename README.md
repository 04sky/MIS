# MIS 使用javaweb+MVC实现人员的增删改查操作
### windows
1 数据库：新建一个mysql数据库，数据库名为 citel_4 ，执行database.sql文件

2 导入项目：打开eclipse，File -> Import -> General -> Existing Projects into Workspace -> Browse -> 选择InformationManageProject -> 选择文件夹 -> Finish
NB. 注意修改数据库连接配置信息：db-config.properties

3.1 绑定Tomcat：Window -> Preference -> Server -> Runtime Environments -> Add -> 选择Apache Tomcat v9.0 -> Apply and Close

3.2 打开Servers窗口：Window -> Show View -> Servers

3.3 在Servers窗口中：右键 -> Add and Remove -> 选择选择InformationManageProject -> Add -> Finish

4 启动项目：在Servers窗口中选中Tomcat v9.0 -> 点击右边绿色按钮 （之后可在控制台看见启动信息）

5 在浏览器访问项目：eg: http://localhost:8080/InformationManageProject/
