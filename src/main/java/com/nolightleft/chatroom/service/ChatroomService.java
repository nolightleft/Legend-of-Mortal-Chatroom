package com.nolightleft.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nolightleft.chatroom.entity.Chatroom;
import com.nolightleft.chatroom.repository.ChatroomRepository;

/**
 * <p>
 * Title: {@link ChatroomService}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
@Service
public class ChatroomService extends AbstractService<Chatroom>{
	
	@Autowired
	private ChatroomRepository mChatroomRepository;

	/* (non-Javadoc)
	 * @see com.nolightleft.chatroom.service.AbstractService#getRepository()
	 */
	@Override
	public JpaRepository<Chatroom, Long> getRepository() {
		return mChatroomRepository;
	}
}
