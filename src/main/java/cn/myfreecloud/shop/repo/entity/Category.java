package cn.myfreecloud.shop.repo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "cid")
    @GeneratedValue(generator = "JDBC")
    private String cid;

    @Column(name = "cname")
    private String cname;

    private static final long serialVersionUID = 1L;

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}