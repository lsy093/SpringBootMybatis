package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.pojo.User;

@Repository
public interface UserMapper {

	User select(@Param("id") int id);

	List<User> userList();

	void save(User user);

	int delete(@Param("id") int id);
	
	User findUserById(@Param("id") int id);
	
	int update(@Param("id") int id, User user);
	
}
