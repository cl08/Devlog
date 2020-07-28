package com.ssafy.devlog.service;

import java.util.List;

import com.ssafy.devlog.dto.User;

public interface UserService {
	public List<User> selectAllUser();
	public User selectUserBySeq(int seq);
	public User selectUserById(String id);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(int seq);
}
