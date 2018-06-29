package cn.demo.qr_code_generator.dao;

import cn.demo.qr_code_generator.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String>
{

}
