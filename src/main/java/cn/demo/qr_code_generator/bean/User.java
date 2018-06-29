package cn.demo.qr_code_generator.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User
{
    @Id
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    private Set<QRCode> qrCodes;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set<QRCode> getQrCodes()
    {
        return qrCodes;
    }

    public void setQrCodes(Set<QRCode> qrCodes)
    {
        this.qrCodes = qrCodes;
    }
}
