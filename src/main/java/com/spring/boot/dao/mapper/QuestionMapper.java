package com.spring.boot.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class QuesstionMapper {

    @Insert("insert into question(title,descrip,gmt_create,gmt_modified,creator,tag) values (#{title},#{descrip},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    void create(Quesstion quesstion) {

    }
}
