package com.service;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.mapper.UserMapper;
import com.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	public List<User> userList() {
		return userMapper.userList();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		userMapper.save(user);;
	}

	public User get(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

	public int update(Integer id, User user) {
		// TODO Auto-generated method stub
		return userMapper.update(id, user);
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userMapper.delete(id);
	}
	
	public void upload(MultipartFile file) throws IOException {
		//getInputStream() 方法  返回InputStream读取文件的内容
		InputStream input = file.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
		
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
		CsvSchema csvSchema = csvMapper.schemaFor(User.class).withHeader(); 
		MappingIterator<User> it = csvMapper.readerFor(User.class).with(csvSchema).readValues(reader);
		List<User> users = new ArrayList<User>();
		while (it.hasNextValue()) {
			
			users.add(it.nextValue());
			
		}
		userMapper.upload(users);
		   
	}

}
