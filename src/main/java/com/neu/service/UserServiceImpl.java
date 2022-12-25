package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.UserMapper;
import com.neu.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String userName) {
		return userMapper.findUserByName(userName);
	}

	/**
	 * 登录验证方法的实现
	 */
	public boolean isLogin(User user) {
		//代码编写处
		String userName = user.getUserName();
		String password = user.getPassword();
		User user1 = this.getUser(userName);
		if (userName.equals(user1.getUserName()) && password.equals(user1.getPassword())){
			return true;

		}else {
			return false;
		}
		 //请自行修改代码
	}

	public List<User> getUsers() {
		
		return userMapper.findAll();
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	@Override
	public boolean delect(String id) {
		boolean delecte = userMapper.delecte(id);
		return delecte;
	}

	@Override
	public void update(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		String id = user.getId();
		userMapper.update(id,userName,password);
	}

	@Override
	public User findById(String id) {
		User byId = userMapper.findById(id);
		return byId;
	}

	@Override
	public List<User> select(String userName) {
		List<User> select = userMapper.select(userName);
		return select;
	}

}
