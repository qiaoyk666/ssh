package com.ssh.service.impl;

import org.springframework.stereotype.Service;

import com.ssh.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	public String test() {
		return "test";
	}

}
