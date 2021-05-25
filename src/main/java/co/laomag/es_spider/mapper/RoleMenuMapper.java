package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.RoleMenu;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(String id);

    List<RoleMenu> selectByMenuId(String menu_id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}