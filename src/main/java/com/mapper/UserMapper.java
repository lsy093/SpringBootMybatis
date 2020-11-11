package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pojo.User;

@Repository
public interface UserMapper {

	public User select(@Param("id") int id);

	public List<User> userList();

	public void save(User user);

	public int delete(@Param("id") int id);
	
	public User findUserById(@Param("id") int id);
	
	public int update(@Param("id") int id, User user);

	public void upload(@Param("users")List<User> users) throws DataAccessException;


	
}
