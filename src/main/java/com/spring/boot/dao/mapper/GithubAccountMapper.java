package com.spring.boot.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GiehubAccountMapper {
    @Insert("insert into githubuser(account_id,account_name,token,gmt_create,gmt_modified) values (#{accountId},#{accountName},#{token},#{gmtCreate},#{gmtModified})")
    public int insert
}
