package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}