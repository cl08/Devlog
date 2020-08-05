package com.ssafy.devlog.service;

import java.util.List;

import com.ssafy.devlog.dto.UserNeighbor;

public interface UserNeighborService {
	
	public List<UserNeighbor> selectAllUserNeighbor(int seq_user);
	public int insertUserNeighbor(UserNeighbor userNeighbor);
	public int deleteUserNeighbor(int seq);
	
}