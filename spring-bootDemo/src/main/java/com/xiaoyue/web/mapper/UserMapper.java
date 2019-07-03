package com.xiaoyue.web.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
	@Select("SELECT *FROM USER WHERE username=#{user.name} AND PASSWORD=#{user.password}")
    Integer selectUser(HashMap<String , Object> map) ; 
}
