package com.xiaoyue.ssm.mapperImpl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.xiaoyue.ssm.mapper.UserMapper;
import com.xiaoyue.ssm.pojo.User;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    @Override
    public Integer selectUser(HashMap<String, Object> map) {
	SqlSession sqlSession = this.getSqlSession();
	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	 Integer count = mapper.selectUser(map);
	return count;
    }

   

  
}
