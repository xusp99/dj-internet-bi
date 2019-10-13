package com.djbx.bi.internet.domain;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/25 0025.
 * 区域--------实体类
 *
 * @Entity :告诉 JPA 本类是一个与数据库表进行映射的实体类，而不是普通的 Java Bean
 * @Table ：指定本映射实体类与数据库哪个表进行映射，不写时默认为类名首字母小写（area）
 */

@Entity
@Table(name = "area")
public class Area {

    /**
     * @Id : 指定此字段为数据库主键
     * @GeneratedValue :指定主键生成的策略(strategy)，可以选择如下：
     * TABLE,
     * SEQUENCE：由 DB2、Oracle、SAP DB 等数据库 使用自己的 序列 进行管理生成
     * IDENTITY：由数据库自己进行管理，如 Mysql 的 自动递增
     * AUTO：让ORM框架自动选择，默认值
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * @Column :指定此属性映射数据库表的哪个字段，不写时默认为属性名
     * length ：指定此字段的长度，只对字符串有效，不写时默认为255
     * unique ：是否添加唯一约束，不写时默认为 false
     * 更多详细属性，可以进入 javax.persistence.Column 查看
     */
    @Column(name = "name", length = 32, unique = true)
    private String name;

    /**
     * nullable ：表示此字段是否允许为null
     */
    @Column(nullable = false)
    private String clients;
    private Date createTime;

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "clients='" + clients + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
