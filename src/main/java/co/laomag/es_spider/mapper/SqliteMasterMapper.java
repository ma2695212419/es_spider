package co.laomag.es_spider.mapper;

import co.laomag.es_spider.models.SqliteMaster;

public interface SqliteMasterMapper {
    int insert(SqliteMaster record);

    int insertSelective(SqliteMaster record);
}