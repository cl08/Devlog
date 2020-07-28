package com.ssafy.devlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.devlog.dto.UserStack;

@Mapper
public interface UserStackMapper {

	public List<UserStack> selectAllUserStack(int seq_user);
	public int insertUserStack(UserStack userStack);
	public int deleteUserStack(int seq);
	
}
