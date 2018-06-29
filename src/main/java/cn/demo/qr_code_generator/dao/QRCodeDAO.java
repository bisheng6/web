package cn.demo.qr_code_generator.dao;

import cn.demo.qr_code_generator.bean.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeDAO extends JpaRepository<QRCode, Integer>
{
}
