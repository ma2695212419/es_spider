package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    List<Menu> selectAll();

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}