package com.projects.gradesubmissionbackend.service;

import com.projects.gradesubmissionbackend.entity.User;

public interface UserService {
	User getUser(Long id);
	User getUser(String username);
	User saveUser(User user);
}
