package com.dyn.springbootdemo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "test", catalog = "")
public class TUserDO {
    private int pkUid;
    private String fName;
    private String fPassword;

    @Id()
    @Column(name = "pk_uid", nullable = false)
    public int getPkUid() {
        return pkUid;
    }
    

    public void setPkUid(int pkUid) {
        this.pkUid = pkUid;
    }

    @Basic
    @Column(name = "f_name", nullable = true, length = 255)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "f_password", nullable = true, length = 255)
    public String getfPassword() {
        return fPassword;
    }

    public void setfPassword(String fPassword) {
        this.fPassword = fPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUserDO tUserDO = (TUserDO) o;
        return pkUid == tUserDO.pkUid &&
                Objects.equals(fName, tUserDO.fName) &&
                Objects.equals(fPassword, tUserDO.fPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkUid, fName, fPassword);
    }
}
