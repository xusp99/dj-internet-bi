package com.djbx.bi.internet.dao;

import com.djbx.bi.internet.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/25 0025.
 * 自定义接口继承 JpaRepository<T, ID> 即可
 * T ：泛型，传入操作的实体类即可
 * TD：传入实体类主键的类型
 * 如果是以前 Hibernate 则还需要在 Dao 层的实现类上加 @Repository 注解注入每一个 Dao实现组件
 * 而 Spring Data JPA 的数据库访问层就已经完成了，继承了JpaRepository接口，就拥有了所有的 CRUD方法、排序、分页方法
 * 继承 JpaRepository 之后，本接口就已经是 JPA 的 @Repository 了，所以不要再加，直接在 service层或者controller层注入即可
 */
public interface AreaDao extends JpaRepository<Area, Integer> {
}
