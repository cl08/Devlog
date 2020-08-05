package com.ssafy.devlog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.devlog.dto.UserNeighbor;
import com.ssafy.devlog.service.JwtService;
import com.ssafy.devlog.service.UserNeighborService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/userneighbor")
public class UserNeighborController {

	private static final Logger logger = LoggerFactory.getLogger(UserNeighborController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserNeighborService userNeighborService;

	@Autowired
	private JwtService jwtService;
	
	@ApiOperation(value = "유저의 모든 이웃을 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<UserNeighbor>> selectAllUserNeighbor() throws Exception {
		logger.debug("selectAllUserNeighbor - 호출");
		int seq_user = jwtService.getSeq();
		return new ResponseEntity<List<UserNeighbor>>(userNeighborService.selectAllUserNeighbor(seq_user),
				HttpStatus.OK);
	}

	@ApiOperation(value = "유저에 이웃을 추가한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertUserNeighbor(@RequestBody UserNeighbor userNeighbor) throws Exception {
		logger.debug("insertUserNeighbor - 호출");
		userNeighbor.setSeq_user(jwtService.getSeq());
		if (userNeighborService.insertUserNeighbor(userNeighbor) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "유저의 이웃을 삭제한다.", response = String.class)
	@DeleteMapping(value = "/{seq}")
	public ResponseEntity<String> deleteUserNeighbor(@PathVariable int seq) throws Exception {
		logger.debug("deleteUserNeighbor - 호출");
		if (userNeighborService.deleteUserNeighbor(seq) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}