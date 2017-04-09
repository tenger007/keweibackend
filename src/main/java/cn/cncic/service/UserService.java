package cn.cncic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User byId(long id){
		return this.userRepository.findOne(id);
	}
}
