package com.spring.boot.dao.mapper;

import com.spring.boot.model.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper // 标识这是一个MyBatis的数据库操作接口
@Component
public interface CountryMapper {

    @Select("select * from country where name = #{name}")
    Country findByName(@Param("name")String name);

    @Insert("insert into country(id,name) values(#{id},#{name})")
    int insert(@Param("name")String name,@Param("id")Integer id);

    @Delete("delete from country where name = #{name}")
    int delete(@Param("name")String name);

    @Select("select * from country")
    List<Country> getAllCountry();

}
