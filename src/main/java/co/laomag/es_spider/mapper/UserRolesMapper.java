package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.UserRoles;

public interface UserRolesMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}