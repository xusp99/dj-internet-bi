package com.djbx.bi.internet.controller;

import com.djbx.bi.internet.dao.AreaDao;
import com.djbx.bi.internet.domain.Area;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/8/25 0025.
 * 区域---控制层
 */
@Controller
public class AreaController {

    @Resource
    private AreaDao areaDao;

    /**
     * 根据id 查询
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/seals/{id}")
    public Area findAreaById(@PathVariable("id") Integer id, HttpServletResponse response) {
        System.out.println("com.lct.www.controllr.AreaController.findAreaById:::" + id);
        /**
         * 推荐使用 findById 方式，而不是 getOne方法
         * isPresent 判断 Optional是否为空，即有没有值
         */
        Optional<Area> areaOptional = areaDao.findById(id);
        if (!areaOptional.isPresent()) {
            return null;
        } else {
            System.out.println("area2::" + areaOptional.get());
            /** 获取Area值*/
            return areaOptional.get();
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/seals")
    public List<Area> findAllAreas() {
        List<Area> areaList = areaDao.findAll();
        return areaList;
    }

    /**
     * 添加 区域
     * localhost:8080/seals/save?name=党建学习区&clients=1,2&createTime=2018/08/12
     * localhost:8080/seals/save?name=一学一做区&clients=4,5,6&createTime=2018/08/15
     *
     * @param area
     * @return 添加成功后重定向到查询所有
     */
    @GetMapping("seals/save")
    public String saveArea(Area area) {
        /**
         * save 方法：当实体的主键不存在时，则添加；实体的主键存在时，则更新
         */
        areaDao.save(area);
        return "redirect:/seals";
    }

    /**
     * 更新区域
     * localhost:8080/seals/save?id=2&name=一学一做区2&clients=4,5,6&createTime=2018/08/15
     *
     * @param area
     * @return
     */
    @GetMapping("/seals/update")
    public String updateArea(Area area) {
        /**
         * save 方法：当实体的主键不存在时，则添加；实体的主键存在时，则更新
         */
        areaDao.save(area);
        return "redirect:/seals";
    }

    /**
     * 根据主键 id 删除区域
     *
     * @return
     */
    @GetMapping("/seals/del/{id}")
    public String deleteAreaById(@PathVariable("id") Integer id) {
        areaDao.deleteById(id);
        return "redirect:/seals";
    }


    /**
     * 删除表中所有数据
     *
     * @return
     */
    @GetMapping("seals/delAll")
    public String deleteAll() {
        areaDao.deleteAll();
        return "redirect:/seals";
    }

    /**
     * 另外还有分页查询、排序查询等，在此就不再一一测试
     */
}
