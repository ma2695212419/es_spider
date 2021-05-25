package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.Roles;

public interface RolesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}