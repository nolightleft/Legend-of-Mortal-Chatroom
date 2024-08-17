package com.nolightleft.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nolightleft.chatroom.entity.User;
import com.nolightleft.chatroom.repository.UserRepository;

/**
 * <p>
 * Title: {@link UserService}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Service
public class UserService extends AbstractService<User>{
	
	@Autowired
	private UserRepository mUserRepository;

	/* (non-Javadoc)
	 * @see com.nolightleft.chatroom.service.AbstractService#getRepository()
	 */
	@Override
	public JpaRepository<User, Long> getRepository() {
		return mUserRepository;
	}
}
